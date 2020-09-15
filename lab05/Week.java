import java.util.Scanner;

public class Week {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int day;

        System.out.print("Enter the day of the week as a number: ");

        try {
            day = input.nextInt();
        } catch (Exception e) {
            System.err.printf("\n\u001b[31;1mError parsing input. It might not be an integer.\u001b[0m\n");

            input.close();
            return;
        }

        // TODO: 5b, change the text

        switch (day) {
            case 1:
                System.out.println("Monday");
            case 2:
                System.out.println("Tuesday");
            case 3:
                System.out.println("Wednesday");
            case 4:
                System.out.println("Thursday");
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.printf("\n\u001b[33;1mNot a valid number for day in a week.\u001b[0m\n");
                break;
        }

        input.close();
    }
}
