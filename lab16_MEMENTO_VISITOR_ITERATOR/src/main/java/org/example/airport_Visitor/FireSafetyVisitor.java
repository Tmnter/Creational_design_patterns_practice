package org.example.airport_Visitor;

public class FireSafetyVisitor implements AirportVisitor {
    private int checkedCount = 0;

    public int getCheckedCount() {
        return checkedCount;
    }

    @Override
    public void visitRunway(Runway runway) {
        boolean ok = runway.getLengthMeters() >= 1500;
        runway.setFireInspectionPassed(ok);
        checkedCount++;
        EventLogger.log("FireSafetyVisitor", String.format(
                "Перевірка ЗПС '%s': %s",
                runway.getName(), ok ? "Пройдено" : "Потребує уваги"));
    }

    @Override
    public void visitTerminal(Terminal terminal) {
        boolean ok = terminal.getGatesCount() > 0 && terminal.getAreaSqMeters() > 0;
        terminal.setFireInspectionPassed(ok);
        checkedCount++;
        EventLogger.log("FireSafetyVisitor", String.format(
                "Перевірка термінала '%s': %s",
                terminal.getName(), ok ? "Пройдено" : "Потребує уваги"));
    }

    @Override
    public void visitJetBridge(JetBridge jetBridge) {
        boolean ok = jetBridge.getCyclesCompleted() < 50000;
        jetBridge.setFireInspectionPassed(ok);
        checkedCount++;
        EventLogger.log("FireSafetyVisitor", String.format(
                "Перевірка телетрапа '%s': %s",
                jetBridge.getName(), ok ? "Пройдено" : "Потребує уваги"));
    }

    @Override
    public void visitFuelStorage(FuelStorage fuelStorage) {
        boolean ok = fuelStorage.getCurrentLiters() <= fuelStorage.getCapacityLiters() * 0.9;
        fuelStorage.setFireInspectionPassed(ok);
        checkedCount++;
        EventLogger.log("FireSafetyVisitor", String.format(
                "Перевірка паливного сховища '%s': %s (заповнення %.1f%%)",
                fuelStorage.getName(),
                ok ? "Пройдено" : "Перевищено допустимий рівень",
                (fuelStorage.getCurrentLiters() / fuelStorage.getCapacityLiters()) * 100.0));
    }
}