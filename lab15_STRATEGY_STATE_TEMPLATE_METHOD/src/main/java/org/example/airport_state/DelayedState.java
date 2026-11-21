package org.example.airport_state;

public class DelayedState implements FlightState {
    private final String reason;

    public DelayedState(String reason) {
        this.reason = reason;
    }

    @Override
    public String getName() {
        return "Затриманий (" + reason + ")";
    }

    @Override
    public void resumeCheckIn(Flight flight) {
        FlightDemoRunner.log("State:" + getName(),
                "Відновлення реєстрації для рейсу " + flight.getFlightNumber() + " після затримки.");
        flight.setState(new CheckInState());
    }

    @Override
    public void openCheckIn(Flight flight) {
        FlightState previous = flight.getStateBeforeDelay();
        if (previous instanceof ScheduledState) {
            FlightDemoRunner.log("State:" + getName(),
                    "Відкриття реєстрації для затриманого рейсу " + flight.getFlightNumber() + ".");
            flight.setState(new CheckInState());
        } else {
            reject(flight, "відкрити реєстрацію з поточного стану затримки");
        }
    }

    @Override
    public void cancel(Flight flight, String reason) {
        FlightDemoRunner.log("State:" + getName(),
                "Затриманий рейс " + flight.getFlightNumber() + " скасовано до вильоту. Причина: " + reason);
        flight.setState(new CancelledState(reason));
    }
}