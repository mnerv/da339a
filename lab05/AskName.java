import java.util.Scanner;

public class AskName {
    public static void main(String[] args) {
        String name;
        int nameLength;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = input.nextLine();
        nameLength = name.length();

        if (nameLength < 5)
            System.out.printf("A short name with %d characters.\n", nameLength);
        else
            System.out.printf("A long name with %d characters.\n", nameLength);

        input.close();
    }
}
