package org.example.template;

public class Task2TemplateMethodDemo {
    public static void main(String[] args) {
        runPassengerFlightScenario();
        System.out.println();
        runCargoFlightScenario();
        System.out.println();
        runSanitaryFlightScenario();
    }

    public static void runPassengerFlightScenario() {
        System.out.println("--- Сценарій 1: Пасажирський рейс ---");
        FlightServiceTemplate passengerFlight = new PassengerFlightService("BUK-101");
        passengerFlight.serveFlight();
    }

    public static void runCargoFlightScenario() {
        System.out.println("--- Сценарій 2: Вантажний рейс ---");
        FlightServiceTemplate cargoFlight = new CargoFlightService("BUK-505C");
        cargoFlight.serveFlight();
    }

    public static void runSanitaryFlightScenario() {
        System.out.println("--- Сценарій 3: Санітарний рейс (додано одним класом) ---");
        FlightServiceTemplate sanitaryFlight = new SanitaryFlightService("BUK-911M");
        sanitaryFlight.serveFlight();
    }
}