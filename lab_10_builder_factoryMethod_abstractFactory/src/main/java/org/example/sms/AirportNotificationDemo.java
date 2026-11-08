package sms;
import java.util.ArrayList;
import java.util.List;

public class AirportNotificationDemo {
    public static void main(String[] args) {
        Logger.log("Main", "=== Демонстрація Завдання 3: Сповіщення пасажирів (Варіант 1) ===");

        String flight = "PS-101";
        String delayMessage = "Рейс затримується на 40 хвилин.";

        // Сценарій 1: Сповіщення через SMS, e-mail і табло[cite: 7]
        Logger.log("Main", "--- Сценарій 1: Затримка рейсу через стандартні канали ---");
        List<NotificationProcess> standardProcesses = new ArrayList<>();
        standardProcesses.add(new SmsNotificationProcess());
        standardProcesses.add(new EmailNotificationProcess());
        standardProcesses.add(new BoardNotificationProcess());

        for (NotificationProcess process : standardProcesses) {
            process.notifyPassenger(flight, delayMessage);
        }

        // Сценарій 2 та 3: Додавання каналу «мобільний застосунок» і повторне оповіщення[cite: 7]
        Logger.log("Main", "--- Сценарій 2 & 3: Зміна виходу з додаванням нового каналу (MobileApp) ---");
        String gateMessage = "Змінено вихід на посадку для рейсу " + flight + " на вихід №4.";

        List<NotificationProcess> allProcesses = new ArrayList<>();
        allProcesses.add(new SmsNotificationProcess());
        allProcesses.add(new EmailNotificationProcess());
        allProcesses.add(new BoardNotificationProcess());
        allProcesses.add(new MobileAppNotificationProcess()); // Новий клас каналу[cite: 6]

        for (NotificationProcess process : allProcesses) {
            process.notifyPassenger(flight, gateMessage);
        }
    }
}