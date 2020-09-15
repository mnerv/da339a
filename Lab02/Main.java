class Welcome {
    public Welcome() {
        System.out.println("Welcome!");
    }

    public class Charlie {
        public Charlie() {
            System.out.println("It's Charlie.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Welcome a = new Welcome();
        Welcome.Charlie c = a.new Charlie();

        System.out.println("Hello, World!");
    }
}