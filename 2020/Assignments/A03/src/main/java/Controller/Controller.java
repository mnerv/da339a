/**
 * Author: Pratchaya Khansomboon
 *
 * Created: 2020-11-26
 */
package Controller;

import Model.Beverage;
import Model.EntityType;
import Model.Order;
import Model.OrderManager;
import Model.Pizza;
import Model.Topping;
import View.MainView;
import java.util.Locale;

/**
 * Controller for managing the pizza, beverage and order list
 *
 * <p>
 * The controller is the communication between the model and view. It has the logic to perform
 * storage for different data.
 * </p>
 */
public class Controller {
    OrderManager manager;
    MainView view;

    EntityType type = EntityType.Food;

    // Temporary storage value
    Order newOrder;
    Pizza customPizza;

    public Controller(MainView view) {
        manager = new OrderManager();
        newOrder = new Order();

        initPizzaList();
        initToppingList();
        initBeverageList();

        this.view = view;
    }

    /**
     * Get list of order ID
     *
     * @return List of created orders
     */
    public String[] getOrderList() {
        return manager.getOrderList();
    }

    /**
     * Get available pizza list
     *
     * @return Pizza List in array of string
     */
    public String[] getPizzaList() {
        type = EntityType.Food;

        var pizzaList = manager.getPizzaList();
        String tmpList[] = new String[pizzaList.size()];

        for (int i = 0; i < tmpList.length; i++) {
            tmpList[i] = pizzaList.get(i).getInfo();
        }

        return tmpList;
    }

    /**
     * Get available topping list
     *
     * @return Topping List in array of string
     */
    public String[] getToppingList() {
        Topping toppings[] = manager.getToppingList();
        String tmp[] = new String[toppings.length];

        for (int i = 0; i < toppings.length; i++) {
            tmp[i] = toppings[i].getInfo();
        }

        return tmp;
    }

    /**
     * Get available beverage list
     *
     * @return Beverage List in array of string
     */
    public String[] getBeverageList() {
        type = EntityType.Drink;
        var beverageList = manager.getBeverageList();
        String[] tmpList = new String[beverageList.size()];

        for (int i = 0; i < tmpList.length; i++) {
            tmpList[i] = beverageList.get(i).toString();
        }

        return tmpList;
    }

    /**
     * Get Order detail product list and its quantity
     *
     * @return Product list in cart
     */
    public String[] getDetailList() {
        return newOrder.getProductList();
    }

    /**
     * Add product to cart. The method is called by another method that determine if it's pizza list
     * or beverage list.
     *
     * @param i Product location index in the list
     * @param quantity The quantity of the product that needs to be added
     */
    public void addProduct(int i, int quantity) {
        switch (type) {
            case Food:
                addPizza(i, quantity);
                break;
            case Drink:
                addBeverage(i, quantity);
                break;
        }
    }

    /**
     * Add pizza to the cart list
     *
     * @param i Location index in the selected list
     * @param quantity The quantity of the product
     */
    public void addPizza(int i, int quantity) {
        newOrder.addProduct(manager.getPizzaList().get(i), quantity);
    }

    /**
     * Add beverage to the cart list
     *
     * @param i Location index in the selected list
     * @param quantity The quantity of the product
     */
    public void addBeverage(int i, int quantity) {
        newOrder.addProduct(manager.getBeverageList().get(i), quantity);
    }

    /**
     * Remove a product in the cart list
     *
     * @param i Location index in the cart list
     * @param quantity Quantity that needs to be remove
     */
    public void removeProductAt(int i, int quantity) {
        newOrder.removeProductAt(i, quantity);
    }

    /**
     * Checkout the current order
     *
     * @return True if checkout is successful, False for unsuccessful.
     */
    public boolean checkout() {
        Order tmp = newOrder;

        if (newOrder != null && newOrder.getProductList().length != 0 && newOrder.isTherePizza()) {
            manager.addOrder(tmp);

            newOrder = new Order();
            return true;
        }

        return false;
    }

    /**
     * Get if there is pizza in the order
     *
     * @return True if there is a pizza and false it there's no pizza
     */
    public boolean isTherePizza() {
        return newOrder.isTherePizza();
    }

    /**
     * Create a new custom pizza with its own unique name
     *
     * @param name Name of the pizza
     */
    public void newCustomPizza(String name) {
        customPizza = new Pizza(name);
    }

    /**
     * Save the custom pizza if there is a topping
     */
    public void saveCustomPizza() {
        if (customPizza.getToppings().length > 0)
            manager.addPizza(customPizza);
    }

    /**
     * Add topping to the custom pizza
     *
     * @param i Location index in list of toppings
     *
     * @return True if the successful and False if the maximum toppings has been reached.
     */
    public boolean addTopping(int i) {
        return customPizza.addTopping(manager.getToppingList()[i]);
    }

