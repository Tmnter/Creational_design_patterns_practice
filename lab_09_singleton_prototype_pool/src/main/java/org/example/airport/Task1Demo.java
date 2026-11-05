package org.example.airport;

public class Task1Demo {
    public static void main(String[] args) {
        ArrivalsModule arrivals = new ArrivalsModule();
        DeparturesModule departures = new DeparturesModule();

        arrivals.processArrival("PS-101", 1);
        departures.processDeparture("PS-202", 1);
    }
}