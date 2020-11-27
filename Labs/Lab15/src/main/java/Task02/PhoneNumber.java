package Task02;

public class PhoneNumber {
    private String number;
    private PhoneType phoneType;

    public PhoneNumber(String number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", number, phoneType.toString());
    }

}
