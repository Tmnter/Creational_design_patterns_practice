package org.example.template;

class PassengerFlightService extends FlightServiceTemplate {
    public PassengerFlightService(String flightNumber) {
        super(flightNumber);
    }

    @Override
    protected String getServiceTypeName() {
        return "PassengerFlight";
    }

    @Override
    protected void unload() {
        System.out.println("[10:02] [PassengerFlight] Крок [unload]: Висадка пасажирів та вивантаження багажу.");
    }

    @Override
    protected void load() {
        System.out.println("[10:10] [PassengerFlight] Крок [load]: Посадка пасажирів та завантаження багажу.");
    }
}