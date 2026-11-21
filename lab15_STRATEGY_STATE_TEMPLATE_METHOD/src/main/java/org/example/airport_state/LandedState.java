package org.example.airport_state;

public class LandedState implements FlightState {
    @Override
    public String getName() {
        return "Приземлився";
    }
}