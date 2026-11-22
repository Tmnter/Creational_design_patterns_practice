package org.example.strategy;

class FixedContractBillingStrategy implements BillingStrategy {
    @Override
    public String getStrategyName() {
        return "Фіксований договірний тариф";
    }

    @Override
    public double calculate(FlightBillingContext context) {
        double total = context.getBaseContractRate();
        System.out.println("[12:03] [Strategy:" + getStrategyName() + "] Розрахунок для рейсу "
                + context.getFlightNumber() + ": договірна ставка = " + String.format("%.2f", total) + " грн");
        return total;
    }
}