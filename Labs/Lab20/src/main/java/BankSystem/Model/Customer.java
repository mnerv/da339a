package BankSystem.Model;

/**
 * Customer
 * 
 * @discussion The Customer class manage their own accounts. Only one type of
 *             account is allowed(this might not be true).
 */
public class Customer extends Person {
    private String id;

    // TODO: Add account property here
    // TODO: Bank account

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
