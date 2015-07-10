package com.thoughtworks.refactor.oobootcamp;

import com.thoughtworks.refactor.oobootcamp.exceptions.ParkingLotFullException;
import com.thoughtworks.refactor.oobootcamp.parkingStrategies.ParkingStrategy;

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
        return parkingLots.stream().max(parkingStrategy.compare()).get();
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
