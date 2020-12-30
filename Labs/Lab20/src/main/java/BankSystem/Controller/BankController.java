package BankSystem.Controller;

import BankSystem.Model.Customer;
import BankSystem.Model.CustomerManager;
import BankSystem.Model.Accounts.SalaryAccount;
import BankSystem.Model.Accounts.SavingAccount;
import BankSystem.View.MainView;

/**
 * Bank Controller.
 */
public class BankController {

  private MainView view;

  // @formatter:off
  
  // Main menu options
  private final String[] mainMenuOptions = {
    "List customers",
    "New customer",
    "Edit customer",
    "Exit"
  };

  // Customer view option, this is used when
  // where in an edit state for customer
  private final String[] customerOptions = { 
    "Add new account",
    "List accounts",
    "Go back to Main Menu"
  };

  // Account type options, this can only be  
  // accessed when there is customer selected
  // It's used for when creating an account
  private final String[] accountTypes = {
    // "Corporate",
    // "Credit",
    // "Pension",
    "Salary",
    "Saving",
    "Cancel"
  };

  enum State {
    MainMenu, CreateCustomer, CustomerView,AccountView
  }

  // @formatter:on

  // State management
  private State currentState = State.MainMenu;
  private boolean isRunning = true;

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
        case CustomerView:
          customerView();
          break;
        case AccountView:
          accountView();
          break;
        default:
          break;
      }
    }
  }

  public void mainMenu() {
    int choice = view.showMenu("Main Menu", mainMenuOptions);

    switch (choice) {
      case 0: // List customers
        String list[] = customerManager.getCustomerList();
        if (list.length > 0)
          view.showList(list);
        else
          view.display("There are no customers :(\n");
        break;
      case 1: // Switch to create customer
        currentState = State.CreateCustomer;
        break;
      case 2: // Switch to edit customer state
        editCustomer();
        break;
      default:
        view.display("Invalid menu option\n");
        break;
    }
  }

  /**
   * Create customer and add it to the list
   */
  public void createCustomer() {
    view.createCustomerView();

    Customer customer = new Customer();
    customer.setFirstName(view.getFistname());
    customer.setLastName(view.getLastname());
    customer.setPersonNr(view.getIDNumber());

    customerManager.addCustomer(customer);

    currentState = State.MainMenu;
  }

  public void editCustomer() {
    int select = view.showMenu("Select Customer", customerManager.getCustomerList());
    boolean isValid = customerManager.setSelectedCustomer(select);
    if (isValid) {
      currentState = State.CustomerView;
    }
  }

  public void customerView() {
    Customer selected = customerManager.getSelectedCustomer();
    String menuTitle = String.format("Customer View\n%s", selected.toString());
    int choice = view.showMenu(menuTitle, customerOptions);

    switch (choice) {
      case 0:
        addNewAccount();
        break;
      case 1:
        view.showList(selected.getAccountList());
        break;
      case 2:
        currentState = State.MainMenu;
        break;
      default:
        view.display("Invalid option\n");
        break;
    }
  }

  public void addNewAccount() {
    int choice = view.showMenu("Select Account Type", accountTypes);

    boolean isValid = false;
    Customer customer = customerManager.getSelectedCustomer();

    switch (choice) {
      case 0: // Salary
        SalaryAccount ac = new SalaryAccount();
        view.display("Employer name: ");
        String eName = view.readLine();

        ac.setEmployerName(eName);
        isValid = !eName.isBlank();
        customer.setSalaryAccount(ac);
        break;
      case 1: // Saving
        SavingAccount sa = new SavingAccount();
        view.display("Saving interests: ");
        int interests = view.readNumber();
        sa.setInterests(interests);

        break;
      case 2: // Cancel
        break;
      default:
        view.display("Invalid option\n");
        break;
    }

    if (isValid) {
      customerManager.saveSelectedCustomer(customer);
    }
  }

  // TODO: Account view handler
  public void accountView() {
    String tmp[] = new String[] { "Hello", "World" };
    int choice = view.showMenu("Account View", tmp);

    currentState = State.MainMenu;
  }

}