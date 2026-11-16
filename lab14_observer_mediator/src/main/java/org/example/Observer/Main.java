// Main.java
public class Main {
    public static void main(String[] args) {
        runTask2FlightNotificationScenario();
    }

    public static void runTask2FlightNotificationScenario() {
        System.out.println("=== ДЕМОНСТРАЦІЙНИЙ СЦЕНАРІЙ: СПОВІЩЕННЯ ПРО СТАТУС РЕЙСУ (OBSERVER) ===\n");

        // Створюємо рейс PS-101
        Flight flightPS101 = new Flight("PS-101", "A1");

        // Створюємо отримувачів сповіщень
        FlightObserver displayBoard = new DisplayBoard("Головний зал");
        FlightObserver passenger = new Passenger("Олена Ковальчук");
        FlightObserver catering = new CateringService();
        FlightObserver taxiService = new TaxiService("Буковина-Таксі");

        // Крок 1: Підписати табло, пасажира і кейтеринг на рейс PS-101 і затримати рейс
        System.out.println("--- Крок 1: Підписка базових отримувачів та затримка рейсу ---");
        flightPS101.subscribe(displayBoard);
        flightPS101.subscribe(passenger);
        flightPS101.subscribe(catering);
        System.out.println();

        flightPS101.delayFlight(45, "погодні умови в аеропорту прибуття");
        System.out.println();

        // Крок 2: Підписати таксі-сервіс, змінити вихід на посадку -> реагують усі четверо
        System.out.println("--- Крок 2: Підписка таксі-сервісу та зміна виходу ---");
        flightPS101.subscribe(taxiService);
        System.out.println();

        flightPS101.changeGate("B4");
        System.out.println();

        // Крок 3: Відписати кейтеринг, почати посадку -> кейтеринг не отримує сповіщення
        System.out.println("--- Крок 3: Відписка кейтерингу та початок посадки ---");
        flightPS101.unsubscribe(catering);
        System.out.println();

        flightPS101.startBoarding();
    }
}