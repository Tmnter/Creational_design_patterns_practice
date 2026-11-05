package org.example.flight;
public class Task2Demo {
    public static void main(String[] args) {
        Flight referenceFlight = new Flight("Чернівці-Варшава", "ЕТАЛОН", "Boeing 737-800");

        Flight flight1 = referenceFlight.clone();
        Flight flight2 = referenceFlight.clone();
        Flight flight3 = referenceFlight.clone();

        flight1.setMenu("Преміум меню");
        flight1.blockSeat("12A");

        System.out.println("\n--- Результати порівняння ---");
        referenceFlight.displayInfo("Еталонний рейс");
        flight1.displayInfo("Змінений рейс (Дата 1)");
    }
}