package org.example.strategy;

public class Task3StrategyDemo {
    public static void main(String[] args) {
        runThreeSchemesForOneFlight();
        System.out.println();
        runSwitchFromWeightToPromotional();
        System.out.println();
        runNightTariffScenario();
    }

    public static void runThreeSchemesForOneFlight() {
        System.out.println("--- Сценарій 1: Розрахунок одного рейсу за трьома схемами ---");
        FlightBillingContext flight = new FlightBillingContext(
                "BUK-204", "Bukovina Air", 68.0, 145, 95000.0, new WeightBasedBillingStrategy()
        );
        flight.calculateInvoice();

        flight.setStrategy(new PassengerCountBillingStrategy());
        flight.calculateInvoice();

        flight.setStrategy(new FixedContractBillingStrategy());
        flight.calculateInvoice();
    }

    public static void runSwitchFromWeightToPromotional() {
        System.out.println("--- Сценарій 2: Зміна схеми з 'за вагою' на 'пільгова' ---");
        FlightBillingContext flight = new FlightBillingContext(
                "BUK-310", "Carpathian Wings", 54.0, 110, 80000.0, new WeightBasedBillingStrategy()
        );
        flight.calculateInvoice();

        flight.setStrategy(new PromotionalRouteBillingStrategy());
        flight.calculateInvoice();
    }

    public static void runNightTariffScenario() {
        System.out.println("--- Сценарій 3: Розрахунок за новою схемою 'нічний тариф' ---");
        FlightBillingContext flight = new FlightBillingContext(
                "BUK-777N", "Bukovina Air", 68.0, 145, 95000.0, new NightTariffBillingStrategy()
        );
        flight.calculateInvoice();
    }
}
