package com.thoughtworks.refactor.oobootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingBoyTest {

    private final Car car = new Car("111111");
    private final Car car2 = new Car("222222");

    @Test
    public void should_park_a_car_by_parking_boy() throws ParkingLotFullException {
        ParkingBoy parkingBoy = getParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
    }

    @Test
    public void should_fetch_the_car_by_ticket_given_park_a_car() throws ParkingLotFullException {
        ParkingBoy parkingBoy = getParkingBoy();
        Ticket ticket = parkingBoy.park(car);

        Car fetchedCar = parkingBoy.fetch(ticket);
        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_park_the_car_given_second_parking_lot_is_available() throws ParkingLotFullException {
        ParkingBoy parkingBoy = getParkingBoy();
        manageParkingLot(parkingBoy);
        parkingBoy.park(car);

        Ticket ticket = parkingBoy.park(car2);
        assertNotNull(ticket);
    }

    @Test
    public void should_fetch_the_car_given_park_to_second_parking_lot() throws ParkingLotFullException {
        ParkingBoy parkingBoy = getParkingBoy();
        manageParkingLot(parkingBoy);
        parkingBoy.park(car);

        Ticket ticket = parkingBoy.park(car2);

        Car fetchedCar = parkingBoy.fetch(ticket);
        assertEquals(car2, fetchedCar);
    }

    private void manageParkingLot(ParkingBoy parkingBoy) {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingBoy.manage(parkingLot);
    }

    private ParkingBoy getParkingBoy() {
        ParkingBoy parkingBoy = new ParkingBoy(new NormalParkingStrategy());
        manageParkingLot(parkingBoy);
        return parkingBoy;
    }
}
