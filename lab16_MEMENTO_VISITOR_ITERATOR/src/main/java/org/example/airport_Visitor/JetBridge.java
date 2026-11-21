package org.example.airport_Visitor;

public class JetBridge implements InfrastructureObject {
    private final String id;
    private final String name;
    private final int cyclesCompleted;
    private boolean fireInspectionPassed;

    public JetBridge(String id, String name, int cyclesCompleted) {
        this.id = id;
        this.name = name;
        this.cyclesCompleted = cyclesCompleted;
        this.fireInspectionPassed = false;
    }

    public int getCyclesCompleted() {
        return cyclesCompleted;
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
        return String.format("JetBridge[%s, циклів=%d, пож.перевірка=%s]",
                id, cyclesCompleted,
                fireInspectionPassed ? "ПРОЙДЕНО" : "НЕ ПЕРЕВІРЕНО");
    }

    @Override
    public void accept(AirportVisitor visitor) {
        visitor.visitJetBridge(this);
    }
}