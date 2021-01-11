package Model;

/**
 * Topping
 *
 * <p>
 * The pizza toppings. This is used for calculate the price of the pizza.
 * </p>
 */
public class Topping extends Entity {
    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
        this.type = EntityType.Misc;
    }

    /**
     * Get topping info, such as price and name.
     *
     * @return Formatted string with topping information.
     */
    @Override
    public String getInfo() {
        return String.format(LOCALE, "%s, Price: %.2f kr", name, price);
    }

    /**
     * @return Name of topping.
     */
    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
