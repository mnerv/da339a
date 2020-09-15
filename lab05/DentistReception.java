import java.util.Scanner;

public class DentistReception {
    public static void main(String[] args) {
        double cost = 0; // Yeah, storing money as floating point is a bad idea.
        int treatment = 0;

        final double checkUp = 600.00;
        final double cleaning = 300.00;
        final double cavity = 1500.00;

        Scanner input = new Scanner(System.in);

        System.out.println("Treatment options: ");
        System.out.println("Checkup:  1");
        System.out.println("Cleaning: 2");
        System.out.println("Fixing:   3");
        System.out.println("Cancel:  -1");
        try {
            System.out.print("\nEnter treatment: ");
            treatment = input.nextInt();

            if (treatment == -1) {
                System.out.println("Cancelled, exiting the program.");
                input.close();
                return;
            }
        } catch (Exception e) {
            System.err.printf("\n\u001b[31;1mError parsing input. It might not be an integer.\u001b[0m\n");

            input.close();
            return;
        }

        switch (treatment) {
            case 1:
                cost = checkUp;
                break;
            case 2:
                cost = cleaning;
                break;
            case 3:
                cost = cavity;
                break;
            default:
                break;
        }

        System.out.printf("\nYour total will be: %f\n", cost);

        input.close();
    }
}
