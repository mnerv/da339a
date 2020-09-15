import java.util.Scanner;

public class AskAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int age;

        System.out.print("Enter your age: ");

        try {
            age = input.nextInt();
        } catch (Exception e) {
            System.err.printf("\n\u001b[31;1mError parsing input. It might not be an integer.\u001b[0m\n");

            input.close();
            return;
        }

        if (age <= 17)
            System.out.println("You're a kid.");
        else
            System.out.println("You'e an adult.");

        input.close();

    }
}
