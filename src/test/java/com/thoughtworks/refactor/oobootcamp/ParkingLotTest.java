package com.thoughtworks.refactor.oobootcamp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ParkingLotTest {
    private final Car car = new Car("111111");
    private final Car car2 = new Car("22222");

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private final ParkingLot parkingLot = new ParkingLot(20);

    @Test
    public void should_park_a_car_to_parking_lot() throws ParkingLotFullException {
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);
        assertEquals(19, parkingLot.remainingLots());
    }

    @Test
    public void should_fetch_the_parked_car_by_parked_ticket_given_park_one_car() throws ParkingLotFullException {
        Ticket ticket = parkingLot.park(car);

        Car fetchedCar = parkingLot.fetch(ticket);
        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_fetch_the_parked_car_by_parked_ticket_given_park_two_cars() throws ParkingLotFullException {
        this.parkingLot.park(car);
        Ticket ticket2 = parkingLot.park(car2);

        Car fetchedCar = parkingLot.fetch(ticket2);
        assertEquals(car2, fetchedCar);
    }

    @Test
    public void should_not_fetch_any_parked_car_given_a_wrong_ticket() throws ParkingLotFullException {
        parkingLot.park(car);

        Car fetchedCar = parkingLot.fetch(new Ticket());
        assertNull(fetchedCar);
    }

    @Test
    public void should_not_parked_car_successfully_given_parking_lot_is_full() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);

        thrown.expect(ParkingLotFullException.class);
        parkingLot.park(car2);
    }
}
