package App;

import Task01.*;
import Task02.*;
import Task03.Controller.Controller;

public class App {

    public static void main(String[] args) {
        Task03();
    }

    public static void Task1A() {
        Login login = new Login("me@kthexiii.com", "12345");
        System.out.println(login);
    }

    public static void Task1B() {
        int max = 5;
        LoginHandler loginList = new LoginHandler(max);

        TestADD1B(loginList, new Login("id", "password"));
        TestADD1B(loginList, new Login("id1", "password1"));
        TestADD1B(loginList, new Login("id2", "password2"));

        loginList.printList();

        TestDelete1B(loginList, 0);
        TestDelete1B(loginList, 10);

        loginList.printList();

    }

    public static void TestADD1B(LoginHandler lh, Login login) {
        boolean ok = lh.addNew(login);
        if (ok)
            System.out.printf("Success: %d\n", lh.getCount());
        else
            System.out.println("Error adding");
    }

    public static void TestDelete1B(LoginHandler lh, int index) {
        boolean ok = lh.deleteAt(index);
        if (ok)
            System.out.printf("Delete success: %d\n", lh.getCount());
        else
            System.out.println("Error deleting");
    }

    public static void Task2A() {
        PhoneNumber phone = new PhoneNumber("123585 ", PhoneType.work);
        System.out.println(phone);

        Person person = new Person("Bruh", phone);
        System.out.println(person);
    }

    public static void Task2B() {
        ContactBook contacts = new ContactBook(5);
        contacts.AddTestValues();

        String[] test = contacts.getContacts();

        if (test.length > 0)
            for (String str : test) {
                System.out.println(str);
            }
    }

    public static void Task03() {
        Controller c = new Controller();
    }

}
