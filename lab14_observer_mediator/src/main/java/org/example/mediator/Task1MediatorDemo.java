package org.example.mediator;

public class Task1MediatorDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 1: Mediator (Координація наземних служб) ===\n");


        AirportControlMediator coordinator = new AirportControlMediator();

        CleaningService cleaning = new CleaningService(coordinator);
        CateringService catering = new CateringService(coordinator);
        BaggageService baggage = new BaggageService(coordinator);
        RefuelingService refueling = new RefuelingService(coordinator);
        TowingService towing = new TowingService(coordinator);

        coordinator.setCleaningService(cleaning);
        coordinator.setCateringService(catering);
        coordinator.setBaggageService(baggage);
        coordinator.setRefuelingService(refueling);
        coordinator.setTowingService(towing);

        System.out.println("--- Сценарій 1: Завершення прибирання ---");
        cleaning.finishCleaning();
        System.out.println();

        System.out.println("--- Сценарій 2: Завершення завантаження багажу ---");
        baggage.finishBaggage();
        System.out.println();

        System.out.println("--- Сценарій 3: Запит на заправку під час посадки ---");
        refueling.requestRefueling(true);
    }
}
