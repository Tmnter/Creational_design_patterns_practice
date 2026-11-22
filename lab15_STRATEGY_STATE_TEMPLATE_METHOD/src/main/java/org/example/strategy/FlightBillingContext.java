package org.example.strategy;

class FlightBillingContext {
    private final String flightNumber;
    private final String airlineName;
    private final double aircraftWeightTons;
    private final int passengerCount;
    private final double baseContractRate;
    private BillingStrategy strategy;

    public FlightBillingContext(String flightNumber,
                                String airlineName,
                                double aircraftWeightTons,
                                int passengerCount,
                                double baseContractRate,
                                BillingStrategy strategy) {
        this.flightNumber = flightNumber;
        this.airlineName = airlineName;
        this.aircraftWeightTons = aircraftWeightTons;
        this.passengerCount = passengerCount;
        this.baseContractRate = baseContractRate;
        this.strategy = strategy;
    }

    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
        System.out.println("[12:05] [BillingContext] Змінено тарифну схему для авіакомпанії '"
                + airlineName + "' на: " + strategy.getStrategyName());
    }

    public double calculateInvoice() {
        double amount = strategy.calculate(this);
        System.out.println("[12:06] [BillingContext] Рейс " + flightNumber
                + " (" + airlineName + ") | Стратегія: [" + strategy.getStrategyName()
                + "] | Сума до сплати: " + String.format("%.2f", amount) + " грн");
        return amount;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getAirlineName() { return airlineName; }
    public double getAircraftWeightTons() { return aircraftWeightTons; }
    public int getPassengerCount() { return passengerCount; }
    public double getBaseContractRate() { return baseContractRate; }
}