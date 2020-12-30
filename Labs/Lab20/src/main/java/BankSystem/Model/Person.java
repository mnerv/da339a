package BankSystem.Model;

/**
 * Person
 */
public class Person {
  private String firstName;
  private String lastName;
  private String personNr;
  private Address address;

  public Person() {
    address = new Address();
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPersonNr() {
    return personNr;
  }

  public void setPersonNr(String personNr) {
    this.personNr = personNr;
  }

  public String getFullName() {
    String str = String.format("%s , %s", lastName.toUpperCase(), firstName);
    return str;
  }

  @Override
  public String toString() {
    return String.format("%s, personnr: %s", getFullName(), personNr);
  }
}