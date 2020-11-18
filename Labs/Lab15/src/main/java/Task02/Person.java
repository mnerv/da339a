package Task02;

public class Person {
    String name;
    PhoneNumber phoneNumber;

    public Person(String name, String number, PhoneType phoneType) {
        this(name, new PhoneNumber(number, phoneType));
    }

    public Person(String name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s have the number %s", name, phoneNumber);
    }

}
