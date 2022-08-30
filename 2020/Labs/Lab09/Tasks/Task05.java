package Tasks;

/**
 * Print the difference between array 1 and 2
 */
public class Task05 extends Task {

    @Override
    public void Run() {
        double[] arr1 = { 3.3, 2.7, 6.4, 1.8, 9.5, 1.4, 9.0, 7.0, 6.5, 3.7 };
        double[] arr2 = { 5.6, 4.7, 2.8, 3.7, 5.8, 2.7, 6.4, 1.8, 9.5, 10.2 };

        if (arr1.length == arr2.length) {
            printf("Array 1 and 2 are equal\n");

            for (int i = 0; i < arr1.length; i++) {
                printf("%.1f", arr1[i] - arr2[i]);
                if (i < arr1.length - 1)
                    printf(" ");
            }
            System.out.println();
        } else {
            printf("Arrays are not the same length\n");
        }

    }

}
