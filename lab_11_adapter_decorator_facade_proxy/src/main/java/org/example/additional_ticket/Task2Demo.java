package org.example.additional_ticket;

public class Task2Demo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 2: Decorator (Додаткові послуги до квитка) ===\n");

        // Сценарій 1: Оформити базовий квиток і вивести його опис і вартість
        System.out.println("[12:30] [BookingSystem] Оформлення базового квитка (Чернівці - Київ):");
        Ticket ticket1 = new BaseTicket("Чернівці - Київ");
        System.out.println("[12:30] [Ticket] Фактичний об'єкт: " + ticket1.getClass().getSimpleName());
        System.out.println("[12:30] [Ticket] Опис: " + ticket1.getDescription());
        System.out.println("[12:30] [Ticket] Вартість: $" + ticket1.getCost() + "\n");

        // Сценарій 2: Додати до нього багаж, страхування і пріоритетну посадку -> вивести опис і підсумкову вартість
        System.out.println("[12:32] [BookingSystem] Додавання послуг (багаж, страхування, пріоритетна посадка):");
        Ticket ticket2 = new BaseTicket("Чернівці - Київ");
        ticket2 = new BaggageOption(ticket2);       // обгортка 1
        ticket2 = new InsuranceOption(ticket2);     // обгортка 2
        ticket2 = new PriorityBoardingOption(ticket2);// обгортка 3
        System.out.println("[12:32] [Ticket] Фактичний об'єкт (декоратор найвищого рівня): " + ticket2.getClass().getSimpleName());
        System.out.println("[12:32] [Ticket] Опис: " + ticket2.getDescription());
        System.out.println("[12:32] [Ticket] Підсумкова вартість: $" + ticket2.getCost() + "\n");

        // Сценарій 3: Оформити другий квиток з іншою комбінацією послуг (харчування двічі, вибір місця)
        System.out.println("[12:35] [BookingSystem] Оформлення другого квитка з іншою комбінацією (Львів - Варшава):");
        Ticket ticket3 = new BaseTicket("Львів - Варшава");
        ticket3 = new MealOption(ticket3);          // перше харчування
        ticket3 = new MealOption(ticket3);          // друге харчування (рекурсивне обгортання)
        ticket3 = new SeatSelectionOption(ticket3); // вибір місця
        System.out.println("[12:35] [Ticket] Фактичний об'єкт: " + ticket3.getClass().getSimpleName());
        System.out.println("[12:35] [Ticket] Опис: " + ticket3.getDescription());
        System.out.println("[12:35] [Ticket] Підсумкова вартість (перевірка коректності підрахунку): $" + ticket3.getCost());
    }
}
