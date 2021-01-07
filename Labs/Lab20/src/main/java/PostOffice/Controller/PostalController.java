package PostOffice.Controller;

import PostOffice.Model.*;
import PostOffice.Model.Package;
import PostOffice.View.MainView;

/**
 * PostalController
 */
public class PostalController {
    PostalManager manager;
    MainView view;

    // @formatter:off
    String mainOptions[] = new String[] {"Customer", "Mail", "Exit"};

    String customerOptions[] = new String[] {"List Customers", "Add Customer", "Go Back"};

    String mailOptions[] = new String[] {"List Mail Items", "Add Mail Item", "Go Back"};
    // @formatter:on

    boolean isRunning = true;

    enum State { Main, Customer, Mail }
    ;

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
            case 0: // List exisiting customers
                view.showList(manager.getCustomerList());
                break;
            case 1: // Add customer
                view.createCustomerView();
                break;
            case 2: // Go back to main menu
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
                view.showList(manager.getMailItemList());
                break;
            case 1: // Add Mail
                createMailItem();
                break;
            case 2: // Go back
                currentState = State.Main;
                break;
            default: // Invalid Option
                break;
        }
    }

    private void createMailItem() {
        int choice = view.menuView("Create Mail Item", getMailItemTypeList());

        switch (choice) {
            case 0: // Letter
                createLetter();
                break;
            case 1: // Postcard
                createPostCard();
                break;
            case 2: // Parcel
                createParcel();
                break;
            case 3: // Package
                createPackage();
                break;
            default:
                break;
        }
    }

    private void createLetter() {
        boolean exitFlag = false;

        while (!exitFlag) {
            view.showList(manager.getCustomerList());
            view.display("Receiver: ");

            Letter letter = new Letter();
            int receiver = view.readInt();
            letter.setReceiver(manager.getCustomerAt(receiver));

            view.display("Sender: ");
            int sender = view.readInt();
            letter.setSender(manager.getCustomerAt(sender));

            view.display("Weight: ");
            double weight = view.readDouble();
            letter.setWeight(weight);

            view.display("Cost: ");
            double cost = view.readDouble();
            letter.setCost(cost);

            exitFlag = receiver != Integer.MIN_VALUE && sender != Integer.MIN_VALUE
                && weight != Double.MIN_VALUE && cost > 0;

            if (exitFlag)
                manager.addMailitem(letter);
        }
    }

    private void createPostCard() {
        boolean exitFlag = false;

        while (!exitFlag) {
            view.showList(manager.getCustomerList());
            view.display("Receiver: ");

            Postcard postcard = new Postcard();
            int receiver = view.readInt();
            postcard.setReceiver(manager.getCustomerAt(receiver));

            view.display("Sender: ");
            int sender = view.readInt();
            postcard.setSender(manager.getCustomerAt(sender));

            view.display("Cost: ");
            double cost = view.readDouble();
            postcard.setCost(cost);

            exitFlag = receiver != Integer.MIN_VALUE && sender != Integer.MIN_VALUE && cost > 0;

            if (exitFlag)
                manager.addMailitem(postcard);
        }
    }

    private void createParcel() {
        boolean exitFlag = false;

        while (!exitFlag) {
            view.showList(manager.getCustomerList());
            view.display("Receiver: ");

            Parcel parcel = new Parcel();
            int receiver = view.readInt();
            parcel.setReceiver(manager.getCustomerAt(receiver));

            view.display("Sender: ");
            int sender = view.readInt();
            parcel.setSender(manager.getCustomerAt(sender));

            view.display("Weight: ");
            double weight = view.readDouble();
            parcel.setWeight(weight);

            view.display("Size: ");
            Size size = new Size();
            view.display("Length: ");
            double length = view.readDouble();
            view.display("Height: ");
            double height = view.readDouble();
            view.display("Width: ");
            double width = view.readDouble();
            size.setLength(length);
            size.setHeight(height);
            size.setWidth(width);
            parcel.setSize(size);

            view.display("Cost: ");
            double cost = view.readDouble();
            parcel.setCost(cost);

            exitFlag = receiver != Integer.MIN_VALUE && sender != Integer.MIN_VALUE && cost > 0;

            if (exitFlag)
                manager.addMailitem(parcel);
        }
    }

    private void createPackage() {
        boolean exitFlag = false;

        while (!exitFlag) {
            view.showList(manager.getCustomerList());
            view.display("Receiver: ");

            Package _package = new Package();
            int receiver = view.readInt();
            _package.setReceiver(manager.getCustomerAt(receiver));

            view.display("Sender: ");
            int sender = view.readInt();
            _package.setSender(manager.getCustomerAt(sender));

            view.display("Weight: ");
            double weight = view.readDouble();
            _package.setWeight(weight);

            view.display("Size: ");
            Size size = new Size();
            view.display("Length: ");
            double length = view.readDouble();
            view.display("Height: ");
            double height = view.readDouble();
            view.display("Width: ");
            double width = view.readDouble();
            size.setLength(length);
            size.setHeight(height);
            size.setWidth(width);
            _package.setSize(size);

            view.display("Cost: ");
            double cost = view.readDouble();
            _package.setCost(cost);

            exitFlag = receiver != Integer.MIN_VALUE && sender != Integer.MIN_VALUE && cost > 0;

            if (exitFlag)
                manager.addMailitem(_package);
        }
    }

    /**
     * Add a customer to the list.
     *
     * @param firstname First name of the customer
     * @param lastname  Last name of the customer
     * @param street    The street address
     * @param city      City name
     * @param zipcode   The Zip Code for the city
     * @param country   The country for the address
     *
     * @return False if the list is full and true if successful.
     */
    public boolean addCustomer(String firstname, String lastname, String street, String city,
        String zipcode, String country) {
        Person person = new Person(firstname, lastname);
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setZipCode(zipcode);
        address.setCountry(country);

        Customer customer = new Customer(person, address);

        return manager.addCustomer(customer);
    }

    public void addMailItem(int type, int sender, int receiver, double weight, double cost) {}

    public void addMailItem(int type, int sender, int receiver, double weight, double cost,
        double length, double width, double height) {}

    public String[] getCustomerList() {
        return manager.getCustomerList();
    }

    public String[] getMailItemList() {
        return manager.getMailItemList();
    }

    public String[] getMailItemTypeList() {
        String[] tmpTypes = new String[PostalType.values().length];

        for (int i = 0; i < PostalType.values().length; i++) {
            tmpTypes[i] = PostalType.values()[i].toString();
        }

        return tmpTypes;
    }
}