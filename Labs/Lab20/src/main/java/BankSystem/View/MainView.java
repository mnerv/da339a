package BankSystem.View;

import BankSystem.Controller.BankController;
import Utilities.IOManager;

/**
 * MainView.
 */
public class MainView {

  BankController controller;
  boolean isRunning = true;

  boolean errorFlag = false;

  String firstname, lastname, idNumber;

  public MainView(BankController controller) {
    this.controller = controller;
  }

  /**
   * Generic Show Menu
   * 
   * @param title Menu title
   * @param list  List on the menu
   * 
   * @return The selected option in the list
   */
  public int showMenu(String title, String list[]) {
    int choice = Integer.MIN_VALUE;

    while (choice == Integer.MIN_VALUE) {
      // Clear(); // TODO: The clear needs work since there might be list we want to
      // display

      hLine();
      display("%s\n", title);
      hLine();

      showList(list);
      display("Input: ");
      choice = IOManager.ReadInt();

      // Handle error, this prevent the clearing from happening
      if (choice == Integer.MIN_VALUE)
        errorFlag = true;
    }

    return choice - 1;
  }

  /**
   * Customer view handler
   */
  public void createCustomerView() {
    display("Create a customer\n");

    display("Firstname: ");
    firstname = IOManager.ReadLine();

    display("Lastname: ");
    lastname = IOManager.ReadLine();

    display("National ID Number: ");
    idNumber = IOManager.ReadLine();
  }

  public String getFistname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getIDNumber() {
    return idNumber;
  }

  public String readLine() {
    return IOManager.ReadLine();
  }

  public int readNumber() {
    int value = Integer.MIN_VALUE;

    while (value == Integer.MIN_VALUE) {
      value = IOManager.ReadInt();
    }

    return value;
  }

  public void display(String format, Object... args) {
    IOManager.printf(format, args);
  }

  public void showList(String[] list) {
    for (int i = 0; i < list.length; i++) {
      IOManager.printf("%d. %s\n", i + 1, list[i]);
    }
  }

  public void hLine() {
    IOManager.HLine();
  }

  // TODO: Clear screen needs to be work on.
  // It might be better to have a buffer and then just one display command.
  public void Clear() {
    if (!errorFlag) {
      IOManager.Clear();
    }
    errorFlag = false;
  }
}