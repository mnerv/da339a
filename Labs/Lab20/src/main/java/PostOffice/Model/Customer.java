package PostOffice.Model;

/**
 * Customer width Address
 */
public class Customer {
  private String id;
  private Person person;
  private Address address;

  public Customer(Person person, Address address) {
    this.person = person;
    this.address = address;
  }

  public String getID() {
    return id;
  }

  public void setID(String id) {
    this.id = id;
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
    return String.format("ID: %s, Name: %d", id, person);
  }

}
