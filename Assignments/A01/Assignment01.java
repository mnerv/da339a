
/**
 * Author: Pratchaya Khansomboon
 */

import java.util.Scanner;
import java.util.Locale;

public class Assignment01 {
    private static String[] menuList = {
        "Show guest list",
        "Add guest",
        "Change guest's name",
        "Change guest's age",
        "Change guest's list position",
        "Removed guest",
        "Exit"
    };

    // @formatter:off
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
        printf("\u001b[37;1mGuest List\u001b[0m\n");
        HLine();
        for(int i = 0; i < guestList.length; i++){
            String name = guestList[i][0];
            String age = guestList[i][1];

            printf("%d. %s\t\t%s\n", i + 1, name, age);
        }
    }

    public static void printStatistics() {
        System.out.println("You chose to print statistics"); // you don't need to keep this line
        // Add your code here
    }

    public static void addGuest(String name, String age) {
        System.out.println("You chose to add a guest"); // you don't need to keep this line
        // Add your code here
    }

    public static void changeNamneOfGuest(int index, String newName) {
        System.out.println("You chose to change the name of a guest"); // you don't need to keep this line
        // Add your code here
    }

    public static void changeAgeOfGuest(int index, String newAge) {
        System.out.println("You chose to change the age of a guest"); // you don't need to keep this line
        // Add your code here
    }

    public static void removeGuest(int index) {
        System.out.println("You chose to remove a guest"); // you don't need to keep this line
        // Add your code here
    }

    public static void changePlaces(int index1, int index2) {
        // Add your code here
    }

    public static void printMenu() {
        printf("Menu\n");
        HLine();
        for(int i = 0; i < menuList.length; i++){
            if(i < menuList.length - 1)
                printf("%d. %s\n", i + 1, menuList[i]);
            else 
                printf("Enter -1 to exit\n\n");
        }
    }

    private static void HLine(){
        printf("-------------------------------\n");
    }

    private static Scanner input = new Scanner(System.in);
    private static Locale printLocale = new Locale("en", "UK");
    private static String message = "";

    public static void main(String[] args) {
        boolean isRunning = true;


        while(isRunning) {
            Clear();
            printMenu();

            if(!message.equals("")){
                printf("%s\n\n", message);
                message = "";
            }

            printf("Select: ");
            int selector = ReadInt();
           
            switch (selector) {
                case 0:
                    break;
                case -1:
                    isRunning = false;
                    break;
                default:
                    if(!message.equals(""))
                        message += "\n";
                    message += "Not a valid option.";
                    break;
            } 

        }

    }

    public static void printf(String format, Object... args) {
          System.out.printf(printLocale, format, args);
    }

    private static int ReadInt(){
        int value;

        try {
            printf("\u001b[36m");
            value = Integer.parseInt(input.nextLine());
            printf("\u001b[0m");
        } catch (Exception e) {
            message = "\n\u001b[31;1mERROR:\u001b[33m NOT AN INTEGER\u001b[0m\n";
            printf("%s\n", message);
            value = Integer.MIN_VALUE;
        }

        return value;
    }

    private static void Clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
