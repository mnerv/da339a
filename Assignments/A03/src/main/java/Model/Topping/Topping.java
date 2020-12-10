package Model.Topping;

public class Topping {
  String name;
  int price;

  public Topping(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return String.format("%s", name);
  }
}
