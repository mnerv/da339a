package Controller;

import Model.OrderManager;
import View.MainView;

/**
 * Controller
 */
public class Controller {
    OrderManager manager;
    MainView view;

    public Controller(MainView view) {
        manager = new OrderManager();
        this.view = view;
    }

    /**
     * Getters for the different lists
     */
    public String[] getOrderList() {
        return manager.getOrderList();
    }

    public String[] getPizzaList() {
        return manager.getPizzaList();
    }

    public String[] getToppingList() {
        return manager.getToppingList();
    }

    public String[] getDrinkList() {
        return manager.getDrinkList();
    }
}