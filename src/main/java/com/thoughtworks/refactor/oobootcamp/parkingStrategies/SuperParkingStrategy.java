package com.thoughtworks.refactor.oobootcamp.parkingStrategies;

import com.thoughtworks.refactor.oobootcamp.ParkingLot;

import java.util.Comparator;

public class SuperParkingStrategy implements ParkingStrategy {
    @Override
    public Comparator<ParkingLot> compare() {
        return (p1, p2) -> Double.compare(p1.vacancyRate(), p2.vacancyRate());
    }
}