package org.example.airport_state;

public class ScheduledState implements FlightState {
    @Override
    public String getName() {
        return "Заплановано";
    }

    @Override
    public void openCheckIn(Flight flight) {
        FlightDemoRunner.log("State:" + getName(),
                "Виконується перехід у стан реєстрації для рейсу " + flight.getFlightNumber());
        flight.setState(new CheckInState());
    }

    @Override
    public void changeGate(Flight flight, String newGate) {
        FlightDemoRunner.log("State:" + getName(),
                "Зміна виходу дозволена до початку посадки для рейсу " + flight.getFlightNumber());
        flight.setGateInternal(newGate);
    }

    @Override
    public void delay(Flight flight, String reason) {
        FlightDemoRunner.log("State:" + getName(),
                "Рейс " + flight.getFlightNumber() + " затримано. Причина: " + reason);
        flight.saveStateBeforeDelay(this);
        flight.setState(new DelayedState(reason));
    }

    @Override
    public void cancel(Flight flight, String reason) {
        FlightDemoRunner.log("State:" + getName(),
                "Рейс " + flight.getFlightNumber() + " скасовано до вильоту. Причина: " + reason);
        flight.setState(new CancelledState(reason));
    }
}