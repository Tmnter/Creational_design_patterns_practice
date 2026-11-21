package org.example.airport_Visitor;

public interface InfrastructureObject {
    String getId();
    String getName();
    String getStatusSummary();
    void accept(AirportVisitor visitor);
}