package Task02;

public class Person {
    String name;
    PhoneNumber phoneNumber;

    public Person(String name, String number, PhoneType phoneType) {
        this.name = name;
        this.phoneNumber = new PhoneNumber(number, phoneType);
    }

}
