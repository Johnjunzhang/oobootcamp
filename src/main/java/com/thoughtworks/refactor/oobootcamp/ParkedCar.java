package com.thoughtworks.refactor.oobootcamp;

public class ParkedCar {
    private final Ticket ticket = new Ticket();
    private Car car;

    public ParkedCar(Car car) {
        this.car = car;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public boolean isMatch(Ticket ticket) {
        return ticket == this.ticket;
    }

    public Car getCar() {
        return car;
    }
}
