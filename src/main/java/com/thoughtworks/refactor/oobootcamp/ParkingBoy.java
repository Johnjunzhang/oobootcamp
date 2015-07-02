package com.thoughtworks.refactor.oobootcamp;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private final ParkingStrategy parkingStrategy;
    protected List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public Ticket park(Car car) throws ParkingLotFullException {
        ParkingLot parkingLot = getParkingLot();

        if (!parkingLot.isFull()) {
            return parkingLot.park(car);
        }

        throw new ParkingLotFullException();
    }

    protected ParkingLot getParkingLot() {
        return parkingStrategy.getParkingLot(parkingLots);
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
