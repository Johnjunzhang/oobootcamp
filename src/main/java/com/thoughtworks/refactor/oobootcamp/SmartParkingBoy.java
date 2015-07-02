package com.thoughtworks.refactor.oobootcamp;

public class SmartParkingBoy extends ParkingBoy{
    @Override
    protected ParkingLot getParkingLot() {
        return parkingLots.stream().max((p1, p2) -> p1.remainingLots() - p2.remainingLots()).get();
    }
}
