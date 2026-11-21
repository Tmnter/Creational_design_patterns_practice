package org.example.airport_Visitor;

public class Main {

    public static void runVariant1Task1() {
        EventLogger.log("Runner", "=== Старт сценарію: Варіант 1, Завдання 1 (Аеропорт «Буковина») ===");

        AirportInfrastructure airport = new AirportInfrastructure("Аеропорт «Буковина»");
        airport.addObject(new Runway("RW-15", "Основна смуга 15/33", 2500, true));
        airport.addObject(new Terminal("TERM-A", "Пасажирський термінал А", 8400, 6));
        airport.addObject(new JetBridge("JB-01", "Телетрап виходу №1", 1420));
        airport.addObject(new FuelStorage("FUEL-01", "Авіапаливне сховище №1", 500000.0, 320000.0));

        airport.logState("ДО операцій");

        EventLogger.log("Scenario", "--- Крок 1: Розрахунок вартості обслуговування ---");
        MaintenanceCostVisitor costVisitor = new MaintenanceCostVisitor();
        airport.applyVisitor(costVisitor);
        EventLogger.log("Scenario", String.format("Загальна вартість обслуговування: %.2f грн", costVisitor.getTotalCost()));

        EventLogger.log("Scenario", "--- Крок 2: Перевірка пожежної безпеки ---");
        FireSafetyVisitor fireVisitor = new FireSafetyVisitor();
        airport.applyVisitor(fireVisitor);
        EventLogger.log("Scenario", "Перевірено об'єктів: " + fireVisitor.getCheckedCount());

        EventLogger.log("Scenario", "--- Крок 3: Звіт для державної авіаслужби ---");
        AviationAuthorityReportVisitor reportVisitor = new AviationAuthorityReportVisitor();
        airport.applyVisitor(reportVisitor);
        EventLogger.log("Scenario", "Рядків у звіті ДАС: " + reportVisitor.getReportLines().size());

        airport.logState("ПІСЛЯ операцій");
        EventLogger.log("Runner", "=== Кінець сценарію: Варіант 1, Завдання 1 ===");
    }

    public static void main(String[] args) {
        runVariant1Task1();
    }
}