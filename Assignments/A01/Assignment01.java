
/**
 * Author: Pratchaya Khansomboon
 */

import java.util.Scanner;
import java.util.Locale;

public class Assignment01 {
    // @formatter:off
    private static String[] menuList = {
        "Show guest list",
        "Show guest statistic",
        "Add guest",
        "Change guest's name",
        "Change guest's age",
        "Change guest's list position",
        "Removed guest",
        "Exit"
    };

    static String[][] guestList = { 
    //    name,          age
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

        int longestName = 0;
        int longestAge = 0;

        final int space = 6;
        final String sf1 = "%2d. %-";
        final String sf2 = "s%s\n";

        for (int i = 0; i < guestList.length; i++) {
            longestName = guestList[i][0].length() > longestName ? guestList[i][0].length() : longestName;
            longestAge = guestList[i][1].length() > longestAge ? guestList[i][1].length() : longestAge;
        }

        longestName += space;

        final String format = sf1 + longestName + sf2;

        HLine(longestName + space + longestAge);

        for (int i = 0; i < guestList.length; i++) {
            String name = guestList[i][0];
            String age = guestList[i][1];

            PushOutput(format, i + 1, name, age);
        }
    }

    public static void printStatistics() {
        int childrenCount = 0;
        int guestCount = 0;
        int adultCount = 0;

        int oldestIndex = 0;
        int youngestIndex = 0;

        for (int i = 0; i < guestList.length; i++) {
            if (!guestList[i][0].isEmpty() && !guestList[i][1].isEmpty()) {
                int age = Integer.parseInt(guestList[i][1]);
                guestCount++;

                if (age <= childAge) {
                    childrenCount++;
                } else if (age >= adultAge) {
                    adultCount++;
                }

                if (i < guestList.length - 1 && !guestList[i + 1][0].isEmpty() && !guestList[i][1].isEmpty()) {
                    int ageAhead = Integer.parseInt(guestList[i + 1][1]);

                    if (guestList[youngestIndex][1].isEmpty())
                        youngestIndex = i;

                    if (guestList[oldestIndex][1].isEmpty())
                        oldestIndex = i;

                    oldestIndex = ageAhead > Integer.parseInt(guestList[oldestIndex][1]) ? i + 1 : oldestIndex;
                    youngestIndex = ageAhead < Integer.parseInt(guestList[youngestIndex][1]) ? i + 1 : youngestIndex;
                }
            }
        }

        PushOutput("Guest statistics\n");
        HLine();
        PushOutput("Guest count: %d\nAdult count: %d\nChildren count: %d\nOldest: %s age %s\nYoungest: %s age %s",
                guestCount, adultCount, childrenCount, guestList[oldestIndex][0], guestList[oldestIndex][1],
                guestList[youngestIndex][0], guestList[youngestIndex][1]);
    }

