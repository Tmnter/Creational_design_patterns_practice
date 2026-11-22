package org.example.memento;

public class Task2MementoDemo {
    public static void main(String[] args) {
        runScheduleDraftScenario();
    }

    public static void runScheduleDraftScenario() {
        System.out.println("--- Сценарій: Чернетка розкладу (Memento) ---");
        ScheduleEditor editor = new ScheduleEditor();
        ScheduleHistory history = new ScheduleHistory();

        // 1. Скласти розклад з 4 рейсів і зберегти варіант «базовий»
        editor.addFlight("BUK-101", "07:00", "G1", "RWY-1");
        editor.addFlight("BUK-102", "08:15", "G2", "RWY-1");
        editor.addFlight("BUK-103", "09:30", "G3", "RWY-2");
        editor.addFlight("BUK-104", "11:00", "G4", "RWY-2");
        history.save("базовий", editor.saveSnapshot("базовий"));

        // 2. Внести кілька змін, зберегти варіант «ранковий пік», внести ще зміни
        editor.rescheduleFlight("BUK-101", "06:45", "G5", "RWY-1");
        editor.rescheduleFlight("BUK-102", "07:50", "G1", "RWY-2");
        history.save("ранковий пік", editor.saveSnapshot("ранковий пік"));

        editor.rescheduleFlight("BUK-103", "10:15", "G6", "RWY-1");
        editor.rescheduleFlight("BUK-104", "12:20", "G2", "RWY-2");
        editor.printSchedule("після додаткових змін перед відновленням");

        // 3. Відновити варіант «базовий», потім «ранковий пік», виводячи розклад після кожного відновлення
        editor.restoreSnapshot(history.get("базовий"));
        editor.printSchedule("після відновлення 'базовий'");

        editor.restoreSnapshot(history.get("ранковий пік"));
        editor.printSchedule("після відновлення 'ранковий пік'");
    }
}