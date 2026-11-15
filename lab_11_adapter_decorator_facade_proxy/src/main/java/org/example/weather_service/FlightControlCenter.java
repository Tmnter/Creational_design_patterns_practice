package org.example.weather_service;

class FlightControlCenter {
    private final WeatherProvider weatherProvider;

    public FlightControlCenter(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public void evaluateFlightConditions() {
        System.out.println("[12:00] [FlightControlCenter] Запит метеоданих через власний інтерфейс...");
        double temp = weatherProvider.getTemperatureCelsius();
        double wind = weatherProvider.getWindSpeedMs();
        double vis = weatherProvider.getVisibilityMeters();

        System.out.println("[12:00] [FlightControlCenter] Отримано перетворені значення: Т=" +
                String.format("%.2f", temp) + "°C, Вітер=" + String.format("%.2f", wind) +
                " м/с, Видимість=" + String.format("%.2f", vis) + "м");

        if (wind < 15.0 && vis > 5000.0) {
            System.out.println("[12:00] [FlightControlCenter] Прийняте рішення: Метеоумови сприятливі. Дозвіл на зліт надано.\n");
        } else {
            System.out.println("[12:00] [FlightControlCenter] Прийняте рішення: Обгороджуючі погодні умови. Зліт заборонено.\n");
        }
    }
}
