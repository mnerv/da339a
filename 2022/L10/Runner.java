import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        tasks[0]  = new LinearSearch();
        tasks[1]  = new FindMaximum();
        tasks[2]  = new FindMinimum();
        tasks[3]  = new Print2DArrayA();
        tasks[4]  = new Print2DArrayB();
        tasks[5]  = new MeasuredData();
        tasks[6]  = new CalibrateSensor();
        tasks[7]  = new RedundantData();
        tasks[8]  = new SaveLargest();
        tasks[9]  = new SelectionSort();
        tasks[10] = new GameLevel();
        tasks[11] = new DentistClinic();
        tasks[12] = new DentistExtend();

        while (true) {
            print_tasks();
            final var text = read_text();
            if (text.compareToIgnoreCase("clear") == 0) {
                clear();
                continue;
            }

            final var index = validate_index(text);
            if (index == -1) break;
            if (index == Integer.MIN_VALUE || index < 0 || index > tasks.length - 1) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            System.out.println();
            System.out.println("Running task: " + tasks[index].str());
            tasks[index].run();
            System.out.println();
        }
    }

    private static void print_tasks() {
        System.out.println("Task list");
        System.out.println("--------------------------------");
        for (int i = 0; i < 13; ++i) {
            if (i < 10) System.out.print(" ");
            System.out.print(i);
            System.out.print(". ");
            System.out.println(tasks[i].str());
        }
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static String read_text() {
        System.out.print("Select task. Enter -1 to quit: ");
        return input.nextLine();
    }
    private static int validate_index(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }
    }

    private static Scanner input = new Scanner(System.in);
    private static Task tasks[] = new Task[13];
}

