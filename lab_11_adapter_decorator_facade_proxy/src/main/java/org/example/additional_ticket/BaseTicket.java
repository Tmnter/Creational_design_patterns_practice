package org.example.additional_ticket;

class BaseTicket implements Ticket {
    private final String route;

    public BaseTicket(String route) {
        this.route = route;
    }

    @Override
    public String getDescription() {
        return "Базовий квиток [" + route + "]";
    }

    @Override
    public double getCost() {
        return 100.0; // Базова вартість квитка
    }
}