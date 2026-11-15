package org.example.mediator;

class BaggageService extends GroundService {
    public BaggageService(AirportMediator mediator) { super(mediator, "Завантаження багажу"); }
    public void finishBaggage() {
        System.out.println("[15:00] [BaggageService] Завантаження багажу завершено.");
        mediator.notify(this, "BAGGAGE_FINISHED");
    }
}
