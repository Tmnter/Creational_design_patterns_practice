package org.example.airport_state;

public class CancelledState implements FlightState {
    private final String reason;

    public CancelledState(String reason) {
        this.reason = reason;
    }

    @Override
    public String getName() {
        return "Скасований (" + reason + ")";
    }
}