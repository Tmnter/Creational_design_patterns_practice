package org.example.flyweight;

public class Task2Demo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 2: Flyweight (Місця в схемі салону) ===\n");

        int totalFlights = 20;
        int seatsPerFlight = 180;
        int totalSeatsCreated = 0;

        System.out.println("[13:10] [System] Формування схем салонів для " + totalFlights + " рейсів по " + seatsPerFlight + " місць...");

        // Симулюємо створення схем салонів для 20 рейсів
        Seat[][] flightsDatabase = new Seat[totalFlights][seatsPerFlight];

        for (int f = 0; f < totalFlights; f++) {
            for (int s = 0; s < seatsPerFlight; s++) {
                String passenger = "Пасажир #" + (s + 1) + " (Рейс " + (f + 1) + ")";
                ServiceClassFlyweight flightClass;

                // Перші 30 місць — Бізнес, решта — Економ
                if (s < 30) {
                    flightClass = ServiceClassFactory.getServiceClass(
                            "Бізнес", "Просторі крісла з підвищеним комфортом", 55, 40.0, "Харчування, преміум-напої, плед"
                    );
                } else {
                    flightClass = ServiceClassFactory.getServiceClass(
                            "Економ", "Стандартні крісла", 43, 31.0, "Базовий набір"
                    );
                }

                int row = (s / 6) + 1;
                char letter = (char) ('A' + (s % 6));
                flightsDatabase[f][s] = new Seat(row, letter, passenger, flightClass);
                totalSeatsCreated++;
            }
        }

        System.out.println("\n[13:10] [System] Статистика пам'яті:");
        System.out.println("[13:10] [Stats] Загальна кількість створених об'єктів місць (контекстів): " + totalSeatsCreated);
        System.out.println("[13:10] [Stats] Кількість фактично створених об'єктів спільних даних (Flyweight): " + ServiceClassFactory.getCreatedFlyweightsCount() + " (має бути 2-3)");

        // Вивести повний опис двох місць різних рейсів одного класу і показати, що вони посилаються на той самий об'єкт спільних даних
        System.out.println("\n[13:10] [System] Демонстрація посилання на той самий об'єкт спільних даних:");

        // Візьмемо місце з рейсу 1 (наприклад, індекс 5) та місце з рейсу 15 (також індекс 5, економ-клас)
        Seat seatFromFlight1 = flightsDatabase[0][5];
        Seat seatFromFlight15 = flightsDatabase[14][5];

        System.out.println("Місце 1 (Рейс 1):");
        seatFromFlight1.displaySeatInfo();

        System.out.println("\nМісце 2 (Рейс 15):");
        seatFromFlight15.displaySeatInfo();

        boolean areReferencesEqual = (seatFromFlight1.getServiceClass() == seatFromFlight15.getServiceClass());
        System.out.println("\n[13:10] [Verification] Чи посилаються обидва місця на один і той самий об'єкт спільних даних у пам'яті? -> " + areReferencesEqual);
    }
}
