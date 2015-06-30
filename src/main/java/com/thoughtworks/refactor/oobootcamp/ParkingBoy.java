package com.thoughtworks.refactor.oobootcamp;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public Ticket park(Car car) throws ParkingLotFullException {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }

        throw new ParkingLotFullException();
    }

    public void manage(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public Car fetch(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isCarIn(ticket)) {
                return parkingLot.fetch(ticket);
            }
        }
        return null;
    }
}
