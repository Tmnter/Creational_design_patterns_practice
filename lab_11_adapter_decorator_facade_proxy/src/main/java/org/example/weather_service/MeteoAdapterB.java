package org.example.weather_service;

class MeteoAdapterB implements WeatherProvider {
    private final ExternalMeteoServiceB externalService;

    public MeteoAdapterB(ExternalMeteoServiceB externalService) {
        this.externalService = externalService;
    }

    @Override
    public double getTemperatureCelsius() {
        double k = externalService.getTempKelvin();
        double c = k - 273.15;
        System.out.println("[12:05] [AdapterB] Вихідні дані: " + k + "K -> Конвертовано в Celsius: " + String.format("%.2f", c) + "°C");
        return c;
    }

    @Override
    public double getWindSpeedMs() {
        double kmh = externalService.getWindKmH();
        double ms = kmh / 3.6;
        System.out.println("[12:05] [AdapterB] Вихідні дані: " + kmh + " км/год -> Конвертовано в м/с: " + String.format("%.2f", ms) + " м/с");
        return ms;
    }

    @Override
    public double getVisibilityMeters() {
        double km = externalService.getVisibilityKm();
        double meters = km * 1000.0;
        System.out.println("[12:05] [AdapterB] Вихідні дані: " + km + " км -> Конвертовано в метри: " + meters + " м");
        return meters;
    }
}
