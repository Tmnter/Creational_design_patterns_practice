package org.example.mediator;

class CateringService extends GroundService {
    public CateringService(AirportMediator mediator) { super(mediator, "Кейтеринг"); }
    public void startCatering() {
        System.out.println("[15:00] [CateringService] Початок доставки харчування на борт.");
    }
}
