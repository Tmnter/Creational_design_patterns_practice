package org.example.airport;

class DeparturesModule {
    public void processDeparture(String flightId, int runwayNumber) {
        FlightControlCenter center = FlightControlCenter.getInstance();
        System.out.println("[08:01] [МодульВильотів] ID центру: " + System.identityHashCode(center));
        center.bookRunway(runwayNumber, flightId);
    }
}