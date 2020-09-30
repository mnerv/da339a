package Tasks;

import java.util.Scanner;
import java.util.Locale;

public abstract class Task {
    public static Scanner input = new Scanner(System.in);

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

    protected Locale locale;

    Task() {
        locale = new Locale("en", "UK");
    }

    public abstract void Run();
}
