package Tasks;

/**
 * Move zero values to the end of the list
 */
public class Task06 extends Task {

    @Override
    public void Run() {
        int[] arr = { 12, 13, 14, 13, 0, 0, 15, 15, 0, 13 };
        int zeroCount = 0;

        for (int i = 0; i < arr.length; i++)
            zeroCount = arr[i] == 0 ? zeroCount + 1 : zeroCount;

        System.out.println("Input: ");
        PrintArrayInt(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }

            if (i == arr.length - 2 && zeroCount > 0) {
                zeroCount--;
                i = 0;
            }
        }

        System.out.println("Output: ");
        PrintArrayInt(arr);
    }
}
