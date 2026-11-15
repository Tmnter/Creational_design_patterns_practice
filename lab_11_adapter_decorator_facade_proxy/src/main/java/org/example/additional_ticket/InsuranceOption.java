package org.example.additional_ticket;

class InsuranceOption extends TicketDecorator {
    public InsuranceOption(Ticket ticket) { super(ticket); }
    @Override
    public String getDescription() { return ticket.getDescription() + ", Страхування"; }
    @Override
    public double getCost() { return ticket.getCost() + 25.0; }
}