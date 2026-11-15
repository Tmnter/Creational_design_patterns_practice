package org.example.weather_service;

public class Task1Demo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 1: Adapter (Метеосервіс) ===\n");

        // Крок 1 і 2: Підключення першого стороннього сервісу через адаптер А
        ExternalMeteoServiceA serviceA = new ExternalMeteoServiceA();
        WeatherProvider adapterA = new MeteoAdapterA(serviceA);

        FlightControlCenter controlCenter = new FlightControlCenter(adapterA);
        controlCenter.evaluateFlightConditions();

        // Крок 3: Підключення другого альтернативного метеосервісу (Service B) без зміни коду центру управління
        System.out.println("--- Зміна постачальника метеосервісу на альтернативний (Service B) ---");
        ExternalMeteoServiceB serviceB = new ExternalMeteoServiceB();
        WeatherProvider adapterB = new MeteoAdapterB(serviceB);

        // Передаємо новий адаптер у той самий центр управління
        FlightControlCenter controlCenterWithNewService = new FlightControlCenter(adapterB);
        controlCenterWithNewService.evaluateFlightConditions();
    }
}