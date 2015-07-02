package com.thoughtworks.refactor.oobootcamp;

import java.util.List;

public interface ParkingStrategy {
    ParkingLot getParkingLot(List<ParkingLot> parkingLots);
}
