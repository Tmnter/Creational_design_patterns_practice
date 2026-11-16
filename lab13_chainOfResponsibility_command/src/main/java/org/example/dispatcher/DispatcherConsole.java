package org.example.dispatcher;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class DispatcherConsole {
    private LinkedList<Command> history = new LinkedList<>();
    private Queue<Command> queue = new LinkedList<>();
    private List<String> auditLog = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
        auditLog.add(command.getDescription());
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        } else {
            Logger.log("DispatcherConsole", "Немає дій для скасування.");
        }
    }

    public void addCommandToQueue(Command command) {
        queue.add(command);
        Logger.log("DispatcherConsole", "Додано в чергу: " + command.getDescription());
    }

    public void executeBatch() {
        Logger.log("DispatcherConsole", "Початок пакетного виконання черги команд...");
        while (!queue.isEmpty()) {
            Command command = queue.poll();
            command.execute();
            history.push(command);
            auditLog.add(command.getDescription());
        }
        Logger.log("DispatcherConsole", "Пакетне виконання завершено.");
    }

    public void printAuditLog() {
        Logger.log("AuditSystem", "--- Журнал усіх виконаних дій диспетчера ---");
        for (int i = 0; i < auditLog.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + auditLog.get(i));
        }
    }
}

public class AirportRunner {
    public static void main(String[] args) {
        Logger.log("System", "=== Запуск демонстраційного сценарію Завдання 2 (Варіант 1) ===");

        ScheduleManager flightPS101 = new ScheduleManager("PS-101", "14:00", "A1");
        ScheduleManager flightPS202 = new ScheduleManager("PS-202", "15:00", "B2");
        DispatcherConsole console = new DispatcherConsole();

        // 1. Перенести рейс PS-101 на 15:30 і змінити вихід рейсу PS-202
        Logger.log("Main", "--- Крок 1: Операції в реальному часі ---");
        console.executeCommand(new ChangeFlightTimeCommand(flightPS101, "15:30"));
        console.executeCommand(new ChangeGateCommand(flightPS202, "B5"));

        flightPS101.printSchedule("FlightStatus");
        flightPS202.printSchedule("FlightStatus");

        // 2. Скасувати дві останні дії -> розклад повернувся до початкового
        Logger.log("Main", "--- Крок 2: Скасування останніх двох дій (Undo) ---");
        console.undoLast();
        console.undoLast();

        flightPS101.printSchedule("FlightStatus");
        flightPS202.printSchedule("FlightStatus");

        // 3. Підготувати 3 зміни в черзі, виконати їх пакетом і вивести журнал дій диспетчера
        Logger.log("Main", "--- Крок 3: Підготовка пакету змін та виконання ---");
        console.addCommandToQueue(new ChangeFlightTimeCommand(flightPS101, "16:00"));
        console.addCommandToQueue(new ChangeGateCommand(flightPS202, "C1"));
        console.addCommandToQueue(new ChangeFlightTimeCommand(flightPS101, "16:15"));

        console.executeBatch();
        console.printAuditLog();
    }
}