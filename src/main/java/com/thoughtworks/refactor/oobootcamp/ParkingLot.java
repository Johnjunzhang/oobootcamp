package com.thoughtworks.refactor.oobootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private int poolNum;
    private List<ParkedCar> parkedCars = new ArrayList<>();

    public ParkingLot(int poolNum) {
        this.poolNum = poolNum;
    }

    public Ticket park(Car car) throws ParkingLotFullException {
        if (isFull())
            throw new ParkingLotFullException();

        return doPark(car);
    }

    public int remainingLots() {
        return poolNum - parkedCars.size();
    }

    public Car fetch(Ticket ticket) {
        Optional<ParkedCar> parkedCars = getParkedCar(ticket);

        if (!parkedCars.isPresent())
            return null;

        return parkedCars.get().getCar();
    }

    private Optional<ParkedCar> getParkedCar(Ticket ticket) {
        return this.parkedCars.stream()
                    .filter((parkedCar) -> parkedCar.isMatch(ticket)).findAny();
    }

    private boolean isFull() {
        return remainingLots() == 0;
    }

    private Ticket doPark(Car car) {
        ParkedCar parkedCar = new ParkedCar(car);
        parkedCars.add(parkedCar);
        return parkedCar.getTicket();
    }
}
