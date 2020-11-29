package Controller;

import View.Window;

public class Controller {
  Window view;
  int counter = 0;

  public Controller() {
  }

  public Controller(Window view) {
    this.view = view;
  }

  public String Hello() {
    return "World!";
  }
}
