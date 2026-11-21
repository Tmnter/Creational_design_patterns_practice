package org.example.airport_Visitor;

public class Terminal implements InfrastructureObject {
    private final String id;
    private final String name;
    private final int areaSqMeters;
    private final int gatesCount;
    private boolean fireInspectionPassed;

    public Terminal(String id, String name, int areaSqMeters, int gatesCount) {
        this.id = id;
        this.name = name;
        this.areaSqMeters = areaSqMeters;
        this.gatesCount = gatesCount;
        this.fireInspectionPassed = false;
    }

    public int getAreaSqMeters() {
        return areaSqMeters;
    }

    public int getGatesCount() {
        return gatesCount;
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
        return String.format("Terminal[%s, %dм², виходів=%d, пож.перевірка=%s]",
                id, areaSqMeters, gatesCount,
                fireInspectionPassed ? "ПРОЙДЕНО" : "НЕ ПЕРЕВІРЕНО");
    }

    @Override
    public void accept(AirportVisitor visitor) {
        visitor.visitTerminal(this);
    }
}