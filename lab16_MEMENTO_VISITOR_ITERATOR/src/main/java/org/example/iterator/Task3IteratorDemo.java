package org.example.iterator;
import java.util.Iterator;
public class Task3IteratorDemo {
    public static void main(String[] args) {
        runBoardingOrderScenario();
        System.out.println();
        runCateringWithInfantsScenario();
        System.out.println();
        runConcurrentIteratorsScenario();
    }

    private static CabinLayout createSampleCabin() {
        CabinLayout cabin = new CabinLayout("BUK-402");
        cabin.addSeatPassenger(1, "1A", new Passenger("Олена Коваль", "1A", false, "VIP"));
        cabin.addSeatPassenger(1, "1B", new Passenger("Ігор Ткач", "1B", false, null));
        cabin.addSeatPassenger(2, "2A", new Passenger("Марія Шевчук", "2A", false, "UMNR"));
        cabin.addSeatPassenger(2, "2B", new Passenger("Олег Бойко", "2B", false, null));
        cabin.addSeatPassenger(3, "3A", new Passenger("Софія Мельник", "3A", false, null));
        cabin.addSeatPassenger(3, "3B", new Passenger("Денис Савчук", "3B", false, "MEDA"));
        cabin.addInfantWithoutSeat(new Passenger("Артемчик Коваль", null, true, "INF-CHECK"));
        cabin.addInfantWithoutSeat(new Passenger("Міла Ткач", null, true, null));
        return cabin;
    }

    public static void runBoardingOrderScenario() {
        System.out.println("--- Сценарій 1: Посадка (від задніх рядів до передніх) ---");
        CabinLayout cabin = createSampleCabin();
        System.out.println("[09:00] [BoardingService:Iterator] Старт обходу посадки для рейсу "
                + cabin.getFlightNumber() + " (стан: початок обходу)");
        Iterator<Passenger> iterator = cabin.createBoardingIterator();
        int step = 1;
        while (iterator.hasNext()) {
            Passenger p = iterator.next();
            System.out.println("[09:0" + step + "] [BoardingService:Iterator] Крок " + step
                    + " -> " + p + " (стан ітератора: залишилось елементів=" + iterator.hasNext() + ")");
            step++;
        }
        System.out.println("[09:10] [BoardingService:Iterator] Завершено обхід посадки (стан: кінець обходу)");
    }

    public static void runCateringWithInfantsScenario() {
        System.out.println("--- Сценарій 2: Кейтеринг (по рядах спереду + немовлята) ---");
        CabinLayout cabin = createSampleCabin();
        System.out.println("[09:20] [CateringService:Iterator] Старт обходу кейтерингу для рейсу "
                + cabin.getFlightNumber() + " (стан: початок обходу)");
        Iterator<Passenger> iterator = cabin.createCateringIterator();
        int step = 1;
        while (iterator.hasNext()) {
            Passenger p = iterator.next();
            System.out.println("[09:2" + Math.min(step, 9) + "] [CateringService:Iterator] Крок " + step
                    + " -> " + p + " (стан ітератора: hasNext=" + iterator.hasNext() + ")");
            step++;
        }
        System.out.println("[09:30] [CateringService:Iterator] Завершено обхід кейтерингу (стан: кінець обходу)");
    }

    public static void runConcurrentIteratorsScenario() {
        System.out.println("--- Сценарій 3: Два незалежні одночасні обходи ---");
        CabinLayout cabin = createSampleCabin();
        Iterator<Passenger> boardingIter = cabin.createBoardingIterator();
        Iterator<Passenger> cateringIter = cabin.createCateringIterator();

        System.out.println("[09:40] [IteratorManager:Iterator] Запущено два незалежні ітератори: "
                + "boardingIter (ззаду) та cateringIter (спереду + немовлята)");

        if (boardingIter.hasNext()) {
            System.out.println("[09:41] [BoardingService:Iterator] Крок 1 (посадка): "
                    + boardingIter.next() + " | стан boardingIter.hasNext=" + boardingIter.hasNext());
        }
        if (boardingIter.hasNext()) {
            System.out.println("[09:42] [BoardingService:Iterator] Крок 2 (посадка): "
                    + boardingIter.next() + " | стан boardingIter.hasNext=" + boardingIter.hasNext());
        }

        if (cateringIter.hasNext()) {
            System.out.println("[09:43] [CateringService:Iterator] Крок 1 (кейтеринг): "
                    + cateringIter.next() + " | стан cateringIter.hasNext=" + cateringIter.hasNext());
        }

        if (boardingIter.hasNext()) {
            System.out.println("[09:44] [BoardingService:Iterator] Крок 3 (посадка): "
                    + boardingIter.next() + " | стан boardingIter.hasNext=" + boardingIter.hasNext());
        }

        if (cateringIter.hasNext()) {
            System.out.println("[09:45] [CateringService:Iterator] Крок 2 (кейтеринг): "
                    + cateringIter.next() + " | стан cateringIter.hasNext=" + cateringIter.hasNext());
        }

        System.out.println("[09:46] [IteratorManager:Iterator] Обидва обходи зберегли власні позиції незалежно один від одного.");
    }
}
