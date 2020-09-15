import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int number;

        try {
            number = input.nextInt();
        } catch (Exception e) {
            System.err.printf("\n\u001b[31;1mError parsing input. It might not be an integer.\u001b[0m\n");

            input.close();
            return;
        }

        if (number > 67)
            System.out.println("Number bigger than 67");

        if (number == 3 || number == 6 || number == 7)
            System.out.println("Number is equal to either 3, 6 or 7");

        if (number > 25 && number < 50)
            System.out.println("Number is bigger than 25 and less than 50.");

        if (number > 1 && number < 4 || number > 7 && number < 9)
            System.out.println("Number is bigger bigger than 1 and less than 4 or bigger than 7 and less than 9.");

        // TODO: 4c

        if (args.length > 0 && args[0] == "-c") {
            if (number % 3 != 0)
                System.out.println("Number is not divisible by 3.");
            else if (number % 4 != 0)
                System.out.println("Number is not divisible by 4.");
        }

        input.close();
    }
}
