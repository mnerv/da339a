package Tasks;

public class Task05 extends Task {

    @Override
    public void Run() {
        double[] arr1 = { 3.3, 2.7, 6.4, 1.8, 9.5, 1.4, 9.0, 7.0, 6.5, 3.7 };
        double[] arr2 = { 5.6, 4.7, 2.8, 3.7, 5.8, 2.7, 6.4, 1.8, 9.5, 10.2 };

        for (int i = 0; i < arr1.length; i++) {
            System.out.printf(locale, "%.1f", arr1[i] - arr2[i]);
            if (i < arr1.length - 1)
                System.out.print(" ");
        }
        System.out.println();

        // TODO: not complete
    }

}
