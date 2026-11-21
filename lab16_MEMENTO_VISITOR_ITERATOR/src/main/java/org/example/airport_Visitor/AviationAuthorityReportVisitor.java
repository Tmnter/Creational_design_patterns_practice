package org.example.airport_Visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AviationAuthorityReportVisitor implements AirportVisitor {
    private final List<String> reportLines = new ArrayList<>();

    public List<String> getReportLines() {
        return Collections.unmodifiableList(reportLines);
    }

    @Override
    public void visitRunway(Runway runway) {
        String entry = String.format("ЗПС [%s] %s: довжина=%dм, антиобледеніння=%s",
                runway.getId(), runway.getName(), runway.getLengthMeters(), runway.isDeicingReady());
        reportLines.add(entry);
        EventLogger.log("AviationAuthorityReportVisitor", "Додано запис у звіт ДАС: " + entry);
    }

    @Override
    public void visitTerminal(Terminal terminal) {
        String entry = String.format("ТЕРМІНАЛ [%s] %s: площа=%dм², гейти=%d",
                terminal.getId(), terminal.getName(), terminal.getAreaSqMeters(), terminal.getGatesCount());
        reportLines.add(entry);
        EventLogger.log("AviationAuthorityReportVisitor", "Додано запис до звіту ДАС: " + entry);
    }

    @Override
    public void visitJetBridge(JetBridge jetBridge) {
        String entry = String.format("ТЕЛЕТРАП [%s] %s: циклів=%d",
                jetBridge.getId(), jetBridge.getName(), jetBridge.getCyclesCompleted());
        reportLines.add(entry);
        EventLogger.log("AviationAuthorityReportVisitor", "Додано запис до звіту ДАС: " + entry);
    }

    @Override
    public void visitFuelStorage(FuelStorage fuelStorage) {
        String entry = String.format("ПАЛИВО [%s] %s: залишок=%.0fл / місткість=%.0fл",
                fuelStorage.getId(), fuelStorage.getName(), fuelStorage.getCurrentLiters(), fuelStorage.getCapacityLiters());
        reportLines.add(entry);
        EventLogger.log("AviationAuthorityReportVisitor", "Додано запис до звіту ДАС: " + entry);
    }
}