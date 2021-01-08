package Model.Topping;

import java.util.Locale;

public class Topping {
    private final Locale locale = new Locale("en", "UK");

    private String name;
    private double price;

    public Topping(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return String.format(locale, "%s, Price: %.2f kr", name, price);
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
