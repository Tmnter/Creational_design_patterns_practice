package org.example.strategy;

public interface BillingStrategy {
    String getStrategyName();
    double calculate(FlightBillingContext context);
}
