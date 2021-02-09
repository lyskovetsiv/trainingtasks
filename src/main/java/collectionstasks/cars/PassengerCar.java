package collectionstasks.cars;

import collectionstasks.models.ComfortLevel;

import java.util.Objects;

public class PassengerCar extends Car{
    private ComfortLevel comfortLevel;
    private int passengerSeats;

    public PassengerCar(String model, int maxSpeed, int fuelConsumption, int price, ComfortLevel comfortLevel, int passengerSeats) {
        super(model, maxSpeed, fuelConsumption, price);
        this.comfortLevel = comfortLevel;
        this.passengerSeats = passengerSeats;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public int getPassengerSeats() {
        return passengerSeats;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", level=" + comfortLevel +
                ", passengerSeats=" + passengerSeats +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerCar)) return false;
        if (!super.equals(o)) return false;
        PassengerCar that = (PassengerCar) o;
        return passengerSeats == that.passengerSeats &&
                comfortLevel == that.comfortLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comfortLevel, passengerSeats);
    }
}
