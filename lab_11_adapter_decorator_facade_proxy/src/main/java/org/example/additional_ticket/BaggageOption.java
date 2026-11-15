package org.example.additional_ticket;

class BaggageOption extends TicketDecorator {
    public BaggageOption(Ticket ticket) { super(ticket); }
    @Override
    public String getDescription() { return ticket.getDescription() + ", Додатковий багаж"; }
    @Override
    public double getCost() { return ticket.getCost() + 30.0; }
}
