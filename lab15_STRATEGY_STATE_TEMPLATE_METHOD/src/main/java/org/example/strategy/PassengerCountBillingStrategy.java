package org.example.strategy;

class PassengerCountBillingStrategy implements BillingStrategy {
    private static final double RATE_PER_PASSENGER = 420.0;

    @Override
    public String getStrategyName() {
        return "За кількістю пасажирів";
    }

    @Override
    public double calculate(FlightBillingContext context) {
        double total = context.getPassengerCount() * RATE_PER_PASSENGER;
        System.out.println("[12:02] [Strategy:" + getStrategyName() + "] Розрахунок для рейсу "
                + context.getFlightNumber() + ": " + context.getPassengerCount()
                + " пас. * " + RATE_PER_PASSENGER + " грн/пас. = " + String.format("%.2f", total) + " грн");
        return total;
    }
}
