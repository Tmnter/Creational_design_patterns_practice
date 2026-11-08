package org.example.equipment;

public interface AirportEquipmentFactory {
    Stairs createStairs();
    Tug createTug();
    Loader createLoader();
    String getPlaneType();
}