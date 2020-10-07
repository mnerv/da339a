
/**
 * Author: Pratchaya Khansomboon
 */

import java.util.Scanner;

public class Assignment01 {

    static Scanner input = new Scanner(System.in);

    // @formatter:off
    static String[][] guestList = { 
        { "Adam Ason", "35" }, 
        { "Berta Bson", "70" }, 
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
        System.out.println("You chose to print the guest list"); // you don't need to keep this line
        // Add your code here
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
        System.out.println("You chose to switch places between index " + index1 + " and " + index2); // you don't need
                                                                                                     // to
                                                                                                     // keep this line
        // Add your code here
    }

    public static void printMenu() {
        System.out.println("You chose to print the menu"); // you don't need to keep this line
        // Add your code here
    }

    public static void main(String[] args) {
        // Add you code here with the main loop that handles the user's menu choices.
    }
}