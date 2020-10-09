import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        while (true) {
            System.out.print("Enter name: ");
            String name = sn.nextLine();
            if (name.equals("")) {
                System.out.println("Please enter a name.");
                continue;
            }
            System.out.format("Hello %s!\n", name);

            System.out.print("\nExit y/n?: ");
            String test = sn.nextLine();

            if (test.equals("y"))
                break;
        }
        sn.close();
    }
}
