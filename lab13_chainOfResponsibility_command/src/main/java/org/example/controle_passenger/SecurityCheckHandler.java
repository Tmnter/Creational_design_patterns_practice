package org.example.controle_passenger;

class SecurityCheckHandler extends CheckHandler {
    @Override
    public void handle(Passenger passenger) {
        System.out.println("[14:00] [SecurityCheck] Отримано запит для пасажира: " + passenger.getName());
        if (passenger.isPassedSecurityCheck()) {
            System.out.println("[14:00] [SecurityCheck] Огляд безпеки пройдено. Передано далі.");
            if (nextHandler != null) {
                nextHandler.handle(passenger);
            }
        } else {
            System.out.println("[14:00] [SecurityCheck] ЗУПИНЕНО: Не пройдено огляд безпеки!");
        }
    }
}
