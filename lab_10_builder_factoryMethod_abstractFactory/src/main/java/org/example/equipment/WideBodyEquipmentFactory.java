package org.example.equipment;

public class WideBodyEquipmentFactory implements AirportEquipmentFactory {
    @Override
    public Stairs createStairs() { return new WideBodyStairs(); }
    @Override
    public Tug createTug() { return new WideBodyTug(); }
    @Override
    public Loader createLoader() { return new WideBodyLoader(); }
    @Override
    public String getPlaneType() { return "Wide-Body / Широкофюзеляжний"; }

    private static class WideBodyStairs implements Stairs {
        public void extend() { System.out.println("[Wide-Body] Подано дворукавний телескопічний трап."); }
    }
    private static class WideBodyTug implements Tug {
        public void tow() { System.out.println("[Wide-Body] Підключено важкий тягач підвищеної тяги."); }
    }
    private static class WideBodyLoader implements Loader {
        public void loadCargo() { System.out.println("[Wide-Body] Автоматизоване палетування для двох палуб."); }
    }
}
