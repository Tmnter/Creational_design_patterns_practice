package org.example.baggage;

class Item implements CargoComponent {
    private final String name;
    private final double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void print(String indent) {
        System.out.println("[13:00] [Cargo] " + indent + "- " + name + " (Вага: " + weight + " кг)");
    }
}
