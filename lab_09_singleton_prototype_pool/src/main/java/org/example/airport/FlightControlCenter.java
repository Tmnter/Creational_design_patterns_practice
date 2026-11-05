package org.example.airport;
import java.util.HashMap;
import java.util.Map;

class FlightControlCenter {
    private static FlightControlCenter instance;
    private final Map<Integer, String> runwayStatus = new HashMap<>();

    private FlightControlCenter() {
        System.out.println("[08:00] [Система] Центр управління польотами ініціалізовано.");
    }

    public static synchronized FlightControlCenter getInstance() {
        if (instance == null) {
            instance = new FlightControlCenter();
        }
        return instance;
    }

    public synchronized boolean bookRunway(int runwayNumber, String flightId) {
        String currentOccupant = runwayStatus.get(runwayNumber);
        if (currentOccupant == null || currentOccupant.isEmpty()) {
            runwayStatus.put(runwayNumber, flightId);
            System.out.println("[08:01] [ЦентрУправління] Смуга " + runwayNumber + " успішно заброньована рейсом " + flightId);
            return true;
        } else {
            System.out.println("[08:01] [ЦентрУправління] Відмова: Смуга " + runwayNumber + " зайнята рейсом " + currentOccupant);
            return false;
        }
    }
}