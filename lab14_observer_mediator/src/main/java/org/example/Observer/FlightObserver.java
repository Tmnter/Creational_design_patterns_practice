// FlightObserver.java (Інтерфейс Спостерігача)
public interface FlightObserver {
    void update(Flight flight, EventType eventType, String details);
}