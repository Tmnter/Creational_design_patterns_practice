package org.example.airport_state;

import java.util.Objects;

public class Flight {
    private final String flightNumber;
    private String gate;
    private FlightState currentState;
    private FlightState stateBeforeDelay;

    public Flight(String flightNumber, String initialGate) {
        this.flightNumber = Objects.requireNonNull(flightNumber);
        this.gate = Objects.requireNonNull(initialGate);
        this.currentState = new ScheduledState();
        FlightDemoRunner.log("Flight:" + flightNumber,
                "Створено рейс (вихід " + gate + "). Поточний стан: " + currentState.getName());
    }

    void setState(FlightState newState) {
        String oldName = this.currentState.getName();
        this.currentState = Objects.requireNonNull(newState);
        FlightDemoRunner.log("Flight:" + flightNumber,
                "Зміна стану [State: " + currentState.getName() + "]: " + oldName + " -> " + newState.getName());
    }

    void saveStateBeforeDelay(FlightState previousState) {
        this.stateBeforeDelay = previousState;
    }

    FlightState getStateBeforeDelay() {
        return stateBeforeDelay;
    }

    void setGateInternal(String newGate) {
        String oldGate = this.gate;
        this.gate = newGate;
        FlightDemoRunner.log("Flight:" + flightNumber,
                "Вихід на посадку змінено з " + oldGate + " на " + newGate + " [State: " + currentState.getName() + "]");
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getGate() {
        return gate;
    }

    public String getStateName() {
        return currentState.getName();
    }

    public void openCheckIn() {
        currentState.openCheckIn(this);
    }

    public void registerPassenger(String passengerName) {
        currentState.registerPassenger(this, passengerName);
    }

    public void changeGate(String newGate) {
        currentState.changeGate(this, newGate);
    }

    public void startBoarding() {
        currentState.startBoarding(this);
    }

    public void takeOff() {
        currentState.takeOff(this);
    }

    public void land() {
        currentState.land(this);
    }

    public void delay(String reason) {
        currentState.delay(this, reason);
    }

    public void resumeCheckIn() {
        currentState.resumeCheckIn(this);
    }

    public void cancel(String reason) {
        currentState.cancel(this, reason);
    }
}