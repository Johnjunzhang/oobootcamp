package com.thoughtworks.refactor.oobootcamp.parkingStrategies;

import com.thoughtworks.refactor.oobootcamp.ParkingLot;

import java.util.Comparator;
import java.util.List;

public interface ParkingStrategy {
    Comparator<ParkingLot> compare();
}
