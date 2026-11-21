package org.example.airport_state;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FlightDemoRunner {
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm:ss");

    public void runScenario1() {
        log("Runner", "Початок демонстраційного сценарію: Варіант 1, Завдання 1 (Життєвий цикл рейсу, шаблон State)");

        // 1. Провести рейс через усі стани від «заплановано» до «приземлився»
        Flight flight = new Flight("BUK-101", "A1");
        flight.openCheckIn();
        flight.registerPassenger("Іван Петренко");
        flight.changeGate("A2");
        flight.startBoarding();
        flight.changeGate("B5");
        flight.takeOff();
        flight.land();

        // 2. Спробувати зареєструвати пасажира на рейс у стані «вилетів» -> зрозуміла відмова
        flight.registerPassenger("Олена Коваль");

        // 3. Затримати рейс під час реєстрації, а потім відновити реєстрацію
        Flight flight2 = new Flight("BUK-204", "C3");
        flight2.openCheckIn();
        flight2.registerPassenger("Андрій Мельник");
        flight2.delay("Туман у пункті призначення");
        flight2.registerPassenger("Марія Савченко");
        flight2.resumeCheckIn();
        flight2.registerPassenger("Марія Савченко");
        flight2.cancel("Несприятливі метеоумови");

        log("Runner", "Завершення демонстраційного сценарію.");
    }

    static void log(String source, String event) {
        String timestamp = LocalTime.now().format(TIME_FMT);
        System.out.println("[" + timestamp + "] [" + source + "] " + event);
    }
}