    /**
     * Remove a topping from the custom pizza
     *
     * @param i Location index in topping list of the custom pizza.
     */
    public void removeToppingAt(int i) {
        customPizza.removeToppingAt(i);
    }

    /**
     * Get the added topping list in the custom pizza
     *
     * @return List of the added topping in array of strings
     */
    public String[] getAddedToppingList() {
        return customPizza.getToppings();
    }

    /**
     * Get the custom pizza price
     *
     * @return The price of the custom pizza
     */
    public double getCustomPrice() {
        return customPizza.getPrice();
    }

    /**
     * Get the order total
     *
     * @return order total
     */
    public String getTotal() {
        return String.format(new Locale("en", "UK"), "%.2f kr", newOrder.getTotal());
    }

    /**
     * Set the selected order in the order list
     *
     * @param i Location index of the order in order list
     * @return True, selection success. False selection unsuccessful.
     */
    public boolean setSelectOrder(int i) {
        return manager.selectOrder(i);
    }

    /**
     * Get selected order detail
     *
     * @return Formatted text of the order, contain the price, quantity of the product.
     */
    public String getSelectedOrderDetail() {
        Order tmp = manager.getSelectedOrder();
        String[] list = tmp.getProductList();
        String formattedString = "";

        for (int i = 0; i < list.length; i++) {
            formattedString += list[i] + "\n";
        }

        formattedString += ("Total: " + tmp.getTotal() + " kr");
        return formattedString;
    }

    /**
     * Get the selected order id number
     *
     * @return Order ID number
     */
    public int getSelectedOrderID() {
        return manager.getSelectedOrder().getID();
    }

    /**
     * Set if the user is over 18 years old
     *
     * @param tof True for over 18 and false for under 18 years old.
     */
    public void setOver18(boolean tof) {
        manager.setIsOver18(tof);
    }

    /**
     * Initialize predefined pizza list
     */
    private void initPizzaList() {
        Pizza pizza = new Pizza("Vesuvio");
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Cheese);
        pizza.addTopping(Toppings.Ham);
        manager.addPizza(pizza);

        pizza = new Pizza("Calzone Bologneze");
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Cheese);
        pizza.addTopping(Toppings.Ham);
        pizza.addTopping(Toppings.Bolognese);
        manager.addPizza(pizza);

        pizza = new Pizza("Capriccosa");
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Cheese);
        pizza.addTopping(Toppings.Ham);
        pizza.addTopping(Toppings.Mushroom);
        manager.addPizza(pizza);

        pizza = new Pizza("Margeritha");
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Cheese);
        manager.addPizza(pizza);

        pizza = new Pizza("Chicken pizza");
        pizza.addTopping(Toppings.Chicken);
        pizza.addTopping(Toppings.Cheese);
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Peperoncino);
        manager.addPizza(pizza);
    }

    /**
     * Initialize predefined toppings
     */
    private void initToppingList() {
        manager.addTopping(Toppings.TomatoSauce);
        manager.addTopping(Toppings.Chorizo);
        manager.addTopping(Toppings.Salami);
        manager.addTopping(Toppings.Mozzarella);
        manager.addTopping(Toppings.Chicken);
        manager.addTopping(Toppings.Beef);
        manager.addTopping(Toppings.CheddarCheese);
        manager.addTopping(Toppings.Cheese);
        manager.addTopping(Toppings.Ham);
        manager.addTopping(Toppings.Mushroom);
        manager.addTopping(Toppings.Bolognese);
        manager.addTopping(Toppings.Pork);
        manager.addTopping(Toppings.Shrimps);
        manager.addTopping(Toppings.BearnaiseSauce);
    }

    /**
     * Initialize predefined beverage list
     */
    private void initBeverageList() {
        Beverage beverage;

        beverage = new Beverage("Carlsberg", 55.95, 3.5);
        manager.addBeverage(beverage);

        beverage = new Beverage("Vodka", 95.95, 40.0);
        manager.addBeverage(beverage);

        beverage = new Beverage("Cider", 75.95, 4.5);
        manager.addBeverage(beverage);

        beverage = new Beverage("Pilsner", 15.0, 2.25);
        manager.addBeverage(beverage);

        beverage = new Beverage("Red wine", 150.55, 6.5);
        manager.addBeverage(beverage);

        beverage = new Beverage("Water", 0.0);
        manager.addBeverage(beverage);

        beverage = new Beverage("Trocadero", 7.5);
        manager.addBeverage(beverage);

        beverage = new Beverage("Fanta Exotic", 8.0);
        manager.addBeverage(beverage);

        beverage = new Beverage("Coca Cola", 8.5);
        manager.addBeverage(beverage);

        beverage = new Beverage("Non-alcoholic cider", 35.0);
        manager.addBeverage(beverage);
    }
}