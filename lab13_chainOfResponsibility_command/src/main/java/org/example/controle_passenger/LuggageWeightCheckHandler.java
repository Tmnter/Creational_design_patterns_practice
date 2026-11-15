package org.example.controle_passenger;

class LuggageWeightCheckHandler extends CheckHandler {
    private static final double MAX_WEIGHT = 10.0; // максимальна вага у кг

    @Override
    public void handle(Passenger passenger) {
        System.out.println("[14:00] [LuggageCheck] Отримано запит для пасажира: " + passenger.getName());
        if (passenger.getLuggageWeight() <= MAX_WEIGHT) {
            System.out.println("[14:00] [LuggageCheck] Вага ручної поклажі (" + passenger.getLuggageWeight() + " кг) у нормі. Усі перевірки успішно завершено!");
            if (nextHandler != null) {
                nextHandler.handle(passenger);
            }
        } else {
            System.out.println("[14:00] [LuggageCheck] ЗУПИНЕНО: Перевищено вагу ручної поклажі (" + passenger.getLuggageWeight() + " кг > " + MAX_WEIGHT + " кг). Наступні перевірки не виконуються.");
        }
    }
}
