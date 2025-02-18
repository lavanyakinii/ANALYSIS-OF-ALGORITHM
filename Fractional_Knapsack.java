import java.util.*;

class Item {
    double weight, value;

    Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    double getRatio() {
        return value / weight;
    }
}

class Knapsack {
    public static double fractionalKnapsack(int capacity, Item[] items) {
        Arrays.sort(items, (a, b) -> Double.compare(b.getRatio(), a.getRatio()));
        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0)
                break;

            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.value * ((double) capacity / item.weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        int capacity = 50;
        System.out.println("Maximum value in Knapsack = " + fractionalKnapsack(capacity, items));
    }
}
