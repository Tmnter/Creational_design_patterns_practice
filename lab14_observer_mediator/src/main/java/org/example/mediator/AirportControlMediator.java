package org.example.mediator;

class AirportControlMediator implements AirportMediator {
    private CleaningService cleaningService;
    private CateringService cateringService;
    private BaggageService baggageService;
    private RefuelingService refuelingService;
    private TowingService towingService;

    public void setCleaningService(CleaningService cleaningService) { this.cleaningService = cleaningService; }
    public void setCateringService(CateringService cateringService) { this.cateringService = cateringService; }
    public void setBaggageService(BaggageService baggageService) { this.baggageService = baggageService; }
    public void setRefuelingService(RefuelingService refuelingService) { this.refuelingService = refuelingService; }
    public void setTowingService(TowingService towingService) { this.towingService = towingService; }

    @Override
    public void notify(GroundService sender, String event) {
        System.out.println("[15:00] [Coordinator] Отримано подію '" + event + "' від ініціатора: " + sender.getName());

        switch (event) {
            case "CLEANING_FINISHED":
                System.out.println("[15:00] [Coordinator] Дія: Координатор запускає кейтеринг у відповідь на завершення прибирання.");
                if (cateringService != null) {
                    cateringService.startCatering();
                }
                break;

            case "BAGGAGE_FINISHED":
                System.out.println("[15:00] [Coordinator] Дія: Завантаження багажу завершено -> Координатор дозволяє буксирування.");
                if (towingService != null) {
                    towingService.startTowing();
                }
                break;

            case "REFUEL_REQUEST_DURING_BOARDING":
                System.out.println("[15:00] [Coordinator] Дія: Заправка неможлива (триває посадка пасажирів) -> Координатор відкладає заправку.");
                break;

            default:
                System.out.println("[15:00] [Coordinator] Невідома подія.");
        }
    }
}