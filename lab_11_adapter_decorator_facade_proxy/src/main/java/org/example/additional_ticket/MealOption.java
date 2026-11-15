package org.example.additional_ticket;

class MealOption extends TicketDecorator {
    public MealOption(Ticket ticket) { super(ticket); }
    @Override
    public String getDescription() { return ticket.getDescription() + ", Харчування"; }
    @Override
    public double getCost() { return ticket.getCost() + 18.0; }
}
