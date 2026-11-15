package org.example.additional_ticket;

abstract class TicketDecorator implements Ticket {
    protected final Ticket ticket; // посилання на об'єкт, який обгортаємо

    public TicketDecorator(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription();
    }

    @Override
    public double getCost() {
        return ticket.getCost();
    }
}
