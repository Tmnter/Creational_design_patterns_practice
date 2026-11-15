package org.example.additional_ticket;

class PriorityBoardingOption extends TicketDecorator {
    public PriorityBoardingOption(Ticket ticket) { super(ticket); }
    @Override
    public String getDescription() { return ticket.getDescription() + ", Пріоритетна посадка"; }
    @Override
    public double getCost() { return ticket.getCost() + 20.0; }
}