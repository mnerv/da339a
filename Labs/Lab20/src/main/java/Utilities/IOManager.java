package Utilities;

import java.util.Locale;
import java.util.Scanner;

public class IOManager {

    public static Scanner input = new Scanner(System.in);
    protected static Locale locale = new Locale("en", "UK");

    public static int ReadInt() {
        int value = Integer.MIN_VALUE;

        try {
            value = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.err.printf(
                    "\n\u001b[31;1mError parsing input. It might not be an integer.\n\u001b[33;1mReturning MIN_VALUE\u001b[0m\n\n");
            input.nextLine();

            return Integer.MIN_VALUE;
        }

        return value;
    }

    public static String ReadLine() {
        return input.nextLine();
    }

    public static int ReadDecimal() {

        try {

        } catch (Exception e) {
        }

        return 0;
    }

    public static void printf(String format, Object... args) {
        System.out.printf(locale, format, args);
    }

    private static void Clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}