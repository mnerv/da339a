package BankSystem.View;

import BankSystem.Controller.BankController;

public class MainView {

  BankController controller;
  boolean isRunning = true;

  public MainView() {
    controller = new BankController();

    while (isRunning) {

    }
  }

}
