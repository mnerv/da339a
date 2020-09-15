import java.util.Scanner;

public class AskNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.print("Enter an integer: ");

        try {
            number = input.nextInt();
        } catch (Exception e) {
            System.err.printf("\n\u001b[31;1mError parsing input. It might not be an integer.\u001b[0m\n");

            input.close();
            return;
        }

        if (number > 100)
            System.out.println("Number entered is bigger than 100.");
        else
            System.out.printf("Max value is 100. You've entered: %d\n", number);

        input.close();
    }
}
