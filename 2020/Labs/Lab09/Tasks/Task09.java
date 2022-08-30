package Tasks;

/**
 * Bubble sort
 */
public class Task09 extends Task {

    @Override
    public void Run() {
        int[] arr = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };

        printf("Input:\n");

        PrintArrayInt(arr);

        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }

        printf("Output:\n");
        PrintArrayInt(arr);

    }

}
