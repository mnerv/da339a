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

    public String getFirstname() {
        return firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("%-27s %s", lastname + ", " + firstname, address.toString());
    }

}
