package org.example.flightplan;

import java.util.Arrays;

public class Task1Demo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 1: Builder (Аеропорт «Буковина») ===\n");

        // 1. Сформувати повне польотне завдання для рейсу PS-101
        System.out.println("[Сценарій 1] Формування повного польотного завдання PS-101:");
        FlightPlan fullPlan = new FlightPlan.FlightPlanBuilder()
                .setRoute("Чернівці (CWC) - Київ (KBP)")
                .setFuelCalculation(6.8)
                .setWeatherBriefing("Хмарно, видимість 10 км, температура +15°C")
                .setAlternateAirports(Arrays.asList("Житомир (ZTR), Львів (LWO)"))
                .setCargoData("Пасажири: 120, Вантаж: 1.5 т")
                .setSpecialInstructions("Пріоритет на посадку за запитом диспетчера")
                .build();

        fullPlan.displayInfo("Польотне завдання рейсу PS-101");

        // 2. Сформувати типове завдання для навчального польоту
        System.out.println("[Сценарій 2] Формування типового навчального польоту:");
        FlightPlanDirector director = new FlightPlanDirector();
        FlightPlan trainingPlan = director.constructTrainingFlight(new FlightPlan.FlightPlanBuilder());

        trainingPlan.displayInfo("Навчальне польотне завдання");

        // 3. Спробувати завершити формування без розрахунку палива
        System.out.println("[Сценарій 3] Спроба формування з помилкою (без палива):");
        try {
            new FlightPlan.FlightPlanBuilder()
                    .setRoute("Чернівці - Відень")
                    .setWeatherBriefing("Ясно")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Очікуваний виняток у журналі: " + e.getMessage() + "\n");
        }
    }
}
