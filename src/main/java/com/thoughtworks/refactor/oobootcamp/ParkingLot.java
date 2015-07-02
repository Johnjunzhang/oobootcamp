package com.thoughtworks.refactor.oobootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingLot {
    private int poolNum;
    private List<ParkedCar> parkedCars = new ArrayList<>();

    public ParkingLot(int poolNum) {
        this.poolNum = poolNum;
    }

    public Ticket park(Car car) throws ParkingLotFullException {
        if (isFull())
            throw new ParkingLotFullException();

        ParkedCar parkedCar = new ParkedCar(car);
        parkedCars.add(parkedCar);
        return parkedCar.getTicket();
    }

    public int remainingLots() {
        return poolNum - parkedCars.size();
    }

    public boolean isFull() {return remainingLots() == 0;}

    public Car fetch(Ticket ticket) {
        Optional<ParkedCar> parkedCar = getParkedCars(ticket);

        if (!parkedCar.isPresent())
            return null;

        return parkedCar.get().getCar();
    }

    public boolean isCarIn(Ticket ticket){
        Optional<ParkedCar> parkedCar = getParkedCars(ticket);
        return parkedCar.isPresent();
    }

    private java.util.Optional<ParkedCar> getParkedCars(Ticket ticket) {
        return this.parkedCars.stream()
                    .filter((parkedCar) -> parkedCar.isMatch(ticket))
                    .findFirst();
    }
}
