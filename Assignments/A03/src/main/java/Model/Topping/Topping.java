package Model.Topping;

public class Topping {
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
        return String.format("%s, Price: %.2f kr", name, price);
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
