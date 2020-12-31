package PostOffice.View;

import PostOffice.Controller.PostalController;
import Utilities.IOManager;

public class MainView {
  PostalController controller;

  String firstname, lastname;

  public MainView(PostalController c) {
    controller = c;
  }

  public int menuView(String title, String list[]) {
    boolean exitFlag = false;
    int input = Integer.MIN_VALUE;

    while (!exitFlag) {
      IOManager.printf("\n––––––––––––––––––––––––––––––––––\n%s\n––––––––––––––––––––––––––––––––––\n", title);
      for (int i = 0; i < list.length; i++)
        IOManager.printf("%s. %s\n", i + 1, list[i]);

      IOManager.printf("Input: ");
      input = IOManager.ReadInt() - 1;

      exitFlag = input > -1 && input < list.length && input != Integer.MIN_VALUE;
    }

    return input;
  }

  public void createCustomerView() {
    // @formatter:off
    String title = 
      "––––––––––––––––––––––––––––––––––\n" +
      "          Add a customer          \n" +
      "––––––––––––––––––––––––––––––––––\n";
    // @formatter:on
    IOManager.printf("%s", title);
    boolean exitFlag = false;

    String firstname, lastname, street, city, zipcode, country;

    while (!exitFlag) {
      IOManager.printf("Firstname: ");
      firstname = IOManager.ReadLine();

      IOManager.printf("Lastname:  ");
      lastname = IOManager.ReadLine();

      IOManager.printf("Street:    ");
      street = IOManager.ReadLine();

      IOManager.printf("City:      ");
      city = IOManager.ReadLine();

      IOManager.printf("Zip Code:  ");
      zipcode = IOManager.ReadLine();

      IOManager.printf("Country:   ");
      country = IOManager.ReadLine();

      exitFlag = !firstname.isBlank() && !lastname.isBlank() && !street.isBlank() && !city.isBlank()
          && !zipcode.isBlank() && !country.isBlank();

      if (!exitFlag)
        controller.addCustomer(firstname, lastname, street, city, zipcode, country);
    }

  }

  public void createMailItemView() {
    // @formatter:off
    String title = 
      "––––––––––––––––––––––––––––––––––\n" +
      "          Add a mail item         \n" +
      "––––––––––––––––––––––––––––––––––\n";
    // @formatter:on
    IOManager.printf("%s", title);
    boolean exitFlag = false;

    while (exitFlag) {

    }
  }

}