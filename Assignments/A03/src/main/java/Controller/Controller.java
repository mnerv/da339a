package Controller;

import Model.EntityType;
import Model.Order;
import Model.OrderManager;
import Model.Pizza;
import Model.Topping.Topping;
import View.MainView;

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

    public Controller() {
        manager = new OrderManager();
        // view = new MainView(this);
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

    public void addProduct(int i, int quantity) {
        if (newOrder == null)
            newOrder = new Order();

        switch (type) {
            case Food:
                addPizza(i, quantity);
                break;
            case Drink:
                addBeverage(i, quantity);
                break;
        }

        // view.updateCartList(newOrder.getProductList());
    }

    // TODO: Fix this so that loop is not needed, it's inefficient
    public void addPizza(int i, int quantity) {
        for (int j = 0; j < quantity; j++) {
            newOrder.addProduct(manager.getPizzaList().get(i));
        }
    }

    // TODO: Fix this so that loop is not needed, it's inefficient
    public void addBeverage(int i, int quantity) {
        for (int j = 0; j < quantity; j++) {
            newOrder.addProduct(manager.getBeverageList().get(i));
        }
    }

    public void removeProductAt(int i, int quantity) {
        newOrder.removeProductAt(i, quantity);
        // view.updateCartList(newOrder.getProductList());
    }

    public boolean checkout() {
        Order tmp = newOrder;

        if (newOrder != null && newOrder.getProductList().length != 0 && newOrder.isTherePizza()) {
            manager.addOrder(tmp);

            newOrder = new Order();
            // view.updateOrderList(manager.getOrderList());
            // view.updateCartList(newOrder.getProductList());
            return true;
        }

        return false;
    }

    public boolean isTherePizza() {
        return newOrder.isTherePizza();
    }

    public void newCustomPizza(String name) {
        customPizza = null;
        customPizza = new Pizza(name);
    }

    public void saveCustomPizza() {
        manager.addCustomPizza(customPizza);
    }

    public void addTopping(int i) {
        customPizza.addTopping(manager.getToppingList()[i]);
    }

    public void removeToppingAt(int i) {
        customPizza.removeToppingAt(i);
    }

    public String[] getAddedTopping() {
        return customPizza.getToppings();
    }

    public double getCustomPrice() {
        return customPizza.getPrice();
    }

    public String getTotal() {
        return String.format("%.2f kr", newOrder.getTotal());
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

    public long getSelectedOrderID() {
        return manager.getSelectedOrder().getID();
    }

    public void setOver18(boolean tof) {
        manager.setIsOver18(tof);
        // if (type == EntityType.Drink)
        //     view.updateBeverageList(getBeverageList());
    }
}