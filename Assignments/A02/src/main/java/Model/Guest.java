package Model;

/**
 * Author: Pratchaya Khansomboon
 */
public class Guest {
    String firstname;
    String lastname;

    Address address;

    public Guest() {
        this(null, null, null);
    }

    public Guest(String firstname, String lastname, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s, %s\t    %s", lastname, firstname, address.toString());
    }

}
