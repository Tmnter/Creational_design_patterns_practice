package org.example.airport_Visitor;

public class Runway implements InfrastructureObject {
    private final String id;
    private final String name;
    private final int lengthMeters;
    private final boolean deicingReady;
    private boolean fireInspectionPassed;

    public Runway(String id, String name, int lengthMeters, boolean deicingReady) {
        this.id = id;
        this.name = name;
        this.lengthMeters = lengthMeters;
        this.deicingReady = deicingReady;
        this.fireInspectionPassed = false;
    }

    public int getLengthMeters() {
        return lengthMeters;
    }

    public boolean isDeicingReady() {
        return deicingReady;
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
        return String.format("Runway[%s, %dм, антиобледеніння=%s, пож.перевірка=%s]",
                id, lengthMeters, deicingReady ? "ОК" : "НІ",
                fireInspectionPassed ? "ПРОЙДЕНО" : "НЕ ПЕРЕВІРЕНО");
    }

    @Override
    public void accept(AirportVisitor visitor) {
        visitor.visitRunway(this);
    }
}