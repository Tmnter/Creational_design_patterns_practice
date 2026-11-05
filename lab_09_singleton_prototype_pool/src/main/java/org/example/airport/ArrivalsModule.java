package org.example.airport;

class ArrivalsModule {
    public void processArrival(String flightId, int runwayNumber) {
        FlightControlCenter center = FlightControlCenter.getInstance();
        System.out.println("[08:00] [МодульПрильотів] ID центру: " + System.identityHashCode(center));
        center.bookRunway(runwayNumber, flightId);
    }
}