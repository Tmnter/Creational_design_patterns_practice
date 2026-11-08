package main.java.org.example.teletrap;
public class AirportSimulation {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 3: РОЗПОДІЛ ТЕЛЕТРАПІВ ===");
        
        // В аеропорту є 3 фізичні телетрапи
        TelebridgePool pool = new TelebridgePool(3);

        System.out.println("\n--- Сценарій: Прибуття 5 рейсів майже одночасно ---");
        pool.acquireBridge("PS-201");
        pool.acquireBridge("PS-202");
        pool.acquireBridge("PS-203");
        // 4-й і 5-й рейси не отримають телетрап і підуть у чергу/на автобус
        pool.acquireBridge("PS-204");
        pool.acquireBridge("PS-205");

        System.out.println("\n--- Сценарій: Рейс PS-201 завершує обслуговування і звільняє телетрап Т-1 ---");
        pool.releaseBridge("Т-1");

        // Виведення кінцевої статистики
        pool.printStatistics();
    }
}