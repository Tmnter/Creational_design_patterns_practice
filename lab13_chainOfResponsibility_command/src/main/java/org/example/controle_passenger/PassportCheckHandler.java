package org.example.controle_passenger;

class PassportCheckHandler extends CheckHandler {
    @Override
    public void handle(Passenger passenger) {
        System.out.println("[14:00] [PassportCheck] Отримано запит для пасажира: " + passenger.getName());
        if (passenger.hasValidPassport()) {
            System.out.println("[14:00] [PassportCheck] Паспортний контроль пройдено успішно. Передано далі.");
            if (nextHandler != null) {
                nextHandler.handle(passenger);
            }
        } else {
            System.out.println("[14:00] [PassportCheck] ЗУПИНЕНО: Проблеми з паспортом!");
        }
    }
}
