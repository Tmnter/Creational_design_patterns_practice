package org.example.weather_service;

interface WeatherProvider {
    double getTemperatureCelsius();
    double getWindSpeedMs();
    double getVisibilityMeters();
}