package Task02;

public class PhoneNumber {
    String number;
    PhoneType phoneType;

    public PhoneNumber(String number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", number, phoneType.toString());
    }

}
