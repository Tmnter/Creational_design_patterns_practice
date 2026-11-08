package org.example.flightplan;

public class FlightPlanDirector {

    public FlightPlan constructTrainingFlight(FlightPlan.FlightPlanBuilder builder) {
        return builder
                .setRoute("Чернівці (Training Area) - Чернівці")
                .setFuelCalculation(2.5)
                .setWeatherBriefing("Простий метеорологічний мінімум, вітер 3 м/с")
                .build();
    }
}