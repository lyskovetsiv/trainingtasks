package threadstask;

public class AppStarter {
    public static Parking createParking() {
        Parking park = new Parking(1, 5);

        park.addToPlace(new ParkingPlace(1, park.getParkNumber()));
        park.addToPlace(new ParkingPlace(2, park.getParkNumber()));
        park.addToPlace(new ParkingPlace(3, park.getParkNumber()));
        park.addToPlace(new ParkingPlace(4, park.getParkNumber()));
        park.addToPlace(new ParkingPlace(5, park.getParkNumber()));
        return park;
    }

    public static void main(String[] args) {
        ParkingPool pool = new ParkingPool();
        pool.addToPool(createParking());

        for (int i = 0; i < 50; i++) {
            new Car(pool).start();
        }
    }
}

