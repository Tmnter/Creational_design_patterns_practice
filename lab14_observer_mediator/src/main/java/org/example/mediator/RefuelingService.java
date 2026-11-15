package org.example.mediator;

class RefuelingService extends GroundService {
    public RefuelingService(AirportMediator mediator) { super(mediator, "Заправка"); }
    public void requestRefueling(boolean isBoardingInProgress) {
        System.out.println("[15:00] [RefuelingService] Запит на початок заправки...");
        if (isBoardingInProgress) {
            mediator.notify(this, "REFUEL_REQUEST_DURING_BOARDING");
        } else {
            System.out.println("[15:00] [RefuelingService] Заправка успішно розпочата.");
        }
    }
    public void startRefueling() {
        System.out.println("[15:00] [RefuelingService] Заправка розпочата за дозволом координатора.");
    }
}