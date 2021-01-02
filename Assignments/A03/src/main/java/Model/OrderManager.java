package Model;

import Model.Topping.Topping;
import Model.Topping.Toppings;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    List<Pizza> pizzaList;
    List<Drinks> drinksList;

    final int TOPPINGS_COUNT = 14;
    Topping toppingList[];

    List<Order> orders;
    long orderID = 0;
    int selectedOrder = 0;

    public OrderManager() {
        toppingList = new Topping[TOPPINGS_COUNT];
        orders = new ArrayList<Order>();
        pizzaList = new ArrayList<Pizza>();
        drinksList = new ArrayList<Drinks>();

        initPizzaList();
        initToppingList();
        initDrinksList();
    }

    /**
     * Initialize predefined pizzas list
     */
    private void initPizzaList() {
        Pizza pizza = new Pizza("Vesuvio");
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Cheese);
        pizza.addTopping(Toppings.Ham);
        pizzaList.add(pizza);

        pizza = new Pizza("Calzone Bologneze");
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Cheese);
        pizza.addTopping(Toppings.Ham);
        pizza.addTopping(Toppings.Bolognese);
        pizzaList.add(pizza);

        pizza = new Pizza("Capriccosa");
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Cheese);
        pizza.addTopping(Toppings.Ham);
        pizza.addTopping(Toppings.Mushroom);
        pizzaList.add(pizza);

        pizza = new Pizza("Margeritha");
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Cheese);
        pizzaList.add(pizza);

        pizza = new Pizza("Sven Special");
        pizza.addTopping(Toppings.TomatoSauce);
        pizza.addTopping(Toppings.Cheese);
        pizza.addTopping(Toppings.Pork);
        pizza.addTopping(Toppings.Shrimps);
        pizza.addTopping(Toppings.BearnaiseSauce);
        pizza.addTopping(Toppings.Ham);
        pizzaList.add(pizza);
    }

    /**
     * Initialize predefined toppings
     */
    private void initToppingList() {
        toppingList[0] = Toppings.TomatoSauce;
        toppingList[1] = Toppings.Chorizo;
        toppingList[2] = Toppings.Salami;
        toppingList[3] = Toppings.Mozzarella;
        toppingList[4] = Toppings.Chicken;
        toppingList[5] = Toppings.Beef;
        toppingList[6] = Toppings.CheddarCheese;
        toppingList[7] = Toppings.Cheese;
        toppingList[8] = Toppings.Ham;
        toppingList[9] = Toppings.Mushroom;
        toppingList[10] = Toppings.Bolognese;
        toppingList[11] = Toppings.Pork;
        toppingList[12] = Toppings.Shrimps;
        toppingList[13] = Toppings.BearnaiseSauce;
    }

    // TODO: Create Drinks List
    private void initDrinksList() {}

    public boolean setSelectedOrder(int id) {
        if (id > 0 && id < orders.size()) {
            selectedOrder = id;
            return true;
        }

        return false;
    }

    /**
     * @param order
     */
    public void addOrder(Order order) {
        order.id = orderID;
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
        if (i > 0 && i < drinksList.size()) {
            selectedOrder = i;
            return true;
        }

        return false;
    }

    public Order getSelectedOrder() {
        if (selectedOrder > -1)
            return orders.get(selectedOrder);

        return null;
    }

    public void updateSelectedOrder(Order order) {
        if (selectedOrder > -1)
            orders.set(selectedOrder, order);
    }

    public String[] getOrderList() {
        String tmpList[] = new String[orders.size()];
        for (int i = 0; i < tmpList.length; i++) tmpList[i] = orders.get(i).toString();

        return tmpList;
    }

    public String[] getPizzaList() {
        String tmpList[] = new String[pizzaList.size()];

        for (int i = 0; i < tmpList.length; i++) {
            tmpList[i] = pizzaList.get(i).getInfo();
        }

        return tmpList;
    }

    public String[] getToppingList() {
        String tmpList[] = new String[TOPPINGS_COUNT];

        for (int i = 0; i < tmpList.length; i++) tmpList[i] = toppingList[i].getInfo();

        return tmpList;
    }

    public String[] getDrinkList() {
        String tmpList[] = new String[drinksList.size()];

        for (int i = 0; i < tmpList.length; i++) {
            tmpList[i] = drinksList.get(i).getInfo();
        }

        return tmpList;
    }
}