package org.example.airport_state;

public class BoardingState implements FlightState {
    @Override
    public String getName() {
        return "Посадка";
    }

    @Override
    public void takeOff(Flight flight) {
        FlightDemoRunner.log("State:" + getName(),
                "Посадку завершено, рейс " + flight.getFlightNumber() + " вилітає з виходу " + flight.getGate() + ".");
        flight.setState(new DepartedState());
    }

    @Override
    public void delay(Flight flight, String reason) {
        FlightDemoRunner.log("State:" + getName(),
                "Рейс " + flight.getFlightNumber() + " затримано під час посадки. Причина: " + reason);
        flight.saveStateBeforeDelay(this);
        flight.setState(new DelayedState(reason));
    }

    @Override
    public void cancel(Flight flight, String reason) {
        FlightDemoRunner.log("State:" + getName(),
                "Рейс " + flight.getFlightNumber() + " скасовано під час посадки (до вильоту). Причина: " + reason);
        flight.setState(new CancelledState(reason));
    }
}