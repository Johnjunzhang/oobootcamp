package com.thoughtworks.refactor.oobootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuperParkingBoyTest {

    private final Car car = new Car("111111");

    @Test
    public void should_park_a_car_by_super_parking_boy() throws ParkingLotFullException {
        ParkingBoy parkingBoy = getParkingBoy();

        ParkingLot parkingLot1 = new ParkingLot(3);
        parkingBoy.manage(parkingLot1);
        parkingLot1.park(new Car("2222222"));

        ParkingLot parkingLot2 = new ParkingLot(5);
        parkingBoy.manage(parkingLot2);
        parkingLot2.park(new Car("33333333"));
        parkingLot2.park(new Car("44444444"));

        parkingBoy.park(car);
        assertEquals(1, parkingLot1.remainingLots());
    }

    private ParkingBoy getParkingBoy() throws ParkingLotFullException {
        return new ParkingBoy(new SuperParkingStrategy());
    }
}
