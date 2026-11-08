package org.example.equipment;

public class ATREquipmentFactory implements AirportEquipmentFactory {
    @Override
    public Stairs createStairs() {
        return new ATRStairs();
    }

    @Override
    public Tug createTug() {
        return new ATRTug();
    }

    @Override
    public Loader createLoader() {
        return new ATRLoader();
    }

    @Override
    public String getPlaneType() {
        return "ATR-72 (Регіональний турбогвинтовий)";
    }

    // Конкретні класи обладнання для ATR-72
    private static class ATRStairs implements Stairs {
        public void extend() { System.out.println("[ATR-72] Подано легкий приставний трап на нижню висоту."); }
    }
    private static class ATRTug implements Tug {
        public void tow() { System.out.println("[ATR-72] Підключено легкий буксир для турбогвинтового судна."); }
    }
    private static class ATRLoader implements Loader {
        public void loadCargo() { System.out.println("[ATR-72] Ручне/стрічкове завантаження багажного відсіку."); }
    }
}