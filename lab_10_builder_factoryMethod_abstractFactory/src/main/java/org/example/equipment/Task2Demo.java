package org.example.equipment;

public class Task2Demo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 2: Abstract Factory (Аеропорт «Буковина») ===");

        AirportDispatcher dispatcher = new AirportDispatcher();

        // 1. Обслужити рейс на A320
        AirportEquipmentFactory a320Factory = new A320EquipmentFactory();
        dispatcher.serviceFlight("PS-101", a320Factory);

        // 2. Обслужити рейс на ATR-72 тим самим кодом диспетчерської
        AirportEquipmentFactory atrFactory = new ATREquipmentFactory();
        dispatcher.serviceFlight("PS-202", atrFactory);

        // 3. Додати новий клас «широкофюзеляжний літак» без зміни коду диспетчерської
        AirportEquipmentFactory wideBodyFactory = new WideBodyEquipmentFactory();
        dispatcher.serviceFlight("PS-303 (New Wide-Body)", wideBodyFactory);
    }
}