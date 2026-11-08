package org.example.equipment;

public class AirportDispatcher {

    // Універсальний метод обслуговування будь-якого рейсу через абстрактну фабрику
    public void serviceFlight(String flightNumber, AirportEquipmentFactory factory) {
        System.out.println("\n[Dispatcher] Початок обслуговування рейсу " + flightNumber + " для літака: " + factory.getPlaneType());

        // Отримуємо узгоджений комплект обладнання
        Stairs stairs = factory.createStairs();
        Tug tug = factory.createTug();
        Loader loader = factory.createLoader();

        // Виконуємо обслуговування в журналі
        stairs.extend();
        tug.tow();
        loader.loadCargo();

        System.out.println("[Dispatcher] Обслуговування рейсу " + flightNumber + " успішно завершено.");
    }
}