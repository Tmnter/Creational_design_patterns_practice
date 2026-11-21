package org.example.airport_state;

public class CheckInState implements FlightState {
    @Override
    public String getName() {
        return "Реєстрація";
    }

    @Override
    public void registerPassenger(Flight flight, String passengerName) {
        FlightDemoRunner.log("State:" + getName(),
                "Пасажира '" + passengerName + "' успішно зареєстровано на рейс " + flight.getFlightNumber() +
                        " (вихід " + flight.getGate() + ").");
    }

    @Override
    public void changeGate(Flight flight, String newGate) {
        FlightDemoRunner.log("State:" + getName(),
                "Зміна виходу дозволена під час реєстрації (до початку посадки) для рейсу " + flight.getFlightNumber());
        flight.setGateInternal(newGate);
    }

    @Override
    public void startBoarding(Flight flight) {
        FlightDemoRunner.log("State:" + getName(),
                "Завершення реєстрації та початок посадки на рейс " + flight.getFlightNumber() +
                        " (вихід " + flight.getGate() + ").");
        flight.setState(new BoardingState());
    }

    @Override
    public void delay(Flight flight, String reason) {
        FlightDemoRunner.log("State:" + getName(),
                "Рейс " + flight.getFlightNumber() + " затримано під час реєстрації. Причина: " + reason);
        flight.saveStateBeforeDelay(this);
        flight.setState(new DelayedState(reason));
    }

    @Override
    public void cancel(Flight flight, String reason) {
        FlightDemoRunner.log("State:" + getName(),
                "Рейс " + flight.getFlightNumber() + " скасовано під час реєстрації (до вильоту). Причина: " + reason);
        flight.setState(new CancelledState(reason));
    }
}