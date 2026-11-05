package org.example.flight;
import java.util.ArrayList;
import java.util.List;
class Flight implements Cloneable {
    private String route;
    private String date;
    private CabinLayout cabinLayout;
    private List<String> menu;

    public Flight(String route, String date, String layoutType) {
        this.route = route;
        this.date = date;
        System.out.println("[09:00] [Еталон] Дороге завантаження конфігурації літака та параметрів для маршруту " + route + "...");
        this.cabinLayout = new CabinLayout(layoutType);
        this.menu = new ArrayList<>();
        this.menu.add("Стандартне меню");
    }

    public void setMenu(String newMenu) {
        this.menu.add(newMenu);
    }

    public void blockSeat(String seat) {
        cabinLayout.blockSeat(seat);
    }

    @Override
    public Flight clone() {
        try {
            Flight cloned = (Flight) super.clone();
            cloned.cabinLayout = this.cabinLayout.clone(); // глибоке копіювання вкладеного об'єкта
            cloned.menu = new ArrayList<>(this.menu);       // глибоке копіювання меню
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void displayInfo(String label) {
        System.out.println("[" + label + "]: Маршрут: " + route + " | Дата: " + date + " | Меню: " + menu + " | " + cabinLayout);
    }
}