package Model;

import Model.Topping.Topping;
import Model.Topping.Toppings;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    List<Pizza> pizzaList;
    List<Beverage> beverageList;

    final int TOPPINGS_COUNT = 14;
    Topping toppingList[];

    List<Order> orders;
    long orderID = 0;
    int selectedOrder = -1;

    boolean isOver18 = false;

    public OrderManager() {
        toppingList = new Topping[TOPPINGS_COUNT];
        orders = new ArrayList<Order>();
        pizzaList = new ArrayList<Pizza>();
        beverageList = new ArrayList<Beverage>();

        initPizzaList();
        initToppingList();
        initDrinksList();
    }

    /**
     * Initialize predefined pizza list
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

    // Drink list both alcoholic and non alcoholic
    private void initDrinksList() {
        Beverage beverage;

        beverage = new Beverage("Carlsberg", 55.95, 3.5);
        beverageList.add(beverage);

        beverage = new Beverage("Vodka", 95.95, 40.0);
        beverageList.add(beverage);

        beverage = new Beverage("Cider", 75.95, 4.5);
        beverageList.add(beverage);

        beverage = new Beverage("Pilsner", 15.0, 2.25);
        beverageList.add(beverage);

        beverage = new Beverage("Red wine", 150.55, 6.5);
        beverageList.add(beverage);

        beverage = new Beverage("Water", 0.0);
        beverageList.add(beverage);

        beverage = new Beverage("Trocadero", 7.5);
        beverageList.add(beverage);

        beverage = new Beverage("Fanta", 8.0);
        beverageList.add(beverage);

        beverage = new Beverage("Coca cola", 8.5);
        beverageList.add(beverage);

        beverage = new Beverage("Non-alcoholic cider", 35.0);
        beverageList.add(beverage);
    }

    /**
     * Add order to the order list
     *
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
        if (i > -1 && i < orders.size()) {
            selectedOrder = i;
            return true;
        }

        return false;
    }

    /**
     * Get selected order. If there's no selection i.e the selection index is at -1 then null is
     * returned.
     */
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

    public void addCustomPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public Topping[] getToppingList() {
        return toppingList;
    }

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

    public boolean getIsOver18() {
        return isOver18;
    }

    public void setIsOver18(boolean tof) {
        isOver18 = tof;
    }
}