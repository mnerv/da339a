package BankSystem.Model;

/**
 * CustomerManger.
 * 
 * @discussion The customer manager manage the customer for creating.
 */
public class CustomerManager {
  private Customer[] customers;
  private int customerCount = 0;

  private int idCounter = 0; // ID counter for customer ID

  private int selectedCustomer = 0;

  public CustomerManager(int maxCustomer) {
    customers = new Customer[maxCustomer];
  }

  /**
   * Add new customer to the list
   * 
   * @param customer Created customer
   */
  public boolean addCustomer(Customer customer) {
    if (customerCount > customers.length - 1) {
      return false;
    }

    customer.setId(String.valueOf(idCounter));
    customers[customerCount] = customer;
    customerCount++;

    return true;
  }

  /**
   * Get customer in the list
   * 
   * @param i Customer index
   */
  public Customer getCustomerAt(int i) {
    if (i > -1 && i < customers.length) {
      return customers[i];
    }

    return null;
  }

  /**
   * Edit customer in the list.
   * 
   * @param i        Customer index
   * @param customer Customer to edit
   */
  public boolean editCustomerAt(int i, Customer customer) {
    if (i > -1 && i < customers.length) {
      customers[i] = customer;
      return true;
    }

    return false;
  }

  /**
   * Resort the list to move the nulls to the end of list
   */
  public void moveNulls() {
    int nullcustomerCount = customers.length - customerCount;

    for (int i = 0; i < customers.length - 1; i++) {
      if (customers[i] == null) {
        Customer tmp = customers[i];
        customers[i] = customers[i + 1];
        customers[i + 1] = tmp;
      }

      if (i == customers.length - 2 && nullcustomerCount > 0) {
        nullcustomerCount--;
        i = 0;
      }
    }
  }

  /**
   * Get all the customer list
   *
   * @return Customer list
   */
  public String[] getCustomerList() {
    String[] tmp = new String[customerCount];

    for (int i = 0; i < customers.length; i++) {
      if (customers[i] != null) {
        tmp[i] = customers[i].toString();
      }
    }
    return tmp;
  }

  /**
   * Get the selected customer
   * 
   * @return Selected Customer
   */
  public Customer getSelectedCustomer() {
    if (selectedCustomer > -1 && selectedCustomer < customerCount)
      return customers[selectedCustomer];

    return null;
  }

  /**
   * Set the currently selected customer
   * 
   * @param i Customer index
   * @return True if it's a valid customer, False for invalid/out of range
   */
  public boolean setSelectedCustomer(int i) {
    selectedCustomer = i;
    return i > -1 && i < customerCount;
  }

  /**
   * Save selected Customer
   * 
   * @param customer Customer that needs to be change
   * @return True if save is successful and False if it's not.
   */
  public boolean saveSelectedCustomer(Customer customer) {
    if (selectedCustomer > -1 && selectedCustomer < customerCount) {
      customers[selectedCustomer] = customer;
      return true;
    }

    return false;
  }

}