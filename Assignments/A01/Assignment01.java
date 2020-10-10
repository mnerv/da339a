
/**
 * Author: Pratchaya Khansomboon
 */

import java.util.Scanner;

import java.util.Locale;

public class Assignment01 {
    // @formatter:off
    private static String[] menuList = {
        "Show guest list",
        "Add guest",
        "Change guest's name",
        "Change guest's age",
        "Change guest's list position",
        "Removed guest",
        "Exit"
    };

    static String[][] guestList = { 
    //    name,           age
        { "Adam Ason",   "35" }, 
        { "Berta Bson",  "70" }, 
        { "Ceasar Cson", "12" }, 
        { "", "" },
        { "", "" },
        { "", "" },
        { "", "" },
        { "", "" },
        { "", "" },
        { "", "" },
    };
    // @formatter:on

    public static void printGuestList() {
        PushOutput("\u001b[37;1mGuest List\u001b[0m\n");
        HLine();
        for (int i = 0; i < guestList.length; i++) {
            String name = guestList[i][0];
            String age = guestList[i][1];
            PushOutput("%d. %s\t\t%s\n", i + 1, name, age);
        }
    }

    public static void printStatistics() {

    }

    public static void addGuest() {
        if (isFull()) {
            PushErrorMesssage("Guest list full\n");
            return;
        }

        Clear();

        printf("Enter guest firstname and lastname\nName: ");
        String name = input.nextLine();

        if (name.equals("")) {
            PushErrorMesssage("Name cannot be empty\n");
            return;
        }

        printf("Enter guest's age: ");
        int age = ReadInt();

        if (age == Integer.MIN_VALUE) {
            PushErrorMesssage("INPUT AGE IS NOT A NUMBER\n");
            return;
        }

        for (int i = 0; i < guestList.length; i++) {
            if (guestList[i][0].equals("")) {
                guestList[i][0] = name;
                guestList[i][1] = Integer.toString(age);

                PushOutput("Added:\n%s, %d\n", name, age);
                HLine();
                printGuestList();
                break;
            }
        }

    }

    public static void changeNamneOfGuest(int index, String newName) {

    }

    public static void changeAgeOfGuest(int index, String newAge) {
    }

    public static void removeGuest() {
        Clear();
        printGuestList();
        PrintOutput();
        ResetOutput();

        printf("Select the guest to be removed\n");
        printf("Select: ");
        int index = ReadInt();

        if (index > 0 && index < guestList.length) {

            PushOutput("Removed:\n%d. %s\t\t%s\n", index, guestList[index][0], guestList[index][1]);
            HLine();

            guestList[index - 1][0] = "";
            guestList[index - 1][1] = "";

            printGuestList();

        } else {
            PushErrorMesssage("Index out of range");
        }

    }

    public static boolean isFull() {
        boolean full = true;

        for (int i = 0; i < guestList.length; i++)
            if (guestList[i][0] == "") {
                full = false;
                break;
            }

        return full;
    }

    public static void changePlaces(int index1, int index2) {
    }

    public static void printMenu() {
        if (output.equals(""))
            printf("Menu\n");
        HLine();
        for (int i = 0; i < menuList.length; i++) {
            if (i < menuList.length - 1)
                printf("%d. %s\n", i + 1, menuList[i]);
            else
                printf("Enter -1 to exit\n\n");
        }
    }

    private static void HLine() {
        printf("-------------------------------\n");
        PushOutput("-------------------------------\n");
    }

    private static Scanner input = new Scanner(System.in);
    private static Locale printLocale = new Locale("en", "UK");
    private static String message = "";
    private static String output = "";

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            Clear();

            PrintOutput();
            printMenu();
            PrintMessage();

            ResetBuffer();

            printf("Select: ");
            int selector = ReadInt();

            switch (selector) {
                case 0:
                    break;
                case 1:
                    printGuestList();
                    break;
                case 2:
                    addGuest();
                    break;
                case 6:
                    removeGuest();
                    break;
                case -1:
                    isRunning = false;
                    break;
                default:
                    PushMessage("\u001b[36m%d: \u001b[33mNot a valid option\u001b[0m", selector);
                    break;
            }

        }

    }

    /*-------------------- HELPER METHODS ---------------------------*/
    private static void printf(String format, Object... args) {
        System.out.printf(printLocale, format, args);
    }

    private static void PrintOutput() {
        if (!output.equals("")) {
            printf("%s\n", output);
        }
    }

    private static void PushOutput(String format, Object... args) {
        output += String.format(printLocale, format, args);
    }

    private static void SetOutput(String format, Object... args) {
        output = String.format(printLocale, format, args);
    }

    private static void PushMessage(String format, Object... args) {
        if (!message.equals(""))
            message += "\n";

        message += String.format(printLocale, format, args);
    }

    private static void SetMessage(String format, Object... args) {
        message = String.format(printLocale, format, args);
    }

    private static void PrintMessage() {
        if (!message.equals("")) {
            printf("%s\n\n", message);
        }
    }

    private static void PushErrorMesssage(String format, Object... args) {
        String tmp = String.format(printLocale, format, args);
        PushMessage("\u001b[31;1mERROR:\u001b[0m %s", tmp);
    }

    private static void ResetBuffer() {
        ResetOutput();
        ResetMessage();
    }

    private static void ResetOutput() {
        SetOutput("");
    }

    private static void ResetMessage() {
        SetMessage("");
    }

    private static int ReadInt() {
        int value;

        try {
            printf("\u001b[36m");
            value = Integer.parseInt(input.nextLine());
            printf("\u001b[0m");
        } catch (Exception e) {
            PushErrorMesssage("\u001b[33mNOT AN INTEGER\u001b[0m\n");
            // message = "\n\u001b[31;1mERROR:\u001b[33m NOT AN INTEGER\u001b[0m\n";
            printf("%s\n", message);
            value = Integer.MIN_VALUE;
        }

        return value;
    }

    private static void Clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
