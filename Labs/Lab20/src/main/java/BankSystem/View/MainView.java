package BankSystem.View;

import BankSystem.Controller.BankController;
import Utilities.IOManager;

public class MainView {

  BankController controller;
  boolean isRunning = true;

  public MainView(BankController controller) {
    this.controller = controller;

  }

  public int showMenu() {
    int choice = 0;

    IOManager.printf("Select option: ");
    choice = IOManager.ReadInt();

    return choice - 1;
  }

  public void display(String text) {
    IOManager.printf("%s\n", text);
  }

  public void hLine() {
    IOManager.printf("-----------------------------------------\n");
  }

  public int getOption(String text) {
    int option = 0;
    IOManager.printf("%s: ", text);
    option = IOManager.ReadInt();

    return option - 1;
  }

  public void showList(String[] list) {
    for (int i = 0; i < list.length; i++) {
      IOManager.printf("%d. %s\n", i + 1, list[i]);
    }
  }

  public void showMessage(String message) {
    System.out.println(message);
  }
}