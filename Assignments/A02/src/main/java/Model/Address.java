package Model;

/**
 * Author: Pratchaya Khansomboon
 */
public class Address {
    String street;
    String city;
    String zipcode;
    Countries country;

    public Address() {
    }

    public Address(String street, String city, String zipcode, Countries country) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setZipCode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Countries getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", street, city, zipcode, country.toString().replaceAll("_", " "));
    }

}
