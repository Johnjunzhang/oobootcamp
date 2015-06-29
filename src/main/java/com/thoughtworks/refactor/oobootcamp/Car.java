package com.thoughtworks.refactor.oobootcamp;

public class Car {
    private String licencePlate;

    public Car(String licencePlate) {

        this.licencePlate = licencePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!licencePlate.equals(car.licencePlate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return licencePlate.hashCode();
    }
}
