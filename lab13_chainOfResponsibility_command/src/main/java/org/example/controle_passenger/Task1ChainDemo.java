package org.example.controle_passenger;

public class Task1ChainDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 1: Chain of Responsibility (Передпольотний контроль) ===\n");


        CheckHandler ticketCheck = new TicketCheckHandler();
        CheckHandler passportCheck = new PassportCheckHandler();
        CheckHandler customsCheck = new CustomsCheckHandler();
        CheckHandler securityCheck = new SecurityCheckHandler();
        CheckHandler luggageCheck = new LuggageWeightCheckHandler();


        System.out.println("--- Сценарій 1: Пасажир міжнародного рейсу (успішне проходження) ---");
        ticketCheck.setNext(passportCheck)
                .setNext(customsCheck)
                .setNext(securityCheck)
                .setNext(luggageCheck);

        Passenger internationalPassenger = new Passenger("Олександр (Міжнародний)", true, true, true, true, 8.5);
        ticketCheck.handle(internationalPassenger);
        System.out.println();

        System.out.println("--- Сценарій 2: Пасажир з перевищенням ваги ручної поклажі (12 кг) ---");
        Passenger heavyLuggagePassenger = new Passenger("Марія (Важкий багаж)", true, true, true, true, 12.0);
        ticketCheck.handle(heavyLuggagePassenger);
        System.out.println();


        System.out.println("--- Сценарій 3: Пасажир внутрішнього рейсу (короткий ланцюг без паспорта) ---");

        CheckHandler domesticTicketCheck = new TicketCheckHandler();
        CheckHandler domesticSecurityCheck = new SecurityCheckHandler();
        CheckHandler domesticLuggageCheck = new LuggageWeightCheckHandler();

        domesticTicketCheck.setNext(domesticSecurityCheck).setNext(domesticLuggageCheck);

        Passenger domesticPassenger = new Passenger("Іван (Внутрішній рейс)", false, true, false, true, 7.0);
        domesticTicketCheck.handle(domesticPassenger);
    }
}
