package org.example.baggage;
import java.util.ArrayList;
import java.util.List;
class CargoContainer implements CargoComponent {
    private final String name;
    private final List<CargoComponent> children = new ArrayList<>();

    public CargoContainer(String name) {
        this.name = name;
    }

    public void add(CargoComponent component) {
        children.add(component);
    }

    @Override
    public double getWeight() {
        double totalWeight = 0;
        for (CargoComponent child : children) {
            totalWeight += child.getWeight();
        }
        return totalWeight;
    }

    @Override
    public void print(String indent) {
        System.out.println("[13:00] [Container] " + indent + "+ Контейнер/Вузол: " + name + " [Загальна вага: " + getWeight() + " кг]");
        for (CargoComponent child : children) {
            child.print(indent + "  ");
        }
    }
}