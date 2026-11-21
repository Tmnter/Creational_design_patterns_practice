package org.example.airport_Visitor;

import java.util.ArrayList;
import java.util.List;

public class AirportInfrastructure {
    private final String airportName;
    private final List<InfrastructureObject> objects = new ArrayList<>();

    public AirportInfrastructure(String airportName) {
        this.airportName = airportName;
    }

    public void addObject(InfrastructureObject obj) {
        objects.add(obj);
    }

    public void applyVisitor(AirportVisitor visitor) {
        for (InfrastructureObject obj : objects) {
            obj.accept(visitor);
        }
    }

    public void logState(String stageLabel) {
        EventLogger.log("AirportInfrastructure", "Стан об'єктів (" + airportName + ") [" + stageLabel + "]:");
        for (InfrastructureObject obj : objects) {
            EventLogger.log("AirportInfrastructure", "  - " + obj.getStatusSummary());
        }
    }
}