package PostOffice.Model;

/**
 * Address for Customer
 */
public class Address {
  private String street;
  private String city;
  private String zipCode;
  private Countries country;

  public Address() {
  }

  public Address(String street, String city, String zipCode, Countries country) {
    this.street = street;
    this.city = city;
    this.zipCode = zipCode;
    this.country = country;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public Countries getCountry() {
    return country;
  }

  public void setCountry(Countries country) {
    this.country = country;
  }

  /**
   * Formats the countries to remove underlines and such to add a space back as
   * enums doesn't support it
   * 
   * @return Country name
   */
  public String getCountryString() {
    return country.toString().replace('_', ' ');
  }

  @Override
  public String toString() {
    return String.format("%s, %s %s, %s", this.street, this.zipCode, this.city, this.getCountryString());
  }

}