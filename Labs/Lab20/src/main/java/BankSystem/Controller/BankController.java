package BankSystem.Controller;

import BankSystem.Model.Customer;
import BankSystem.Model.CustomerManager;
import BankSystem.View.MainView;

/**
 * Bank Controller.
 */
public class BankController {

  private MainView view;

  // @formatter:off
  
  // Main menu options
  private String[] customerOptions = {
    "List customers",
    "New customer",
    "Edit customer",
    "Exit"
  };

  // Customer view option, this is used when
  // where in an edit state for customer
  private String[] accountOptions = { 
    "Add new account",
    "List accounts",
    "Go back"
  };

  // Account type options, this can only be 
  // accessed when there is customer selected
  // It's used for when creating an account
  private String[] accountTypes = {
    "Corporate",
    "Credit",
    "Pension",
    "Salary",
    "Saving",
    "Cancel"
  };

  enum State {
    MainMenu, CreateCustomer, AccountView
  }

  // @formatter:on

  // State management
  private State currentState = State.MainMenu;
  private boolean isRunning = true;

  // TODO: Put current customer in the manager
  private CustomerManager customerManager;

  public BankController() {
    view = new MainView(this);
    customerManager = new CustomerManager(10);

    while (isRunning) {
      switch (currentState) {
        case MainMenu:
          mainMenu();
          break;
        case CreateCustomer:
          createCustomer();
          break;
        case AccountView:
          accountView();
          break;
        default:
          break;
      }
    }
  }

  // TODO: Main menu handler
  public void mainMenu() {
    int choice = view.showMenu("Main Menu", customerOptions);

    switch (choice) {
      case 0:
        view.showList(customerManager.getCustomerList());
        break;
      case 1:
        // Switch to create customer
        currentState = State.CreateCustomer;
        break;
      case 2:
        // TODO: Show all customer
        view.display("Edit Custmer\n");
        break;
      default:
        view.display("Invalid menu option\n");
        break;
    }
  }

  // TODO: Create customer view
  public void createCustomer() {
    view.createCustomerView();

    Customer customer = new Customer();
    customer.setFirstName(view.getFistname());
    customer.setLastName(view.getLastname());
    customer.setPersonNr(view.getIDNumber());
    customerManager.addCustomer(customer);

    currentState = State.AccountView;
  }

  // TODO: Account view handler
  public void accountView() {
    String tmp[] = new String[] { "Hello", "World" };
    int choice = view.showMenu("Account View", tmp);

    currentState = State.MainMenu;
  }

}