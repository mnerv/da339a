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

  /**
   * Set country directly using enum.
   * 
   * @param country Country from enum Countries
   */
  public void setCountry(Countries country) {
    this.country = country;
  }

  /**
   * Using string to search for a country in a list. O(n) time complexity for
   * getting country from enum
   * 
   * @param country Country name
   */
  public void setCountry(String country) {
    // Search for country in the list
    // O(n) time complexity for getting country from enum
    for (int i = 0; i < Countries.values().length; i++) {
      if (country.equalsIgnoreCase(Countries.values()[i].toString())) {
        setCountry(Countries.values()[i]);
        break;
      }
    }
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