package BankSystem.View;

import BankSystem.Controller.BankController;
import Utilities.InputManager;

public class MainView {

  BankController controller;
  boolean isRunning = true;

  public MainView(BankController controller) {
    this.controller = controller;

  }

  public int showMenu() {
    int choice = 0;

    InputManager.printf("Select option: ");
    choice = InputManager.ReadInt();

    return choice - 1;
  }

  public void showList(String[] list) {
    for (int i = 0; i < list.length; i++) {
      InputManager.printf("%d. %s\n", i + 1, list[i]);
    }
  }

  public void showMessage(String message) {
    System.out.println(message);
  }
}