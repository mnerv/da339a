package Model;

/**
 * Beverage
 *
 * <p>
 * Stores the name, price and alcohol content of the beverage.
 * </p>
 */
public class Beverage extends Entity {
    private double alcoholContent;

    public Beverage(String name, double price) {
        this(name, price, 0.);
    }

    public Beverage(String name, double price, double alcoholContent) {
        this.name = name;
        this.price = price;
        this.alcoholContent = alcoholContent;
    }

    /**
     * Get price of the Beverage
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get if the beverage is an alcohol
     *
     * @return True if it's an alcohol and False if it's not.
     */
    public boolean getIsAlcohol() {
        return alcoholContent > 0.0;
    }

    /**
     * Get beverage info
     *
     * @return Formatted text with beverage information.
     */
    @Override
    public String getInfo() {
        return toString();
    }

    /**
     * Return beverage information such as price and name
     *
     * @return Formatted text with beverage information.
     */
    @Override
    public String toString() {
        String format = String.format("%s, ", name);
        if (alcoholContent > 0.)
            format += String.format(LOCALE, "Alcohol: %.2f", alcoholContent);
        return String.format(LOCALE, "%s, Price: %s", format, price);
    }
}