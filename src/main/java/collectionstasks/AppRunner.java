package collectionstasks;

import collectionstasks.cars.Car;
import collectionstasks.cars.CargoCar;
import collectionstasks.cars.PassengerCar;
import collectionstasks.models.ComfortLevel;
import collectionstasks.models.LiftingCapacity;

import java.util.Arrays;
import java.util.List;

public class AppRunner {
    static List<Car> cars = Arrays.asList(
            new CargoCar("Jumper", 195, 15, 30000, LiftingCapacity.MIDDLE, 6250),
            new CargoCar("Combi", 210, 18, 23000, LiftingCapacity.SMALL, 2450),
            new CargoCar("Rosa", 140, 23, 17000, LiftingCapacity.EXTRA_SMALL, 2000),
            new CargoCar("Pregio", 130, 7, 25500, LiftingCapacity.MIDDLE, 3200),
            new CargoCar("FE", 225, 6, 27800, LiftingCapacity.LARGE, 8500),
            new CargoCar("APV", 205, 29, 13280, LiftingCapacity.SMALL, 2150),
            new PassengerCar("A6", 250, 3, 15600, ComfortLevel.PREMIUM, 4),
            new PassengerCar("X5", 270, 3, 19200, ComfortLevel.ELITE, 5),
            new PassengerCar("C-HR", 195, 2, 13000, ComfortLevel.ECONOMY, 5),
            new PassengerCar("Logan", 180, 6, 8900, ComfortLevel.COMFORT, 4),
            new PassengerCar("ASX", 220, 5, 18900, ComfortLevel.PREMIUM, 5)
    );

    public static void main(String[] args) {
        CarPark carPark = new CarPark(cars);

        System.out.println("Full car list: " + carPark.getCars());
        System.out.println("Total cars price: " + carPark.getCarsPrice(cars));
        System.out.println("Cars with required speed Range: " + carPark.getCarBySpeedRange(155, 200));
        System.out.println("Cars sorted by fuelConsumption: " + carPark.sortByFuelConsumption().getCars());
    }
}
