package org.example.template;

class CargoFlightService extends FlightServiceTemplate {
    public CargoFlightService(String flightNumber) {
        super(flightNumber);
    }

    @Override
    protected String getServiceTypeName() {
        return "CargoFlight";
    }

    @Override
    protected void unload() {
        System.out.println("[10:02] [CargoFlight] Крок [unload]: Розвантаження палет і вантажних контейнерів навантажувачем.");
    }

    @Override
    protected boolean needsCabinCleaning() {
        return false;
    }

    @Override
    protected void load() {
        System.out.println("[10:10] [CargoFlight] Крок [load]: Завантаження комерційних вантажів і закріплення сіток.");
    }
}