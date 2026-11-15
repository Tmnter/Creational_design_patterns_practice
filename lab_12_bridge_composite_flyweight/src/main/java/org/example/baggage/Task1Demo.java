package org.example.baggage;

public class Task1Demo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 1: Composite (Завантаження літака) ===\n");

        // Збираємо структуру: літак -> 2 відсіки -> контейнери -> валізи/посилки та палета всередині контейнера
        CargoContainer plane = new CargoContainer("Літак Boeing 737");

        // Відсік 1
        CargoContainer compartment1 = new CargoContainer("Багажний відсік 1");
        CargoContainer containerA = new CargoContainer("Контейнер A");
        containerA.add(new Item("Валізи пасажирів (економ)", 150.5));
        containerA.add(new Item("Посилка пошти", 25.0));

        // Палета всередині контейнера (додатковий рівень вкладеності)
        CargoContainer pallet = new CargoContainer("Палета спецвантажу");
        pallet.add(new Item("Крихкий вантаж", 40.0));
        pallet.add(new Item("Додаткова посилка", 10.0));
        containerA.add(pallet);

        compartment1.add(containerA);

        // Відсік 2
        CargoContainer compartment2 = new CargoContainer("Багажний відсік 2");
        CargoContainer containerB = new CargoContainer("Контейнер B (бізнес-клас)");
        containerB.add(new Item("Валізи VIP", 85.0));
        compartment2.add(containerB);

        // Додаємо відсіки до літака
        plane.add(compartment1);
        plane.add(compartment2);

        // Виводити структуру деревом з вагою кожного вузла
        System.out.println("[13:00] [System] Виведення ієрархії вантажу літака:");
        plane.print("");

        // Вивести загальну вагу літака і вагу одного відсіку тим самим викликом getWeight()
        System.out.println("\n[13:00] [System] Результати розрахунків через єдиний інтерфейс:");
        System.out.println("[13:00] [Calculation] Вага окремого відсіку (Багажний відсік 1): " + compartment1.getWeight() + " кг");
        System.out.println("[13:00] [Calculation] Загальна вага літака: " + plane.getWeight() + " кг");
    }
}