/**
 * @file   Assignment1.java
 * @author Pratchaya Khansomboon (me@mononerv.dev)
 * @date   2022-10-09
 *
 * @copyright Copyright (c) 2022
 */
import java.util.Scanner;

public class Assignment1{
    public static void main(String args[]) {
        var is_running = true;

        print_menu();
        while(is_running) {
            System.out.print("Enter program menu: ");
            final var text = read_text();
            if (text.compareTo("clear") == 0) {
                clear();
                print_menu();
                continue;
            }
            if (text.compareTo("quit") == 0 || text.compareTo("exit") == 0) {
                is_running = false;
                continue;
            }
            final var choice = validate_num(text);

            switch(choice) {
                case 1:
                    print_guest_list();
                    break;
                case 2:
                    print_statistics();
                    break;
                case 3: {
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Add guest");
                    System.out.println("--------------------------------");

                    var is_adding = true;
                    var is_err    = false;
                    String name   = "";
                    int age       = Integer.MIN_VALUE;;
                    while (is_adding) {
                        if (is_err) {
                            System.out.print("Cancel adding guest? y/N: ");
                            final var should_continue = read_text();
                            is_err = false;
                            if (should_continue.compareTo("y") == 0 || should_continue.compareTo("yes") == 0) break;
                        }

                        if (name.isEmpty()) {
                            System.out.print("Enter name: ");
                            name = read_text();
                            if (name.isEmpty()) {
                                System.out.println("Name is empty");
                                is_err = true;
                                continue;
                            }
                        }

                        if (age == Integer.MIN_VALUE) {
                            System.out.print("Enter age: ");
                            age  = validate_num(read_text());
                            if (age == Integer.MIN_VALUE) {
                                System.out.println("Age is not a valid number");
                                is_err = true;
                                continue;
                            }
                        }
                        is_adding = false;
                    }

                    if (!name.isEmpty() && age != Integer.MIN_VALUE)
                        add_guest(name, Integer.toString(age));
                    else
                        System.out.println("Guest not added");
                    System.out.println();
                    break;
                }
                case 4:
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Change name of a guest");
                    System.out.println("--------------------------------");
                    break;
                case 5:
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Change age of a guest");
                    System.out.println("--------------------------------");
                    break;
                case 6:
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Remove guest");
                    System.out.println("--------------------------------");
                    break;
                case 7:
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Change place");
                    System.out.println("--------------------------------");
                    break;
                case 8:
                    System.out.println();
                    print_menu();
                    break;
                case -1:
                    is_running = false;
                    break;
                default:
                    System.out.println("Selected choice is not valid, please try again");
                    break;
            }
        }

        System.out.println("Goodbye world...");
    }

    public static void print_guest_list() {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("Guest list");
        System.out.println("--------------------------------");
        for (int i = 0; i < guest_list.length; ++i) {
            final var guest = guest_list[i];
            if (guest[0].isEmpty()) break;
            if (i < 10) System.out.print(" ");
            System.out.print(i + 1 + ". ");
            System.out.print(guest[0]);
            System.out.print("\t");
            System.out.println(guest[1]);
        }
        System.out.println();
    }
    public static void print_statistics() {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("Statistics");
        System.out.println("--------------------------------");
    }
    public static void add_guest(String name, String age) {
        System.out.println("adding: " + name + ", " + age);
    }
    public static void change_name_of_guest(int index, String new_name) {}
    public static void change_age_of_guest() {}
    public static void remove_guest(int index) {}
    public static void change_places(int a, int b) {}
    public static void print_menu() {
        System.out.println("--------------------------------");
        System.out.println("Program menu");
        System.out.println("--------------------------------");
        System.out.println("1. Print guest list");
        System.out.println("2. Print statistics");
        System.out.println("3. Add guest");
        System.out.println("4. Change name of a guest");
        System.out.println("5. Change age of a guest");
        System.out.println("6. Remove guest");
        System.out.println("7. Change place");
        System.out.println("8. Print menu");
        System.out.println("Enter -1 or quit to exit");
        System.out.println("--------------------------------");
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static String read_text() { return input.nextLine(); }
    private static int validate_num(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE;
        }
    }

    private static Scanner input = new Scanner(System.in);
    private static String[][] guest_list = {
        {"Adam Ason", "35"},
        {"Berta Bson", "70"},
        {"Ceasar Cson", "12"},
        {"",""},
        {"",""},
        {"",""},
        {"",""},
        {"",""},
        {"",""},
        {"",""},
    };
}

