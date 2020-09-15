import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value1, value2;

        System.out.print("Enter first value: ");
        try {
            value1 = input.nextInt();
        } catch (Exception e) {
            System.err.printf("\n\u001b[31;1mError parsing input. It might not be an integer.\u001b[0m\n");

            input.close();
            return;
        }

        System.out.print("Enter the second value: ");
        try {
            value2 = input.nextInt();
        } catch (Exception e) {
            System.err.printf("\n\u001b[31;1mError parsing input. It might not be an integer.\u001b[0m\n");

            input.close();
            return;
        }

        if (value1 == value2) {
            System.out.println("The values are equal.");
        } else if (value1 > value2) {
            System.out.println("Value 1 is biggest!");
        } else {
            System.out.println("Value 2 is biggest!");
        }

        input.close();
    }
}
