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

        if (args.length > 0 && args[0].equals("-b"))
            switch (day) {
                case 1:
                    System.out.println("Monday you can fall apart");
                case 2:
                    System.out.print("Tuesday, ");
                case 3:
                    System.out.println("Wednesday break my heart");
                case 4:
                    System.out.println("Oh, Thursday doesn't event start");
                case 5:
                    System.out.println("It's Friday, I'm in love");
                    break;
                case 6:
                    System.out.println("Saturday, wrong day");
                case 7:
                    System.out.println("And Sunday wrong");
                    break;
                default:
                    System.out.printf("\n\u001b[33;1mNot a valid number for day in a week.\u001b[0m\n");
                    break;
            }
        else
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
