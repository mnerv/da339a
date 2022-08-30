import Tasks.*;

import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    private static int ReadInt(){
        int value = Integer.MIN_VALUE;

        try {
            value = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.err.println("Error, might not be an integer");
            input.nextLine();

            return Integer.MIN_VALUE;
        }

        return value;
    }

    private static void Clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static Task[] tasks = new Task[11];

    public static void main(String[] args) {
        tasks[0] = new Task01();
        tasks[1] = new Task02();
        tasks[2] = new Task03();
        tasks[3] = new Task04();
        tasks[4] = new Task05();
        tasks[5] = new Task06();
        tasks[6] = new Task07();
        tasks[7] = new Task08();
        tasks[8] = new Task09();
        tasks[9] = new Task10();
        tasks[10] = new Task11();

        Clear();

        while(true) {

            System.out.println("Input -1 to exit");
            System.out.print("Select task: ");
            int taskSelector = ReadInt();

            System.out.println();

            if(taskSelector == -1)
                break;

            if(taskSelector > 10 || taskSelector < -1) {
                System.out.println("You're selecting a task that's out of range");
                continue;
            }
            
            Clear();

            tasks[taskSelector].Run();

            System.out.println("\n***************************************\n");

        }

        //Task a = new Task01();

        //a.Run();
    }

}
