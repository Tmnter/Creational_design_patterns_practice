package org.example.flightplan;

import java.util.List;

public class FlightPlan {
    private String route;
    private Double fuelCalculation;
    private String weatherBriefing;
    private List<String> alternateAirports;
    private String cargoData;
    private String specialInstructions;

    // Конструктор доступний лише через Builder
    public FlightPlan(FlightPlanBuilder builder) {
        this.route = builder.route;
        this.fuelCalculation = builder.fuelCalculation;
        this.weatherBriefing = builder.weatherBriefing;
        this.alternateAirports = builder.alternateAirports;
        this.cargoData = builder.cargoData;
        this.specialInstructions = builder.specialInstructions;
    }

    public void displayInfo(String label) {
        System.out.println("--- " + label + " ---");
        System.out.println("Маршрут: " + route);
        System.out.println("Розрахунок палива: " + (fuelCalculation != null ? fuelCalculation + " т" : "не задано"));
        System.out.println("Метеозведення: " + weatherBriefing);
        System.out.println("Запасні аеродроми: " + (alternateAirports != null ? alternateAirports : "відсутні"));
        System.out.println("Дані про вантаж: " + (cargoData != null ? cargoData : "немає"));
        System.out.println("Особливі вказівки: " + (specialInstructions != null ? specialInstructions : "немає"));
        System.out.println();
    }

    // Вкладений клас Builder
    public static class FlightPlanBuilder {
        private String route;
        private Double fuelCalculation;
        private String weatherBriefing;
        private List<String> alternateAirports;
        private String cargoData;
        private String specialInstructions;

        public FlightPlanBuilder setRoute(String route) {
            this.route = route;
            System.out.println("[Builder] Встановлено маршрут: " + route);
            return this;
        }

        public FlightPlanBuilder setFuelCalculation(double fuelCalculation) {
            this.fuelCalculation = fuelCalculation;
            System.out.println("[Builder] Виконано розрахунок палива: " + fuelCalculation + " т");
            return this;
        }

        public FlightPlanBuilder setWeatherBriefing(String weatherBriefing) {
            this.weatherBriefing = weatherBriefing;
            System.out.println("[Builder] Отримано метеозведення");
            return this;
        }

        public FlightPlanBuilder setAlternateAirports(List<String> alternateAirports) {
            this.alternateAirports = alternateAirports;
            System.out.println("[Builder] Додано запасні аеродроми");
            return this;
        }

        public FlightPlanBuilder setCargoData(String cargoData) {
            this.cargoData = cargoData;
            System.out.println("[Builder] Додано дані про вантаж");
            return this;
        }

        public FlightPlanBuilder setSpecialInstructions(String specialInstructions) {
            this.specialInstructions = specialInstructions;
            System.out.println("[Builder] Додано особливі вказівки");
            return this;
        }

        public FlightPlan build() {
            // Перевірка обов'язкових частин на завершальному кроці
            if (route == null || route.isEmpty()) {
                System.out.println("[Error] Неможливо сформувати польотне завдання: не задано маршрут");
                throw new IllegalStateException("Неможливо сформувати польотне завдання: не задано маршрут");
            }
            if (fuelCalculation == null) {
                System.out.println("[Error] Неможливо сформувати польотне завдання: не задано розрахунок палива");
                throw new IllegalStateException("Неможливо сформувати польотне завдання: не задано розрахунок палива");
            }
            if (weatherBriefing == null || weatherBriefing.isEmpty()) {
                System.out.println("[Error] Неможливо сформувати польотне завдання: не задано метеозведення");
                throw new IllegalStateException("Неможливо сформувати польотне завдання: не задано метеозведення");
            }

            System.out.println("[FlightControlCenter] Польотне завдання успішно сформовано та заблоковано від змін.");
            return new FlightPlan(this);
        }
    }
}
