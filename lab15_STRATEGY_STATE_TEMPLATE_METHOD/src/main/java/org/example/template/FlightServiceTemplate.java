package org.example.template;

// Абстрактний клас із шаблонним методом
abstract class FlightServiceTemplate {
    private final String flightNumber;

    protected FlightServiceTemplate(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    // Шаблонний метод: фіксує загальну послідовність етапів в одному місці
    public final void serveFlight() {
        System.out.println("[10:00] [TemplateMethod:" + getServiceTypeName() + "] Старт обслуговування рейсу " + flightNumber);
        receiveAircraft();
        unload();
        if (needsCabinCleaning()) {
            cleanCabin();
        }
        prepareForDeparture();
        load();
        releaseAircraft();
        System.out.println("[10:15] [TemplateMethod:" + getServiceTypeName() + "] Завершено обслуговування рейсу " + flightNumber);
    }

    protected abstract String getServiceTypeName();

    protected void receiveAircraft() {
        System.out.println("[10:01] [" + getServiceTypeName() + "] Крок [receiveAircraft]: Прийнято борт " + flightNumber + " на стоянку.");
    }

    protected abstract void unload();

    // Необов'язковий крок (hook) із поведінкою за замовчуванням
    protected boolean needsCabinCleaning() {
        return true;
    }

    protected void cleanCabin() {
        System.out.println("[10:04] [" + getServiceTypeName() + "] Крок [cleanCabin]: Виконано стандартне прибирання салону.");
    }

    protected void prepareForDeparture() {
        System.out.println("[10:07] [" + getServiceTypeName() + "] Крок [prepareForDeparture]: Підготовка борту до вильоту (технічний огляд, заправка, узгодження).");
    }

    protected abstract void load();

    protected void releaseAircraft() {
        System.out.println("[10:12] [" + getServiceTypeName() + "] Крок [releaseAircraft]: Борт " + flightNumber + " випущено на зліт.");
    }
}