package org.example.airport_Visitor;

public class MaintenanceCostVisitor implements AirportVisitor {
    private double totalCost = 0.0;

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public void visitRunway(Runway runway) {
        double cost = runway.getLengthMeters() * 45.0 + (runway.isDeicingReady() ? 12000.0 : 4000.0);
        totalCost += cost;
        EventLogger.log("MaintenanceCostVisitor", String.format(
                "ЗПС '%s' (%s): вартість обслуговування = %.2f грн",
                runway.getName(), runway.getId(), cost));
    }

    @Override
    public void visitTerminal(Terminal terminal) {
        double cost = terminal.getAreaSqMeters() * 18.0 + terminal.getGatesCount() * 3500.0;
        totalCost += cost;
        EventLogger.log("MaintenanceCostVisitor", String.format(
                "Термінал '%s' (%s): вартість обслуговування = %.2f грн",
                terminal.getName(), terminal.getId(), cost));
    }

    @Override
    public void visitJetBridge(JetBridge jetBridge) {
        double cost = 8500.0 + jetBridge.getCyclesCompleted() * 12.5;
        totalCost += cost;
        EventLogger.log("MaintenanceCostVisitor", String.format(
                "Телетрап '%s' (%s): вартість обслуговування = %.2f грн",
                jetBridge.getName(), jetBridge.getId(), cost));
    }

    @Override
    public void visitFuelStorage(FuelStorage fuelStorage) {
        double cost = 25000.0 + fuelStorage.getCurrentLiters() * 0.35;
        totalCost += cost;
        EventLogger.log("MaintenanceCostVisitor", String.format(
                "Паливне сховище '%s' (%s): вартість обслуговування = %.2f грн",
                fuelStorage.getName(), fuelStorage.getId(), cost));
    }
}