    public static void addGuest() {
        if (isFull()) {
            PushErrorMesssage("Guest list full\n");
            return;
        }

        Clear();

        printf("Enter guest firstname and lastname\nName: ");
        String name = input.nextLine();

        if (name.trim().isEmpty()) {
            PushErrorMesssage("Name cannot be empty\n");
            return;
        }

        printf("Enter guest's age: ");
        int age = ReadInt();

        if (age == Integer.MIN_VALUE) {
            PushErrorMesssage("INPUT AGE IS NOT A NUMBER\n");
            return;
        }

        if (age < 0) {
            PushErrorMesssage("Age cannot be less than 0\n");
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

    public static void changeNamneOfGuest() {
        ClearPrintListReset();

        printf("Select guest nr. to change the name.\nSelect: ");
        int index = ReadInt();
        if (index == Integer.MIN_VALUE) {
            PushErrorMesssage("Guest no. is not a number\n");
            return;
        }

        if (index > 0 && index < guestList.length + 1) {
            int i = index - 1;

            if (guestList[i][0].isEmpty()) {
                PushErrorMesssage("Guess no. %d is empty", index);
                return;
            }

            printf("Enter name: ");
            String name = input.nextLine();

            if (name.trim().isEmpty()) {
                PushErrorMesssage("Name cannot be empty\n");
                return;
            }

            String before = guestList[i][0];
            guestList[i][0] = name;

            PushOutput("Updated guest's name:\n %d. %s -> %s\n", index, before, name);
            HLine();
            printGuestList();

        } else {
            PushErrorMesssage("Guest number is out of range\n");
        }
    }

    public static void changeAgeOfGuest() {
        ClearPrintListReset();

        printf("Select guest no. to change the age.\nSelect: ");
        int index = ReadInt();

        if (index == Integer.MIN_VALUE) {
            PushErrorMesssage("Guest number is not a number\n");
            return;
        }

        if (index > 0 && index < guestList.length + 1) {
            int i = index - 1;

            if (guestList[i][0].isEmpty()) {
                PushErrorMesssage("Guess no. %d is empty", index);
                return;
            }

            printf("Enter age: ");
            int age = ReadInt();

            if (age == Integer.MIN_VALUE) {
                PushErrorMesssage("Age needs to be a number\n");
                return;
            }

            if (age < 0) {
                PushErrorMesssage("Age cannot be less than 0\n");
                return;
            }

            String before = guestList[i][1];
            guestList[i][1] = Integer.toString(age);

            PushOutput("Updated guest's age:\n %d. %s, %s -> %s\n", index, guestList[i][0], before, guestList[i][1]);
            HLine();
            printGuestList();

        } else {
            PushErrorMesssage("Guest no. is out of range\n");
        }
    }

    public static void removeGuest() {
        ClearPrintListReset();

        printf("Select the guest to be removed\n");
        printf("Select: ");
        int index = ReadInt();

        if (index > 0 && index < guestList.length) {

            PushOutput("Removed:\n%d. %s\t\t%s\n", index, guestList[index - 1][0], guestList[index - 1][1]);
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

    public static void changePlaces() {
        ClearPrintListReset();

        printf("Change guest postion\n");
        printf("Select guest no.: ");
        int pos1 = ReadInt();

        if (pos1 == Integer.MIN_VALUE) {
            PushErrorMesssage("Input Guest no. is not a number\n");
            return;
        }

        if (!(pos1 > 0 && pos1 < guestList.length + 1)) {
            PushErrorMesssage("Guest no. is out of range");
            return;
        }

        printf("Select swap position: ");
        int pos2 = ReadInt();

        if (pos2 == Integer.MIN_VALUE) {
            PushErrorMesssage("Input swap position is not a number\n");
            return;
        }

        if (!(pos2 > 0 && pos2 < guestList.length + 1)) {
            PushErrorMesssage("Swap position is out of range\n");
            return;
        }

        int i0 = pos1 - 1;
        int i1 = pos2 - 1;

        String[] tmp = { guestList[i0][0], guestList[i0][1], };

        guestList[i0] = guestList[i1];
        guestList[i1] = tmp;

        PushOutput("Updated:\n");
        PushOutput("%s, Position: %d -> %d\n", tmp[0], pos1, pos2);
        HLine();
        printGuestList();

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
        HLine(HlineSize);
    }

    private static void HLine(int size) {
        for (int i = 0; i < size; i++) {
            PushOutput("-");
            printf("-");
        }
        PushOutput("\n");
        printf("\n");
    }

    private static void ClearPrintListReset() {
        Clear();
        printGuestList();
        PrintOutput();
        ResetOutput();
    }

    private static final int adultAge = 18;
    private static final int childAge = 13;

    private static int HlineSize = 32;
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
                    PushOutput("Hello There");
                    break;
                case 1:
                    printGuestList();
                    break;
                case 2:
                    printStatistics();
                    break;
                case 3:
                    addGuest();
                    break;
                case 4:
                    changeNamneOfGuest();
                    break;
                case 5:
                    changeAgeOfGuest();
                    break;
                case 6:
                    changePlaces();
                    break;
                case 7:
                    removeGuest();
                    break;
                case -1:
                    isRunning = false; // NO MORE SAO
                    printf("Goodbye\n");
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

    /**
     * Prints out the output buffer with newline
     */
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
