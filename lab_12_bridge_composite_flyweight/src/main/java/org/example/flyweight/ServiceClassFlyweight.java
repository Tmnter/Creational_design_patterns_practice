package org.example.flyweight;

class ServiceClassFlyweight {
    private final String className; // наприклад, "Економ", "Бізнес"
    private final String description;
    private final int seatWidth; // ширина в см
    private final double pitch; // крок крісел
    private final String amenities; // перелік зручностей

    public ServiceClassFlyweight(String className, String description, int seatWidth, double pitch, String amenities) {
        this.className = className;
        this.description = description;
        this.seatWidth = seatWidth;
        this.pitch = pitch;
        this.amenities = amenities;
    }

    public void displaySharedData() {
        System.out.println("  [Клас обслуговування: " + className + "] Опис: " + description +
                ", Ширина: " + seatWidth + "см, Крок: " + pitch + "дюймів, Зручності: " + amenities);
    }
}