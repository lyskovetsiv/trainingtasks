package threadstask;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ParkingPlace {
    private int placeNumber;
    private int parkingNumber;

    public ParkingPlace(int placeNumber, int parkingNumber) {
        super();
        this.placeNumber = placeNumber;
        this.parkingNumber = parkingNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void placeIsTaken() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
