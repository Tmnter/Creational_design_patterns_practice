// Passenger.java
public class Passenger implements FlightObserver {
    private final String fullName;

    public Passenger(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public void update(Flight flight, EventType eventType, String details) {
        EventLogger.log("Пасажир " + fullName,
                "Отримано SMS про рейс " + flight.getFlightNumber() + ": " + details);
    }

    @Override
    public String toString() {
        return "Пасажир " + fullName;
    }
}