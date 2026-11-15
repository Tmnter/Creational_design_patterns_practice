package org.example.controle_passenger;

class CustomsCheckHandler extends CheckHandler {
    @Override
    public void handle(Passenger passenger) {
        System.out.println("[14:00] [CustomsCheck] Отримано запит для пасажира: " + passenger.getName());
        if (passenger.isInternational()) {
            System.out.println("[14:00] [CustomsCheck] Міжнародний рейс: митний контроль пройдено. Передано далі.");
        } else {
            System.out.println("[14:00] [CustomsCheck] Внутрішній рейс: митний контроль пропущено.");
        }
        if (nextHandler != null) {
            nextHandler.handle(passenger);
        }
    }
}