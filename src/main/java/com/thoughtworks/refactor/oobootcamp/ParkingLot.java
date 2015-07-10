package com.thoughtworks.refactor.oobootcamp;

import com.thoughtworks.refactor.oobootcamp.exceptions.ParkingLotFullException;

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
        if (isFull())
            throw new ParkingLotFullException();

        ParkedCar parkedCar = new ParkedCar(car);
        parkedCars.add(parkedCar);
        return parkedCar.getTicket();
    }

    public int remainingLots() {
        return poolNum - parkedCars.size();
    }

    public double vacancyRate() {
        return (double)remainingLots()/poolNum;
    }

    public boolean isFull() {return remainingLots() == 0;}

    public Car fetch(Ticket ticket) {
        List<ParkedCar> parkedCars = getParkedCars(ticket);

        if (!isCarIn(parkedCars))
            return null;

        return parkedCars.get(0).getCar();
    }

    public boolean isCarIn(Ticket ticket){
        List<ParkedCar> parkedCars = getParkedCars(ticket);
        return isCarIn(parkedCars);
    }

    private boolean isCarIn(List<ParkedCar> parkedCars) {
        return parkedCars.size() != 0;
    }

    private List<ParkedCar> getParkedCars(Ticket ticket) {
        return this.parkedCars.stream()
                    .filter((parkedCar) -> parkedCar.isMatch(ticket))
                    .collect(Collectors.toList());
    }
}
