package org.example.strategy;

class PromotionalRouteBillingStrategy implements BillingStrategy {
    private static final double DISCOUNT_FACTOR = 0.70; // 30% знижки для нових маршрутів

    @Override
    public String getStrategyName() {
        return "Пільговий тариф для нових маршрутів";
    }

    @Override
    public double calculate(FlightBillingContext context) {
        double baseAmount = context.getAircraftWeightTons() * 1850.0;
        double total = baseAmount * DISCOUNT_FACTOR;
        System.out.println("[12:04] [Strategy:" + getStrategyName() + "] Розрахунок для рейсу "
                + context.getFlightNumber() + ": (" + String.format("%.2f", baseAmount)
                + " грн) зі знижкою 30% = " + String.format("%.2f", total) + " грн");
        return total;
    }
}
