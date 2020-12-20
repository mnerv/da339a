package PostOffice.Model;

/**
 * Customer width Address
 */
public class Customer {
  private Person person;
  private Address address;

  public Customer(Person person, Address address) {
    this.person = person;
    this.address = address;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Address: %s", person.toString(), address.toString());
  }

}
