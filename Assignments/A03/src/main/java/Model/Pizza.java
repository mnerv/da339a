package Model;

import java.util.Arrays;

import Model.Topping.*;

public class Pizza extends Entity {
  final int BASE_MAX_TOPPINGS = 5;
  final int BASE_PRICE = 30;

  private int maxToppings = BASE_MAX_TOPPINGS;
  private int topCount = 0;
  Topping[] toppings = new Topping[BASE_MAX_TOPPINGS];

  public Pizza() {
    super();
  }

  public Pizza(String name) {
    this.name = name;
    price = BASE_PRICE;
  }

  public Pizza(String name, int maxToppings) {
    this(name);

    this.maxToppings = maxToppings;
    toppings = new Topping[maxToppings];
  }

  public boolean addTopping(Topping topping) {
    if (topCount > maxToppings - 1)
      return false;

    toppings[topCount] = topping;
    topCount++;
    return true;
  }

  public boolean removeToppingAt(int index) {
    if (index > -1 && index < maxToppings - 1 && toppings[index] != null) {
      toppings[index] = null;
      topCount--;

      int nullCount = toppings.length - topCount;
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

  public String[] getToppings() {
    String[] tmp = new String[topCount];

    for (int i = 0; i < topCount; i++)
      tmp[i] = toppings[i].getName();

    return tmp;
  }

  @Override
  public String toString() {
    return String.format("Pizza: %s, Toppins: %s", name, Arrays.toString(toppings));
  }
}
