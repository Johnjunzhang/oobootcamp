package com.thoughtworks.refactor.oobootcamp;

public class SmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket park(Car car) throws ParkingLotFullException {
        ParkingLot parkingLot = parkingLots.stream().max((p1, p2) -> p1.remainingLots() - p2.remainingLots()).get();

        if (!parkingLot.isFull())
            return parkingLot.park(car);

        throw new ParkingLotFullException();
    }
}
