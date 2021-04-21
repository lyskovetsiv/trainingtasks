package threadstask;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {
    private int parkNumber;
    private int size;
    private Semaphore semaphore;
    private Queue<ParkingPlace> places = new ConcurrentLinkedQueue<>();

    public Parking(int parkNumber, int size) {
        this.parkNumber = parkNumber;
        this.size = size;
        this.semaphore = new Semaphore(size, true);
    }

    public int getParkNumber() {
        return parkNumber;
    }

    public void setParkNumber(int parkNumber) {
        this.parkNumber = parkNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Queue<ParkingPlace> getPlaces() {
        Queue<ParkingPlace> parkingPlaces = new LinkedList<>();
        parkingPlaces.addAll(places);
        return parkingPlaces;
    }

    public void addToPlace(ParkingPlace place) {
        if (size >= 0) {
            places.add(place);
            size--;
        }
    }

    public ParkingPlace takePlace(long wait) {
        ParkingPlace placeReturn = null;
        try {
            if (semaphore.tryAcquire(wait, TimeUnit.MILLISECONDS)) {
                placeReturn = places.poll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return placeReturn;
    }

    public void releasePlace(ParkingPlace place) {
        places.add(place);
        semaphore.release();
    }
}
