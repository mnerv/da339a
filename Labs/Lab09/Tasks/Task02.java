package Tasks;

public class Task02 extends Task {

    @Override
    public void Run() {
        int[] arr = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37, 14, 95 };

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = arr[minIndex] <= arr[i + 1] ? minIndex : i + 1; // variant 1
            maxIndex = arr[maxIndex] >= arr[i + 1] ? maxIndex : i + 1; // variant 1

            // minIndex = arr[minIndex] < arr[i + 1] ? minIndex : i + 1; // variant 2
            // maxIndex = arr[maxIndex] > arr[i + 1] ? maxIndex : i + 1; // variant 2
        }

        printf("Max value %d is found at index %d\n", arr[maxIndex], maxIndex);
        printf("Min value %d is found at index %d\n", arr[minIndex], minIndex);
    }

}
