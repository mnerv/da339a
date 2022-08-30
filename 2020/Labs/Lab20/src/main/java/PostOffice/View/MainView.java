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
        // @formatter:off
        String titleFormat = "\n"
            + "––––––––––––––––––––––––––––––––––––––––\n"
            + "          %s\n"
            + "––––––––––––––––––––––––––––––––––––––––\n";
        // @formatter:on

        while (!exitFlag) {
            IOManager.printf(titleFormat, title);
            showList(list);

            IOManager.printf("Input: ");
            input = IOManager.ReadInt() - 1;

            exitFlag = input > -1 && input < list.length && input != Integer.MIN_VALUE;
        }

        return input;
    }

    public void createCustomerView() {
        // @formatter:off
        String title = "––––––––––––––––––––––––––––––––––––––––\n"
            + "             Add a customer             \n"
            + "––––––––––––––––––––––––––––––––––––––––\n";
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

            exitFlag = !firstname.isBlank() && !lastname.isBlank() && !street.isBlank()
                && !city.isBlank() && !zipcode.isBlank() && !country.isBlank();

            if (exitFlag)
                controller.addCustomer(firstname, lastname, street, city, zipcode, country);
        }
    }

    public void createMailItemView() {
        // @formatter:off
        String title = "––––––––––––––––––––––––––––––––––\n"
            + "          Add a mail item         \n"
            + "––––––––––––––––––––––––––––––––––\n";
        // @formatter:on
        IOManager.printf("%s", title);
        boolean exitFlag = false;

        while (exitFlag) {
        }
    }

    public void showList(String[] list) {
        for (int i = 0; i < list.length; i++) {
            IOManager.printf("%d. %s\n", i + 1, list[i]);
        }
    }

    public void display(String format, Object... args) {
        IOManager.printf(format, args);
    }

    public String readLine() {
        return IOManager.ReadLine();
    }

    public int readInt() {
        int value = Integer.MIN_VALUE;

        while (value == Integer.MIN_VALUE) {
            value = IOManager.ReadInt();
        }

        return value;
    }

    public double readDouble() {
        double value = Double.MIN_VALUE;

        while (value == Double.MIN_VALUE) {
            value = IOManager.ReadDouble();
        }

        return value;
    }
}