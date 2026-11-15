package org.example.flyweight;

class Seat {
    private final int row;
    private final char letter;
    private final String passengerName;
    private final ServiceClassFlyweight serviceClass; // посилання на спільні дані

    public Seat(int row, char letter, String passengerName, ServiceClassFlyweight serviceClass) {
        this.row = row;
        this.letter = letter;
        this.passengerName = passengerName;
        this.serviceClass = serviceClass;
    }

    public void displaySeatInfo() {
        System.out.println("[13:10] [Seat] Місце " + row + letter + " | Пасажир: " + passengerName);
        serviceClass.displaySharedData();
        System.out.println("  [Memory Check] Посилання на спільні дані (hashCode): " + serviceClass.hashCode());
    }

    public ServiceClassFlyweight getServiceClass() {
        return serviceClass;
    }
}