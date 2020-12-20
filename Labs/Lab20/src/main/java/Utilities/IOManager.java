package Utilities;

import java.util.Locale;
import java.util.Scanner;

public class IOManager {

    public static Scanner input = new Scanner(System.in);
    protected static Locale locale = new Locale("en", "UK");

    public static int ReadInt() {
        int value = Integer.MIN_VALUE;

        try {
            String raw = input.nextLine();
            value = Integer.valueOf(raw);
        } catch (Exception e) {
            error("\n\u001b[31;1mError parsing input. It might not be an integer.\n\u001b[33;1mReturning MIN_VALUE\u001b[0m\n\n");
            input.nextLine();

            return Integer.MIN_VALUE;
        }

        return value;
    }

    public static String ReadLine() {
        return input.nextLine();
    }

    public static double ReadDouble() {
        double value = 0;

        try {
            String raw = input.nextLine();
            value = Double.valueOf(raw);
        } catch (Exception e) {
            error("\n\u001b[31;1mError parsing input. It might not be a double.\n\u001b[33;1mReturning MIN_VALUE\u001b[0m\n\n");
        }

        return value;
    }

    public static void printf(String format, Object... args) {
        System.out.printf(locale, format, args);
    }

    public static void error(String format, Object... args) {
        System.err.printf(format, args);
    }

    private static void Clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}