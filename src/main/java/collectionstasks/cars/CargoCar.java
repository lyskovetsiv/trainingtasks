package collectionstasks.cars;

import collectionstasks.models.LiftingCapacity;

import java.util.Objects;

public class CargoCar extends Car {
    private LiftingCapacity liftingCapacity;
    private int maxLoadWeight;

    public CargoCar(String model, int maxSpeed, int fuelConsumption, int price, LiftingCapacity liftingCapacity, int maxLoadWeight) {
        super(model, maxSpeed, fuelConsumption, price);
        this.liftingCapacity = liftingCapacity;
        this.maxLoadWeight = maxLoadWeight;
    }

    public LiftingCapacity getLiftingCapacity() {
        return liftingCapacity;
    }

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", maxLoadWeight=" + maxLoadWeight +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoCar)) return false;
        if (!super.equals(o)) return false;
        CargoCar cargoCar = (CargoCar) o;
        return maxLoadWeight == cargoCar.maxLoadWeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxLoadWeight);
    }
}
