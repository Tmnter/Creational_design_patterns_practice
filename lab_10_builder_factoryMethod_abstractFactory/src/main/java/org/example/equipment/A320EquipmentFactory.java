package org.example.equipment;

public class A320EquipmentFactory implements AirportEquipmentFactory {
    @Override
    public Stairs createStairs() {
        return new A320Stairs();
    }

    @Override
    public Tug createTug() {
        return new A320Tug();
    }

    @Override
    public Loader createLoader() {
        return new A320Loader();
    }

    @Override
    public String getPlaneType() {
        return "A320 (Середньомагістральний)";
    }

    // Конкретні класи обладнання для A320
    private static class A320Stairs implements Stairs {
        public void extend() { System.out.println("[A320] Подано телескопічний трап високого рівня."); }
    }
    private static class A320Tug implements Tug {
        public void tow() { System.out.println("[A320] Підключено потужний тягач для важкого лайнера."); }
    }
    private static class A320Loader implements Loader {
        public void loadCargo() { System.out.println("[A320] Завантаження контейнерів у нижній багажник."); }
    }
}
