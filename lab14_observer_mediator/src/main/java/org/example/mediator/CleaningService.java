package org.example.mediator;

class CleaningService extends GroundService {
    public CleaningService(AirportMediator mediator) { super(mediator, "Прибирання салону"); }
    public void finishCleaning() {
        System.out.println("[15:00] [CleaningService] Прибирання салону завершено.");
        mediator.notify(this, "CLEANING_FINISHED");
    }
}