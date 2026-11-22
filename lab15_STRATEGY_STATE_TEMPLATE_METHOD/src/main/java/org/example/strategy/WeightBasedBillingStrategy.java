package org.example.strategy;

class WeightBasedBillingStrategy implements BillingStrategy {
    private static final double RATE_PER_TON = 1850.0;

    @Override
    public String getStrategyName() {
        return "За вагою літака";
    }

    @Override
    public double calculate(FlightBillingContext context) {
        double total = context.getAircraftWeightTons() * RATE_PER_TON;
        System.out.println("[12:01] [Strategy:" + getStrategyName() + "] Розрахунок для рейсу "
                + context.getFlightNumber() + ": " + context.getAircraftWeightTons()
                + " т * " + RATE_PER_TON + " грн/т = " + String.format("%.2f", total) + " грн");
        return total;
    }
}
