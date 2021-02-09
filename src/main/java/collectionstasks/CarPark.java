package collectionstasks;

import collectionstasks.cars.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarPark {
    private List<? extends Car> cars;

    public CarPark(List<? extends  Car> cars) {
        this.cars = cars;
    }

    public List<? extends Car> getCars() {
        return cars;
    }

    public int getCarsPrice(List<? extends Car> carList) {
        int totalPrice = 0;
        for (Car car : carList) {
            totalPrice += car.getPrice();
        }
        return totalPrice;
    }

    public CarPark sortByFuelConsumption() {
        cars.sort((Comparator<Car>) (o1, o2) -> o1.getFuelConsumption() - o2.getFuelConsumption());
        return this;
    }

    public List<? extends Car> getCarBySpeedRange(int minSpeedRequired, int maxSpeedRequired) {
        List<Car> carsWithRequiredSpeedRange = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() > minSpeedRequired && car.getMaxSpeed() < maxSpeedRequired) {
                carsWithRequiredSpeedRange.add(car);
            }
        }
        return carsWithRequiredSpeedRange;
    }
}
