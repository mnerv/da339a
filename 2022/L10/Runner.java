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
            var value = read_int();
            if (value == -1) break;
            if (value == Integer.MIN_VALUE || value < 0 || value > tasks.length - 1) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            System.out.println();
            System.out.println("Running task: " + tasks[value].str());
            tasks[value].run();
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

    private static int read_int() {
        System.out.print("Select task. Enter -1 to quit: ");
        var text = input.nextLine();
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }
    }

    private static Scanner input = new Scanner(System.in);
    private static Task tasks[] = new Task[13];
}

