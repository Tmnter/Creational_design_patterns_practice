// CateringService.java
public class CateringService implements FlightObserver {
    @Override
    public void update(Flight flight, EventType eventType, String details) {
        switch (eventType) {
            case DELAYED:
                EventLogger.log("Служба кейтерингу",
                        "Скориговано графік підігріву та подачі бортового харчування для " + flight.getFlightNumber());
                break;
            case GATE_CHANGED:
                EventLogger.log("Служба кейтерингу",
                        "Змінено маршрут автоліфта до нового виходу " + flight.getGate());
                break;
            case BOARDING_STARTED:
                EventLogger.log("Служба кейтерингу",
                        "Завантаження харчування на рейс " + flight.getFlightNumber() + " завершено.");
                break;
        }
    }

    @Override
    public String toString() {
        return "Служба кейтерингу";
    }
}