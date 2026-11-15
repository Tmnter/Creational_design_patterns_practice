package org.example.flyweight;
import java.util.HashMap;
import java.util.Map;

class ServiceClassFactory {
    private static final Map<String, ServiceClassFlyweight> cache = new HashMap<>();
    private static int createdFlyweightsCount = 0;

    public static ServiceClassFlyweight getServiceClass(String className, String description, int seatWidth, double pitch, String amenities) {
        cache.computeIfAbsent(className, k -> {
            createdFlyweightsCount++;
            System.out.println("[13:10] [Factory] Створено новий об'єкт спільних даних для класу: " + className);
            return new ServiceClassFlyweight(className, description, seatWidth, pitch, amenities);
        });
        return cache.get(className);
    }

    public static int getCreatedFlyweightsCount() {
        return createdFlyweightsCount;
    }
}