package com.thoughtworks.refactor.oobootcamp.parkingStrategies;

import com.thoughtworks.refactor.oobootcamp.ParkingLot;

import java.util.List;

public class SuperParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max((p1, p2) -> Double.compare(p1.vacancyRate(), p2.vacancyRate())).get();
    }
}