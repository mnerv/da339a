/**
 * Author: Pratchaya Khansomboon
 *
 * Created: 2020-12-10
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderManager
 *
 * <p>
 * The order manager contain the list of available pizza and beverages and list of orders. This will
 * create the unique id for different orders and will check which beverages can be shown.
 * </p>
 */
public class OrderManager {
    private List<Pizza> pizzaList;
    private List<Beverage> beverageList;

    private final int TOPPINGS_COUNT = 14;
    private Topping toppingList[];
    private int toppingCount = 0;

    private List<Order> orders;
    private int orderID = 0;
    private int selectedOrder = -1;

    private boolean isOver18 = false;

    private int productIDCounter = 0;

    public OrderManager() {
        toppingList = new Topping[TOPPINGS_COUNT];
        orders = new ArrayList<Order>();
        pizzaList = new ArrayList<Pizza>();
        beverageList = new ArrayList<Beverage>();
    }

    /**
     * Add order to the order list
     *
     * @param order
     */
    public void addOrder(Order order) {
        order.setID(orderID);
        orderID++;

        orders.add(order);
    }

    /**
     * Select an order
     *
     * @param i Order index in the list
     *
     * @return ToF: If selected index is within the range.
     */
    public boolean selectOrder(int i) {
        if (i > -1 && i < orders.size()) {
            selectedOrder = i;
            return true;
        }

        return false;
    }

    /**
     * Get selected order.
     *
     * @return If there's no selection i.e the selection index is at -1 then null is
     * returned.
     */
    public Order getSelectedOrder() {
        if (selectedOrder > -1)
            return orders.get(selectedOrder);

        return null;
    }

    /**
     * Update the selected order.
     *
     * @param order The order that needs to be updated.
     */
    public void updateSelectedOrder(Order order) {
        if (selectedOrder > -1)
            orders.set(selectedOrder, order);
    }

    /**
     * Get the created order list
     *
     * @return The list of orders in array of strings.
     */
    public String[] getOrderList() {
        String tmpList[] = new String[orders.size()];
        for (int i = 0; i < tmpList.length; i++) tmpList[i] = orders.get(i).toString();

        return tmpList;
    }

    /**
     * Add pizza to the pizza list that can be order from.
     *
     * @param pizza The pizza that needs to be added.
     */
    public void addPizza(Pizza pizza) {
        pizza.setID(productIDCounter++);
        pizzaList.add(pizza);
    }

    /**
     * Get the pizza list
     *
     * @return List of pizza
     */
    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    /**
     * Add topping to the available topping list.
     *
     * @param topping Valid topping
     *
     * @return True if the addition is successful and False for unsuccessful.
     */
    public boolean addTopping(Topping topping) {
        if (toppingCount < toppingList.length) {
            toppingList[toppingCount] = topping;
            toppingCount++;

            return true;
        }

        return false;
    }

    /**
     * Add beverage to the beverage list
     *
     * @param beverage The beverage that needs to be added into the list.
     */
    public void addBeverage(Beverage beverage) {
        beverage.setID(productIDCounter++);
        beverageList.add(beverage);
    }

    /**
     * Get the available toppings.
     *
     * @return Array of toppings
     */
    public Topping[] getToppingList() {
        return toppingList;
    }

    /**
     * Get the available beverages.
     *
     * @return Beverage list
     */
    public List<Beverage> getBeverageList() {
        List<Beverage> list = new ArrayList<>();

        for (int i = 0; i < beverageList.size(); i++) {
            if (isOver18) {
                list.add(beverageList.get(i));
            } else if (!beverageList.get(i).getIsAlcohol()) {
                list.add(beverageList.get(i));
            }
        }

        return list;
    }

    /**
     * Get is over 18
     *
     * @return True if over 18, False for under 18
     */
    public boolean getIsOver18() {
        return isOver18;
    }

    /**
     * Set the the is over 18
     *
     * @param tof true for over 18 and false for under 18
     */
    public void setIsOver18(boolean tof) {
        isOver18 = tof;
    }
}