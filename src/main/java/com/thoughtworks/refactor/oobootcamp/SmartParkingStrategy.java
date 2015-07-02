package com.thoughtworks.refactor.oobootcamp;

import java.util.List;

public class SmartParkingStrategy implements ParkingStrategy{
    public ParkingLot getParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max((p1, p2) -> p1.remainingLots() - p2.remainingLots()).get();
    }
}