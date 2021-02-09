package collectionstasks.cars;

import java.util.Objects;

public abstract class Car {
    private String model;
    private int maxSpeed;
    private int fuelConsumption;
    private int price;

    public Car(String model, int maxSpeed, int fuelConsumption, int price) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.price = price;

    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return maxSpeed == car.maxSpeed &&
                car.fuelConsumption == fuelConsumption &&
                car.price == price &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, fuelConsumption, price);
    }
}
