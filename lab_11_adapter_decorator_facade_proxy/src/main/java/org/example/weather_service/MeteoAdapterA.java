package org.example.weather_service;
class MeteoAdapterA implements WeatherProvider {
    private final ExternalMeteoServiceA externalService;

    public MeteoAdapterA(ExternalMeteoServiceA externalService) {
        this.externalService = externalService;
    }

    @Override
    public double getTemperatureCelsius() {
        double f = externalService.fetchTempFahrenheit();
        double c = (f - 32) * 5.0 / 9.0;
        System.out.println("[12:00] [AdapterA] Вихідні дані: " + f + "°F -> Конвертовано в Celsius: " + String.format("%.2f", c) + "°C");
        return c;
    }

    @Override
    public double getWindSpeedMs() {
        double knots = externalService.fetchWindKnots();
        double ms = knots * 0.514444;
        System.out.println("[12:00] [AdapterA] Вихідні дані: " + knots + " вузлів -> Конвертовано в м/с: " + String.format("%.2f", ms) + " м/с");
        return ms;
    }

    @Override
    public double getVisibilityMeters() {
        double miles = externalService.fetchVisibilityMiles();
        double meters = miles * 1609.34;
        System.out.println("[12:00] [AdapterA] Вихідні дані: " + miles + " миль -> Конвертовано в метри: " + String.format("%.2f", meters) + " м");
        return meters;
    }
}