package threadstask;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingPool {
    private ReentrantLock lock = new ReentrantLock();
    private ArrayList<Parking> pool = new ArrayList<>();

    public ParkingPool() {
    }

    public void addToPool (Parking parking) {
        pool.add(parking);
    }

    public ParkingPlace getPlace(long wait) {
        ParkingPlace parkingReturn = null;
        for (Parking parking : pool) {
            ParkingPlace place = parking.takePlace(wait);
            if (place != null) {
                parkingReturn = place;
                break;
            }
            else {
                System.out.println("Car " + Thread.currentThread().getId() +
                        " Timeout. Car has gone to another parking");
            }
        }
        return parkingReturn;
    }

    public boolean returnPlace(ParkingPlace place) {
        boolean placeReturn = false;

        if (lock.tryLock()) {
            for (Parking parking : pool) {
                if (parking.getParkNumber() == place.getParkingNumber()) {
                    parking.releasePlace(place);
                }
            }
            placeReturn = true;
            lock.unlock();
        }
        return placeReturn;
    }
}
