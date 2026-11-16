// TaxiService.java
public class TaxiService implements FlightObserver {
    private final String companyName;

    public TaxiService(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void update(Flight flight, EventType eventType, String details) {
        // Таксі-сервіс вибірково реагує лише на затримки (або за потреби на інші статуси)
        if (eventType == EventType.DELAYED) {
            EventLogger.log("Таксі-сервіс «" + companyName + "»",
                    "Зсунуто час подачі машин під приліт/виліт рейсу " + flight.getFlightNumber());
        } else {
            EventLogger.log("Таксі-сервіс «" + companyName + "»",
                    "Отримано статус (" + eventType.getDescription() + ") — коригування автопарку не потрібне.");
        }
    }

    @Override
    public String toString() {
        return "Таксі-сервіс «" + companyName + "»";
    }
}