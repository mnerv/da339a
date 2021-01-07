package PostOffice.Model;

/**
 * Person
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person() {}

    public Person(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
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

    public String getFullName() {
        return String.format("%s, %s", lastName.toUpperCase(), firstName);
    }

    @Override
    public String toString() {
        return String.format("%s", getFullName());
    }
}