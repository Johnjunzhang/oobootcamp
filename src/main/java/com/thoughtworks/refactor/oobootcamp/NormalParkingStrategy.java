package com.thoughtworks.refactor.oobootcamp;

import java.util.List;

public class NormalParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot;
            }
        }

        return parkingLots.get(0);
    }
}
