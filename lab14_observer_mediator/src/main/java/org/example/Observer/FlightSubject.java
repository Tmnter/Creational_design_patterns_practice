// FlightSubject.java (Інтерфейс Видавця)
public interface FlightSubject {
    void subscribe(FlightObserver observer);
    void unsubscribe(FlightObserver observer);
    void notifyObservers(EventType eventType, String details);
}