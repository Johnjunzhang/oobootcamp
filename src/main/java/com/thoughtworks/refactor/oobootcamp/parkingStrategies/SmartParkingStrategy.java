package com.thoughtworks.refactor.oobootcamp.parkingStrategies;

import com.thoughtworks.refactor.oobootcamp.ParkingLot;

import java.util.Comparator;

public class SmartParkingStrategy implements ParkingStrategy {
    @Override
    public Comparator<ParkingLot> compare() {
        return (p1, p2) -> p1.remainingLots() - p2.remainingLots();
    }
}
