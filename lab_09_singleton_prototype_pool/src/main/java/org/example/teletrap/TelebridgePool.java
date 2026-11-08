package main.java.org.example.teletrap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TelebridgePool {
    private List<Telebridge> pool;
    private Queue<String> waitingQueue;
    private int totalCreatedCount;

    public TelebridgePool(int capacity) {
        pool = new ArrayList<>();
        waitingQueue = new LinkedList<>();
        totalCreatedCount = 0;

        // Створюємо обмежену кількість фізичних телетрапів
        for (int i = 1; i <= capacity; i++) {
            Telebridge bridge = new Telebridge("Т-" + i);
            bridge.prepare(); // Дорога операція підготовки
            pool.add(bridge);
            totalCreatedCount++;
        }
    }

    // Отримати вільний телетрап або поставити в чергу
    public void acquireBridge(String flightId) {
        Telebridge freeBridge = getAvailableBridge();
        if (freeBridge != null) {
            freeBridge.occupy(flightId);
        } else {
            // Стратегія: рейс очікує в черзі або отримує автобус до перону
            waitingQueue.add(flightId);
            System.out.println("[10:01] [Черга] Вільних телетрапів немає. Рейс " + flightId + " очікує в черзі або направлений на автобус до перону.");
        }
    }

    // Повернути телетрап у пул
    public void releaseBridge(String bridgeId) {
        Telebridge bridge = findBridgeById(bridgeId);
        if (bridge != null && bridge.isBusy()) {
            bridge.reset();
            
            // Якщо є рейси в черзі, одразу видаємо звільнений телетрап наступному
            if (!waitingQueue.isEmpty()) {
                String nextFlight = waitingQueue.poll();
                System.out.println("[10:06] [Черга] Рейс " + nextFlight + " дочекався звільнення телетрапа.");
                bridge.occupy(nextFlight);
            }
        }
    }

    private Telebridge getAvailableBridge() {
        for (Telebridge bridge : pool) {
            if (!bridge.isBusy()) {
                return bridge;
            }
        }
        return null;
    }

    private Telebridge findBridgeById(String id) {
        for (Telebridge bridge : pool) {
            if (bridge.getId().equals(id)) {
                return bridge;
            }
        }
        return null;
    }

    public void printStatistics() {
        System.out.println("\n--- СТАТИСТИКА ТЕЛЕТРАПІВ ---");
        for (Telebridge bridge : pool) {
            System.out.println("Телетрап " + bridge.getId() + " використано разів: " + bridge.getUsageCount());
        }
        System.out.println("Загальна кількість створених телетрапів у моделі: " + totalCreatedCount);
    }
}