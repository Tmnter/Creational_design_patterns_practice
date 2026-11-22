package org.example.memento;

class FlightSlot {
    private String flightNumber;
    private String time;
    private String gate;
    private String runway;

    FlightSlot(String flightNumber, String time, String gate, String runway) {
        this.flightNumber = flightNumber;
        this.time = time;
        this.gate = gate;
        this.runway = runway;
    }

    FlightSlot copy() {
        return new FlightSlot(flightNumber, time, gate, runway);
    }

    void update(String time, String gate, String runway) {
        this.time = time;
        this.gate = gate;
        this.runway = runway;
    }

    @Override
    public String toString() {
        return flightNumber + " -> час: " + time + ", вихід: " + gate + ", смуга: " + runway;
    }
}