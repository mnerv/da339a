package Tasks;

import java.util.Scanner;
import java.util.Locale;

public abstract class Task {
    public static Scanner input = new Scanner(System.in);
    protected static Locale locale = new Locale("en", "UK");

    public static int ReadInt() {
        int value = Integer.MIN_VALUE;

        try {
            value = input.nextInt();
        } catch (Exception e) {
            System.err.printf(
                    "\n\u001b[31;1mError parsing input. It might not be an integer.\n\u001b[33;1mReturning MIN_VALUE\u001b[0m\n\n");
            return Integer.MIN_VALUE;
        }

        return value;
    }

    public static void HDiv() {
        System.out.println("\n-----------------------------------\n");
    }

    public static void printf(String format, Object... args) {
        System.out.printf(locale, format, args);
    }

    protected void PrintArrayInt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    Task() {

    }

    public abstract void Run();
}
