package PostOffice.Model;

/**
 * PostalManager manage the customer and mailitems. The customer is used for
 * binding to mailtime.
 */
public class PostalManager {
    Customer customers[];
    int customerCount = 0;

    MailItem mailItems[];
    int mailCount = 0;

    private int selectedCustomer = 0; // TODO: Might need to select a customer
    private int selectedMail = 0; // TODO: Might need to select a mail

    /**
     * Create manager for Postal service
     *
     * @param max The maximum mails and customers
     */
    public PostalManager(int max) {
        mailItems = new MailItem[max];
        customers = new Customer[max];
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
     * Get all Mail Items
     *
     * @return MailItem list
     */
    public String[] getMailItemList() {
        String[] tmp = new String[mailCount];

        for (int i = 0; i < mailItems.length; i++) {
            if (mailItems[i] != null) {
                tmp[i] = mailItems[i].toString();
            }
        }

        return tmp;
    }

    /**
     * Used when you want to add a mail item to the list
     *
     * @param mailItem the created mail item
     *
     * @return False if the list is full, True for successful.
     */
    public boolean addMailitem(MailItem mailItem) {
        if (mailCount < mailItems.length) {
            mailItems[mailCount] = mailItem;
            mailCount++;
            return true;
        }
        return false;
    }
}