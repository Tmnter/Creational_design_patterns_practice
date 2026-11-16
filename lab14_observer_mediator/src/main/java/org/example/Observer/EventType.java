// EventType.java
public enum EventType {
    DELAYED("Затримка рейсу"),
    GATE_CHANGED("Зміна виходу на посадку"),
    BOARDING_STARTED("Початок посадки");

    private final String description;

    EventType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}