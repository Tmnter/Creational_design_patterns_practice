package sms;
interface Notification {
    void send(String flightNumber, String messageText);
}

// Конкретні продукти (канали сповіщень)
class SmsNotification implements Notification {
    @Override
    public void send(String flightNumber, String messageText) {
        Logger.log("SMS-Channel", "Надсилання SMS для рейсу " + flightNumber + ": \"" + messageText + "\"");
    }
}

class EmailNotification implements Notification {
    @Override
    public void send(String flightNumber, String messageText) {
        Logger.log("Email-Channel", "Надсилання електронного листа для рейсу " + flightNumber + ": \"" + messageText + "\"");
    }
}

class BoardNotification implements Notification {
    @Override
    public void send(String flightNumber, String messageText) {
        Logger.log("DisplayBoard", "Виведення на табло для рейсу " + flightNumber + ": \"" + messageText + "\"");
    }
}

// Новий клас каналу (додано без зміни загального процесу)[cite: 6]
class MobileAppNotification implements Notification {
    @Override
    public void send(String flightNumber, String messageText) {
        Logger.log("MobileApp", "Push-повідомлення у застосунку для рейсу " + flightNumber + ": \"" + messageText + "\"");
    }
}

// Абстрактний творець (процес сповіщення)
abstract class NotificationProcess {
    public abstract Notification createNotification();

    // Загальний процес описаний один раз[cite: 6]
    public void notifyPassenger(String flightNumber, String messageText) {
        Logger.log("NotificationSystem", "Підготовка до сповіщення пасажирів...");
        Notification notification = createNotification();
        notification.send(flightNumber, messageText);
        Logger.log("NotificationSystem", "Запис події сповіщення в системний журнал.");
    }
}

// Конкретні творці для кожного каналу
class SmsNotificationProcess extends NotificationProcess {
    @Override
    public Notification createNotification() { return new SmsNotification(); }
}

class EmailNotificationProcess extends NotificationProcess {
    @Override
    public Notification createNotification() { return new EmailNotification(); }
}

class BoardNotificationProcess extends NotificationProcess {
    @Override
    public Notification createNotification() { return new BoardNotification(); }
}

class MobileAppNotificationProcess extends NotificationProcess {
    @Override
    public Notification createNotification() { return new MobileAppNotification(); }
}