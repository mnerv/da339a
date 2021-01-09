package Controller;

import Model.EntityType;
import Model.Order;
import Model.OrderManager;
import Model.Pizza;
import Model.Topping.Topping;
import View.MainView;
import java.util.Locale;

/**
 * Controller
 */
public class Controller {
    OrderManager manager;
    MainView view;

    EntityType type = EntityType.Food;

    // Temporary storage value
    Order newOrder;
    Pizza customPizza;

    public Controller(MainView view) {
        this.view = view;

        manager = new OrderManager();
        newOrder = new Order();
    }

    /**
     * Getters for the different lists
     */
    public String[] getOrderList() {
        return manager.getOrderList();
    }

    // prints pizza list with the toppings called from getToppingsList as well
    public String[] getPizzaList() {
        type = EntityType.Food;

        var pizzaList = manager.getPizzaList();
        String tmpList[] = new String[pizzaList.size()];

        for (int i = 0; i < tmpList.length; i++) {
            tmpList[i] = pizzaList.get(i).getInfo();
        }

        return tmpList;
    }

    // gets the toppings later shown in either make own pizza or in pizza list
    public String[] getToppingList() {
        Topping toppings[] = manager.getToppingList();
        String tmp[] = new String[toppings.length];

        for (int i = 0; i < toppings.length; i++) {
            tmp[i] = toppings[i].getInfo();
        }

        return tmp;
    }

    public String[] getBeverageList() {
        type = EntityType.Drink;
        var beverageList = manager.getBeverageList();
        String[] tmpList = new String[beverageList.size()];

        for (int i = 0; i < tmpList.length; i++) {
            tmpList[i] = beverageList.get(i).toString();
        }

        return tmpList;
    }

    public String[] getDetailList() {
        return newOrder.getProductList();
    }

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

    public void addPizza(int i, int quantity) {
        newOrder.addProduct(manager.getPizzaList().get(i), quantity);
    }

    public void addBeverage(int i, int quantity) {
        newOrder.addProduct(manager.getBeverageList().get(i), quantity);
    }

    public void removeProductAt(int i, int quantity) {
        newOrder.removeProductAt(i, quantity);
    }

    public boolean checkout() {
        Order tmp = newOrder;

        if (newOrder != null && newOrder.getProductList().length != 0 && newOrder.isTherePizza()) {
            manager.addOrder(tmp);

            newOrder = new Order();
            return true;
        }

        return false;
    }

    public boolean isTherePizza() {
        return newOrder.isTherePizza();
    }

    public void newCustomPizza(String name) {
        customPizza = new Pizza(name);
    }

    public void saveCustomPizza() {
        if (customPizza.getToppings().length > 0)
            manager.addCustomPizza(customPizza);
    }

    public boolean addTopping(int i) {
        return customPizza.addTopping(manager.getToppingList()[i]);
    }

    public void removeToppingAt(int i) {
        customPizza.removeToppingAt(i);
    }

    public String[] getAddedToppingList() {
        return customPizza.getToppings();
    }

    public double getCustomPrice() {
        return customPizza.getPrice();
    }

    public String getTotal() {
        return String.format(new Locale("en", "UK"), "%.2f kr", newOrder.getTotal());
    }

    public boolean setSelectOrder(int i) {
        return manager.selectOrder(i);
    }

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

    public int getSelectedOrderID() {
        return manager.getSelectedOrder().getID();
    }

    public void setOver18(boolean tof) {
        manager.setIsOver18(tof);
    }
}