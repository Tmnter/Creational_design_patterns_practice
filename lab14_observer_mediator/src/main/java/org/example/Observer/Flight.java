// Flight.java (Concrete Subject)
import java.util.ArrayList;
import java.util.List;

public class Flight implements FlightSubject {
    private final String flightNumber;
    private String gate;
    private String status;
    private final List<FlightObserver> observers = new ArrayList<>();

    public Flight(String flightNumber, String initialGate) {
        this.flightNumber = flightNumber;
        this.gate = initialGate;
        this.status = "За розкладом";
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getGate() {
        return gate;
    }

    @Override
    public void subscribe(FlightObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            EventLogger.log("Рейс " + flightNumber, "Підписано отримувача: " + observer);
        }
    }

    @Override
    public void unsubscribe(FlightObserver observer) {
        if (observers.remove(observer)) {
            EventLogger.log("Рейс " + flightNumber, "Відписано отримувача: " + observer);
        }
    }

    @Override
    public void notifyObservers(EventType eventType, String details) {
        // Копія списку захищає від ConcurrentModificationException під час ітерації
        for (FlightObserver observer : new ArrayList<>(observers)) {
            observer.update(this, eventType, details);
        }
    }

    // Бізнес-методи зміни стану рейсу
    public void delayFlight(int minutes, String reason) {
        this.status = "Затримано на " + minutes + " хв";
        String details = "Рейс затримано на " + minutes + " хв. Причина: " + reason;
        EventLogger.log("Рейс " + flightNumber, "ІНІЦІЙОВАНО ПОДІЮ -> " + details);
        notifyObservers(EventType.DELAYED, details);
    }

    public void changeGate(String newGate) {
        String oldGate = this.gate;
        this.gate = newGate;
        String details = "Вихід змінено з " + oldGate + " на " + newGate;
        EventLogger.log("Рейс " + flightNumber, "ІНІЦІЙОВАНО ПОДІЮ -> " + details);
        notifyObservers(EventType.GATE_CHANGED, details);
    }

    public void startBoarding() {
        this.status = "Триває посадка";
        String details = "Розпочато посадку пасажирів через вихід " + gate;
        EventLogger.log("Рейс " + flightNumber, "ІНІЦІЙОВАНО ПОДІЮ -> " + details);
        notifyObservers(EventType.BOARDING_STARTED, details);
    }
}