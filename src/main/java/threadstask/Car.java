package threadstask;

public class Car extends Thread {

    private boolean isTaken;
    private ParkingPool pool;

    public Car(ParkingPool pool) {
        this.pool = pool;
    }

    public void run() {
        this.setName("Car " + this.getId());
        ParkingPlace place = null;

        while (place == null) {
            place = pool.getPlace(500);
        }
        System.out.println("Car " + this.getId() + " has taken place " +
                place.getPlaceNumber() + " on parking " + place.getParkingNumber());
        isTaken = true;

        place.placeIsTaken();
        isTaken = false;
        System.out.println("Car " + this.getId() + " released " +
                "place " + place.getPlaceNumber() + ". on parking " + place.getParkingNumber());
        while (true) {
            if (pool.returnPlace(place)) {
                break;
            }
        }
    }

    public boolean isTaken() {
        return isTaken;
    }
}
