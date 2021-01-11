package Model;

public class Pizza extends Entity {
    private final int MAX_TOPPINGS = 6;
    private final double BASE_START_PRICE = 30.00;

    private int toppingCount = 0;
    private Topping[] toppings = new Topping[MAX_TOPPINGS];

    public Pizza() {
        super();
    }

    public Pizza(String name) {
        this.name = name;
        this.type = EntityType.Food;
        price = BASE_START_PRICE;
    }

    public Pizza(String name, int maxToppings) {
        this(name);
        toppings = new Topping[MAX_TOPPINGS];
    }

    /**
     * Add a topping onto the pizza.
     *
     * @param topping The topping that need to be added.
     *
     * @return True success and False if the list is full. Check MAX_TOPPINGS to change the maximum.
     */
    public boolean addTopping(Topping topping) {
        if (toppingCount < toppings.length) {
            price += topping.getPrice();
            toppings[toppingCount] = topping;
            toppingCount++;

            return true;
        }

        return false;
    }

    /**
     * Removed a topping on the pizza.
     *
     * @param index Location of the topping in the list.
     *
     * @return True if successful and False for unsuccessful.
     */
    public boolean removeToppingAt(int index) {
        if (index > -1 && index < MAX_TOPPINGS - 1 && toppings[index] != null) {
            price -= toppings[index].getPrice();

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

    /**
     * Get toppings on the pizza.
     *
     * @return The list of toppings in array of strings.
     */
    public String[] getToppings() {
        String[] tmp = new String[toppingCount];

        for (int i = 0; i < toppingCount; i++) tmp[i] = toppings[i].getName();

        return tmp;
    }

    @Override
    public String getInfo() {
        String t = "";
        for (int i = 0; i < toppingCount; i++) {
            t += toppings[i].getName();
            if (i < toppingCount - 1)
                t += ", ";
        }

        return String.format(LOCALE, "%s: %s, Price: %.2f kr", name, t, price);
    }

    @Override
    public String toString() {
        return String.format(LOCALE, "%s, Price: %.2f kr", name, price);
    }
}