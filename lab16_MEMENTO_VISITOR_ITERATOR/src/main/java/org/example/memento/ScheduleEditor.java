package org.example.memento;
import java.util.LinkedHashMap;
import java.util.Map;
class ScheduleEditor {
    private final Map<String, FlightSlot> flights = new LinkedHashMap<>();

    public void addFlight(String flightNumber, String time, String gate, String runway) {
        flights.put(flightNumber, new FlightSlot(flightNumber, time, gate, runway));
        System.out.println("[08:01] [ScheduleEditor:Memento] Додано рейс " + flightNumber
                + " (" + time + ", вихід " + gate + ", смуга " + runway + "). Поточний стан: " + summarizeState());
    }

    public void rescheduleFlight(String flightNumber, String newTime, String newGate, String newRunway) {
        String before = summarizeState();
        FlightSlot slot = flights.get(flightNumber);
        if (slot != null) {
            slot.update(newTime, newGate, newRunway);
        }
        System.out.println("[08:05] [ScheduleEditor:Memento] Змінено рейс " + flightNumber
                + " -> [" + newTime + ", вихід " + newGate + ", смуга " + newRunway + "] | ДО: "
                + before + " | ПІСЛЯ: " + summarizeState());
    }

    public ScheduleMemento saveSnapshot(String name) {
        System.out.println("[08:03] [ScheduleEditor:Memento] Створено знімок '" + name
                + "' без розкриття внутрішніх полів. Стан: " + summarizeState());
        return new ScheduleMemento(name, flights);
    }

    public void restoreSnapshot(ScheduleMemento memento) {
        String before = summarizeState();
        flights.clear();
        flights.putAll(memento.getSlotsSnapshot());
        System.out.println("[08:10] [ScheduleEditor:Memento] Відновлено варіант '" + memento.getSnapshotName()
                + "' | ДО: " + before + " | ПІСЛЯ: " + summarizeState());
    }

    public void printSchedule(String label) {
        System.out.println("[08:11] [ScheduleEditor:Memento] Розклад (" + label + "):");
        for (FlightSlot slot : flights.values()) {
            System.out.println("        * " + slot);
        }
    }

    private String summarizeState() {
        if (flights.isEmpty()) {
            return "{порожньо}";
        }
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (FlightSlot slot : flights.values()) {
            if (!first) sb.append("; ");
            sb.append(slot);
            first = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
