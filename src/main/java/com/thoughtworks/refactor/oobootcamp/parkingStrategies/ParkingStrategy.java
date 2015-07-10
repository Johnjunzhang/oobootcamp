package com.thoughtworks.refactor.oobootcamp.parkingStrategies;

import com.thoughtworks.refactor.oobootcamp.ParkingLot;

import java.util.List;

public interface ParkingStrategy {
    ParkingLot getParkingLot(List<ParkingLot> parkingLots);
}
