package org.example.additional_ticket;

class SeatSelectionOption extends TicketDecorator {
    public SeatSelectionOption(Ticket ticket) { super(ticket); }
    @Override
    public String getDescription() { return ticket.getDescription() + ", Вибір місця"; }
    @Override
    public double getCost() { return ticket.getCost() + 15.0; }
}