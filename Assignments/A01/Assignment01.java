
/**
 * Author: Pratchaya Khansomboon
 */

import java.util.Scanner;
import java.util.Locale;

public class Assignment01 {

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
        for(int i = 0; i < guestList.length; i++){
            if(!guestList[i][0].equals(""))
                printf("%d. %s\t%s\n", i, guestList[i][0], guestList[i][1]);
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
        System.out.println("You chose to print the menu"); // you don't need to keep this line
        // Add your code here
    }

    private static Scanner input = new Scanner(System.in);
    private static Locale printLocale = new Locale("en", "UK");

    public static void main(String[] args) {
        printf("Enter a number: ");
        ReadInt();

        printGuestList();
    }

    public static void printf(String format, Object... args) {
          System.out.printf(printLocale, format, args);
    }

    private static int ReadInt(){
        int value;

        try {
            value = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            printf("\n\u001b[31;1mERROR:\u001b[33m NOT A NUMBER\u001b[0m\n\n");
            value = Integer.MIN_VALUE;
        }

        return value;
    }

}
