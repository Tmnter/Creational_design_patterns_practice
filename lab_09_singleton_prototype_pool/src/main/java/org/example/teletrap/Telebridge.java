public class Telebridge {
    private String id;
    private boolean isBusy;
    private String currentFlight;
    private int usageCount;

    public Telebridge(String id) {
        this.id = id;
        this.isBusy = false;
        this.currentFlight = null;
        this.usageCount = 0;
    }

    public String getId() {
        return id;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public int getUsageCount() {
        return usageCount;
    }

    // Зайняти телетрап рейсом
    public void occupy(String flightId) {
        this.isBusy = true;
        this.currentFlight = flightId;
        this.usageCount++;
        System.out.println("[10:00] [Телетрап " + id + "] Під'єднано до рейсу " + flightId);
    }

    // Скидання стану перед поверненням у пул
    public void reset() {
        System.out.println("[10:05] [Телетрап " + id + "] Від'єднано від борту " + currentFlight + ". Стан скинуто.");
        this.isBusy = false;
        this.currentFlight = null;
    }

    // Довга операція підготовки (емуляція)
    public void prepare() {
        try {
            System.out.println("[09:50] [Телетрап " + id + "] Триває підготовка (підведення, калібрування, перевірка)...");
            Thread.sleep(200); // симуляція затримки
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}