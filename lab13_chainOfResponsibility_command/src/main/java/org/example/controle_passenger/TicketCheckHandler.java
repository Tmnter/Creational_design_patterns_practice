package org.example.controle_passenger;

class TicketCheckHandler extends CheckHandler {
    @Override
    public void handle(Passenger passenger) {
        System.out.println("[14:00] [TicketCheck] Отримано запит для пасажира: " + passenger.getName());
        if (passenger.hasValidTicket()) {
            System.out.println("[14:00] [TicketCheck] Посадковий талон дійсний. Передано далі.");
            if (nextHandler != null) {
                nextHandler.handle(passenger);
            }
        } else {
            System.out.println("[14:00] [TicketCheck] ЗУПИНЕНО: Недійсний посадковий талон!");
        }
    }
}
