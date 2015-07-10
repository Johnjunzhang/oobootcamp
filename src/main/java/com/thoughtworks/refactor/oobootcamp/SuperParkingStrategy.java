package com.thoughtworks.refactor.oobootcamp;

import java.util.List;

public class SuperParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max((p1, p2) -> p1.vacancyRate() - p2.vacancyRate()).get();
    }
}