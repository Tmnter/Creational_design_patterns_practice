package org.example.airport_state;

public interface FlightState {
    String getName();

    default void openCheckIn(Flight flight) {
        reject(flight, "відкрити реєстрацію");
    }

    default void registerPassenger(Flight flight, String passengerName) {
        reject(flight, "зареєструвати пасажира '" + passengerName + "'");
    }

    default void changeGate(Flight flight, String newGate) {
        reject(flight, "змінити вихід на " + newGate);
    }

    default void startBoarding(Flight flight) {
        reject(flight, "розпочати посадку");
    }

    default void takeOff(Flight flight) {
        reject(flight, "здійснити виліт");
    }

    default void land(Flight flight) {
        reject(flight, "зафіксувати приземлення");
    }

    default void delay(Flight flight, String reason) {
        reject(flight, "затримати рейс (" + reason + ")");
    }

    default void resumeCheckIn(Flight flight) {
        reject(flight, "відновити реєстрацію");
    }

    default void cancel(Flight flight, String reason) {
        reject(flight, "скасувати рейс (" + reason + ")");
    }

    default void reject(Flight flight, String action) {
        FlightDemoRunner.log("State:" + getName(),
                "ВІДМОВА для рейсу " + flight.getFlightNumber() + ": неможливо " + action +
                        " у поточному стані '" + getName() + "'.");
    }
}
