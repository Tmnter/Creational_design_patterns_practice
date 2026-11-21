package org.example.airport_Visitor;

public class FuelStorage implements InfrastructureObject {
    private final String id;
    private final String name;
    private final double capacityLiters;
    private final double currentLiters;
    private boolean fireInspectionPassed;

    public FuelStorage(String id, String name, double capacityLiters, double currentLiters) {
        this.id = id;
        this.name = name;
        this.capacityLiters = capacityLiters;
        this.currentLiters = currentLiters;
        this.fireInspectionPassed = false;
    }

    public double getCapacityLiters() {
        return capacityLiters;
    }

    public double getCurrentLiters() {
        return currentLiters;
    }

    public void setFireInspectionPassed(boolean fireInspectionPassed) {
        this.fireInspectionPassed = fireInspectionPassed;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStatusSummary() {
        return String.format("FuelStorage[%s, %.0f/%.0f л, пож.перевірка=%s]",
                id, currentLiters, capacityLiters,
                fireInspectionPassed ? "ПРОЙДЕНО" : "НЕ ПЕРЕВІРЕНО");
    }

    @Override
    public void accept(AirportVisitor visitor) {
        visitor.visitFuelStorage(this);
    }
}
