package org.example.template;

class SanitaryFlightService extends FlightServiceTemplate {
    public SanitaryFlightService(String flightNumber) {
        super(flightNumber);
    }

    @Override
    protected String getServiceTypeName() {
        return "SanitaryFlight";
    }

    @Override
    protected void unload() {
        System.out.println("[10:02] [SanitaryFlight] Крок [unload]: Спеціальна евакуація пацієнтів та медичного обладнання.");
    }

    @Override
    protected void cleanCabin() {
        System.out.println("[10:04] [SanitaryFlight] Крок [cleanCabin]: Посилена санітарна обробка та дезінфекція салону.");
    }

    @Override
    protected void load() {
        System.out.println("[10:10] [SanitaryFlight] Крок [load]: Завантаження медичних бригад, спецзасобів і обладнання.");
    }
}
