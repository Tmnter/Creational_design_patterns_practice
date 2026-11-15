package org.example.mediator;

class TowingService extends GroundService {
    public TowingService(AirportMediator mediator) { super(mediator, "Буксирування"); }
    public void startTowing() {
        System.out.println("[15:00] [TowingService] Буксирування літака до злітної смуги розпочато.");
    }
}