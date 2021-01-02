package Model;

/**
 * Drinks
 */
public class Drinks extends Entity {
    String name;
    double price;

    public Drinks() {
        super();
    }

    // TODO: Alcohol drinks and show alcohol % of all drinks
    public Drinks(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Drink: %s, Price: %s", name, price);
    }

    @Override
    public String getInfo() {
        return toString();
    }
}