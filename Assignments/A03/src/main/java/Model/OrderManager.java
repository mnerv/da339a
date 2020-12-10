package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Topping.Toppings;

public class OrderManager {
  List<Order> orders;

  public OrderManager() {
    orders = new ArrayList<Order>();

    Pizza test = new Pizza("Chicken Cheddar");
    test.addTopping(Toppings.TomatoSauce);
    test.addTopping(Toppings.Chicken);
    test.addTopping(Toppings.CheddarCheese);

    System.out.println(test.toString());
    test.removeToppingAt(1);
    System.out.println(test.toString());

    System.out.println(Arrays.toString(test.getToppings()));

  }
}
