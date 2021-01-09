package Model;

import java.util.Locale;

/**
 * Drinks
 */
public class Beverage extends Entity {
    private final Locale LOCALE = new Locale("en", "UK");

    private double alcoholContent;

    public Beverage(String name, double price) {
        this(name, price, 0.);
    }

    public Beverage(String name, double price, double alcoholContent) {
        this.name = name;
        this.price = price;
        this.alcoholContent = alcoholContent;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsAlcohol() {
        return alcoholContent > 0.0;
    }

    // what to order
    @Override
    public String getInfo() {
        return toString();
    }

    // used in the cart
    @Override
    public String toString() {
        String format = String.format("%s, ", name);
        if (alcoholContent > 0.)
            format += String.format(LOCALE, "Alcohol: %.2f", alcoholContent);
        return String.format(LOCALE, "%s, Price: %s", format, price);
        // return String.format("%s, Alcohol: %.2f %%, Price: %s kr", name, alcoholContent, price);
    }
}