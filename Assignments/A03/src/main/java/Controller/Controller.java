package Controller;

import Model.OrderManager;
import View.Window;

public class Controller {
  Window view;
  int counter = 0;

  OrderManager orderMng;

  public Controller() {
    orderMng = new OrderManager();
  }

  public Controller(Window view) {
    this();

    this.view = view;
  }

  public String Hello() {
    return "World!";
  }
}
