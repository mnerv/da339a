package Tasks;

/**
 * Insertion sort
 */
public class Task08 extends Task {

    @Override
    public void Run() {
        int[] arr = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };

        printf("Input: \n");
        PrintArrayInt(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++)
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;

            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }

        printf("Output: \n");
        PrintArrayInt(arr);

    }

}
