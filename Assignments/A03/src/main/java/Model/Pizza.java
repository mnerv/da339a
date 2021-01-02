package Model;

import Model.Topping.*;

public class Pizza extends Entity {
    final int MAX_TOPPINGS = 6;
    final double BASE_PRICE = 30.00;

    private int maxToppings = MAX_TOPPINGS;
    private int toppingCount = 0;
    private Topping[] toppings = new Topping[MAX_TOPPINGS];

    public Pizza() {
        super();
    }

    public Pizza(String name) {
        this.name = name;
        this.type = EntityType.Food;
        price = BASE_PRICE;
    }

    public Pizza(String name, int maxToppings) {
        this(name);
        toppings = new Topping[MAX_TOPPINGS];
    }

    public boolean addTopping(Topping topping) {
        if (toppingCount < MAX_TOPPINGS) {
            price += topping.getPrice();
            toppings[toppingCount] = topping;
            toppingCount++;

            return true;
        }

        return false;
    }

    public boolean removeToppingAt(int index) {
        if (index > -1 && index < maxToppings - 1 && toppings[index] != null) {
            toppings[index] = null;
            toppingCount--;

            int nullCount = toppings.length - toppingCount;
            for (int i = 0; i < toppings.length - 1; i++) {
                if (toppings[i] == null) {
                    Topping tmp = toppings[i];
                    toppings[i] = toppings[i + 1];
                    toppings[i + 1] = tmp;

                    nullCount--;
                }

                if (nullCount != 0 && i > toppings.length - 2)
                    i = 0;
            }

            return true;
        }

        return false;
    }

    public String[] getToppings() {
        String[] tmp = new String[toppingCount];

        for (int i = 0; i < toppingCount; i++) tmp[i] = toppings[i].getName();

        return tmp;
    }

    @Override
    public String toString() {
        // use for cart list
        return String.format("Pizza: %s, Price: %.2f", name, price);
    }

    @Override
    public String getInfo() {
        // Arrays.toString(toppings),
        String t = "";
        for (int i = 0; i < toppingCount; i++) {
            t += toppings[i].getName();
            if (i < toppings.length - 1)
                t += ", ";
        }

        return String.format("%s, Toppings: %s, Price: %.2f kr", name, t, price);
    }
}