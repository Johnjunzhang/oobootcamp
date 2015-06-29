package com.thoughtworks.refactor.oobootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {
    private int poolNum;
    private List<ParkedCar> parkedCars = new ArrayList<>();

    public ParkingLot(int poolNum) {
        this.poolNum = poolNum;
    }

    public Ticket park(Car car) throws ParkingLotFullException {
        if (remainingLots() == 0)
            throw new ParkingLotFullException();

        ParkedCar parkedCar = new ParkedCar(car);
        parkedCars.add(parkedCar);
        return parkedCar.getTicket();
    }

    public int remainingLots() {
        return poolNum - parkedCars.size();
    }

    public Car fetch(Ticket ticket) {
        List<ParkedCar> parkedCars = this.parkedCars.stream()
                .filter((parkedCar) -> parkedCar.isMatch(ticket))
                .collect(Collectors.toList());

        if (parkedCars.size() == 0)
            return null;

        return parkedCars.get(0).getCar();
    }
}
