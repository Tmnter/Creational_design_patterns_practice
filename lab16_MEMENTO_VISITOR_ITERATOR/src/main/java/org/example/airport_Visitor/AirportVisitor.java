package org.example.airport_Visitor;

public interface AirportVisitor {
    void visitRunway(Runway runway);
    void visitTerminal(Terminal terminal);
    void visitJetBridge(JetBridge jetBridge);
    void visitFuelStorage(FuelStorage fuelStorage);
}