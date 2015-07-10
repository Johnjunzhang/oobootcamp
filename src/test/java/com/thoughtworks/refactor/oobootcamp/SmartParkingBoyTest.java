package com.thoughtworks.refactor.oobootcamp;

import com.thoughtworks.refactor.oobootcamp.exceptions.ParkingLotFullException;
import com.thoughtworks.refactor.oobootcamp.parkingStrategies.SmartParkingStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SmartParkingBoyTest {

    private final Car car = new Car("111111");

    @Test
    public void should_park_a_car_by_parking_boy() throws ParkingLotFullException {
        ParkingBoy parkingBoy = getParkingBoy();

        ParkingLot parkingLot = new ParkingLot(2);
        parkingBoy.manage(parkingLot);

        parkingBoy.park(car);
        assertEquals(1, parkingLot.remainingLots());
    }

    private void manageParkingLot(ParkingBoy parkingBoy) {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingBoy.manage(parkingLot);
    }

    private ParkingBoy getParkingBoy() {
        ParkingBoy parkingBoy = new ParkingBoy(new SmartParkingStrategy());
        manageParkingLot(parkingBoy);
        return parkingBoy;
    }
}
