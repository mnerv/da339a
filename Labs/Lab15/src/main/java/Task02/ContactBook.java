package Task02;

public class ContactBook {
    private Person[] persons;

    private int count;

    public ContactBook(int max) {
        persons = new Person[max];
    }

    public boolean addNew(Person person) {
        if (count >= persons.length - 1)
            return false;

        persons[count] = person;
        count++;

        return true;
    }

    public String[] getContacts() {
        String[] tmp = new String[count];

        int counter = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null) {
                tmp[counter] = persons[i].toString();
                counter++;
            }
        }

        return tmp;
    }

    public void AddTestValues() {
        addNew(new Person("Hello there", "123456", PhoneType.home));
        addNew(new Person("Hello World", "3429875", PhoneType.work));
        addNew(new Person("Hello dkhjs", "36724", PhoneType.home));
        addNew(new Person("Hello 3w2i", "23784", PhoneType.work));
    }

}
