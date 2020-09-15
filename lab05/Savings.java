import java.util.Scanner;

public class Savings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int amount;
        int weeks;
        int sum;

        System.out.print("Enter savings per week: ");

        try {
            amount = input.nextInt();
        } catch (Exception e) {
            System.err.printf("\n\u001b[31;1mError parsing input. It might not be a number\u001b[0m\n");

            input.close();
            return;
        }

        System.out.print("Enter how many weeks: ");

        try {
            weeks = input.nextInt();
        } catch (Exception e) {
            System.err.printf("\n\u001b[31;1mError parsing input. It might not be a number\u001b[0m\n");

            input.close();
            return;
        }

        sum = weeks * amount;

        if (sum >= 5000) {
            System.out.println("You're very good at saving. You get 100 kr as a bonus.");
            sum += 100;
        } else if (sum >= 2500) {
            System.out.println("You get 50 kr as a bonus.");
            sum += 50;
        } else {
            System.out.println("You're not very good at saving.");
        }

        System.out.println("After " + weeks + " weeks, you've saved " + sum + " kr.");

        input.close();
    }

}
