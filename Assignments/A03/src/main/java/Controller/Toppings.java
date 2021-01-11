/**
 * Author: Pratchaya Khansomboon
 *
 * Created: 2020-12-10
 */
package Controller;

import Model.Topping;

/**
 * Predefined toppings
 */
public interface Toppings {
    Topping TomatoSauce = new Topping("Tomato Sauce", 10.0);
    Topping Chorizo = new Topping("Chorizo", 20.0);
    Topping Salami = new Topping("Salami", 20.0);
    Topping Mozzarella = new Topping("Mozzarella", 20.0);
    Topping Chicken = new Topping("Chicken", 20.0);
    Topping Beef = new Topping("Beef", 40.0);
    Topping CheddarCheese = new Topping("Cheddar Cheese", 20.0);
    Topping Cheese = new Topping("Cheese", 15.0);
    Topping Ham = new Topping("Ham", 20.0);
    Topping Mushroom = new Topping("Mushroom", 50.0);
    Topping Bolognese = new Topping("Bolognese", 30.0);
    Topping Pork = new Topping("Pork", 30.0);
    Topping Shrimps = new Topping("Shrimps", 30.0);
    Topping BearnaiseSauce = new Topping("Béarnaise sauce", 20.0);
    Topping Peperoncino = new Topping("Peperoncino", 5.0);
}