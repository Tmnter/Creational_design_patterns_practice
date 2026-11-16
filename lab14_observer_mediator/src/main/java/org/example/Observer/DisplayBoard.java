// DisplayBoard.java
public class DisplayBoard implements FlightObserver {
    private final String terminalName;

    public DisplayBoard(String terminalName) {
        this.terminalName = terminalName;
    }

    @Override
    public void update(Flight flight, EventType eventType, String details) {
        EventLogger.log("Табло (" + terminalName + ")",
                "Оновлено інформацію для рейсу " + flight.getFlightNumber() + ": [" + details + "]");
    }

    @Override
    public String toString() {
        return "Табло (" + terminalName + ")";
    }
}