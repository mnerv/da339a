package PostOffice.Controller;

import PostOffice.Model.*;
import PostOffice.View.MainView;
import PostOffice.Model.Package;

/**
 * PostalController
 */
public class PostalController {

  PostalManager manager;
  MainView view;

  // @formatter:off
  String mainOptions[] = new String[] { 
      "Customer",
      "Mail",
      "Exit" 
  };

  String customerOptions[] = new String[] { 
      "List Customers",
      "Add Customer",
      "Go Back" 
  };

  String mailOptions[] = new String[] { 
      "List Mail Items",
      "Add Mail Item",
      "Go Back" 
  };
  // @formatter:on

  boolean isRunning = true;

  enum State {
    Main, Customer, Mail
  };

  State currentState = State.Main;

  public PostalController() {
    manager = new PostalManager(10);
    view = new MainView(this);

    while (isRunning) {
      switch (currentState) {
        case Main:
          mainMenu();
          break;
        case Customer:
          customerMenu();
          break;
        case Mail:
          mailMenu();
          break;
        default:
          break;
      }
    }

  }

  // TODO: Call the main view
  private void mainMenu() {
    int choice = view.menuView("Main Menu", mainOptions);

    switch (choice) {
      case 0: // Customer view
        currentState = State.Customer;
        break;
      case 1: // Mail view
        currentState = State.Mail;
        break;
      case 2: // Exit
        isRunning = false;
        break;
      default: // Invalid option
        break;
    }
  }

  // TODO: Customer Menu
  private void customerMenu() {
    int choice = view.menuView("Customer Menu", customerOptions);

    switch (choice) {
      case 0: // list customers
        break;
      case 1: // add customer
        break;
      case 2: // go back to main menu
        currentState = State.Main;
        break;
      default: // Invalid option
        break;
    }
  }

  // TODO: Mail Menu
  private void mailMenu() {
    int choice = view.menuView("Mail Menu", mailOptions);

    switch (choice) {
      case 0: // List Mail Items
        break;
      case 1: // Add Mail
        break;
      case 2: // Go back
        currentState = State.Main;
        break;
      default: // Invalid Option
        break;
    }
  }

  // TODO: Call the customer view
  private void createCustomer() {
    view.createCustomerView();
  }

  // TODO: Call the create mail view
  private void createMail() {
  }

  /**
   * Add a customer to the list.
   * 
   * @param firstname Firstname of the customer
   * @param lastname  Lastname of the customer
   * @param street    The street address
   * @param city      City name
   * @param zipcode   The Zip Code for the city
   * @param country   The country for the address
   * 
   * @return False if the list is full and true if successful.
   */
  public boolean addCustomer(String firstname, String lastname, String street, String city, String zipcode,
      String country) {
    Person person = new Person(firstname, lastname);
    Address address = new Address();
    address.setStreet(street);
    address.setCity(city);
    address.setZipCode(zipcode);
    address.setCountry(country);

    Customer customer = new Customer(person, address);

    return manager.addCustomer(customer);
  }

  public boolean addParcel() {
    return false;
  }

  public boolean addPackage() {
    return false;
  }

  public boolean addLetter() {
    return false;
  }

  public boolean addPostCard() {
    return false;
  }

  public String[] getCustomerList() {
    return manager.getCustomerList();
  }

}