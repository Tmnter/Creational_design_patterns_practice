package org.example.airport_state;

public class DepartedState implements FlightState {
    @Override
    public String getName() {
        return "Вилетів";
    }

    @Override
    public void land(Flight flight) {
        FlightDemoRunner.log("State:" + getName(),
                "Рейс " + flight.getFlightNumber() + " успішно приземлився.");
        flight.setState(new LandedState());
    }
}