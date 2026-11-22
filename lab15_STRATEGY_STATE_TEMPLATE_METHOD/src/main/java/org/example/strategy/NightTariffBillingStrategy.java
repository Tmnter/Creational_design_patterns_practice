package org.example.strategy;

class NightTariffBillingStrategy implements BillingStrategy {
    private static final double NIGHT_MULTIPLIER = 0.80; // 20% знижки у нічний час

    @Override
    public String getStrategyName() {
        return "Нічний тариф";
    }

    @Override
    public double calculate(FlightBillingContext context) {
        double baseAmount = context.getAircraftWeightTons() * 1850.0;
        double total = baseAmount * NIGHT_MULTIPLIER;
        System.out.println("[12:07] [Strategy:" + getStrategyName() + "] Розрахунок для рейсу "
                + context.getFlightNumber() + ": (" + String.format("%.2f", baseAmount)
                + " грн) за нічним коефіцієнтом 0.80 = " + String.format("%.2f", total) + " грн");
        return total;
    }
}
