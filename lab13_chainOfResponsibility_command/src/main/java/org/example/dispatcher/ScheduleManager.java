package org.example.dispatcher;
public class ScheduleManager {
    private String flightNumber;
    private String time;
    private String gate;

    public ScheduleManager(String flightNumber, String time, String gate) {
        this.flightNumber = flightNumber;
        this.time = time;
        this.gate = gate;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public void printSchedule(String source) {
        Logger.log(source, "Розклад рейсу " + flightNumber + " -> Час: " + time + ", Вихід: " + gate);
    }
}