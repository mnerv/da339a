package Tasks;

public class Task07 extends Task {

    @Override
    public void Run() {
        // int[][] arr1 = { { 1, 4 }, { 2, 3 }, { 6, 7, 2 } }; // Test Array
        int[][] arr1 = { { 1, 2, 3 }, { 11, 12, 13 }, { 21, 22, 23 } };
        int[][] arr2 = { { 1, 1, 4 }, { 1, 2, 3 }, { 6, 7, 2 } };
        int[][] storage = new int[3][3];

        boolean isEqual = true;

        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i].length != arr2[i].length)
                    isEqual = false;
            }
        } else {
            isEqual = false;
        }

        printf("Array 1 and 2 are%s equal\n\n", isEqual ? "" : " not");

        if (!isEqual)
            return;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {

                printf("Array %d at index %d,%d\n", arr1[i][j] > arr2[i][j] ? 1 : 2, i, j);

                storage[i][j] = arr1[i][j] > arr2[i][j] ? arr1[i][j] : arr2[i][j];

            }
            printf("--------------------\n");
        }

    }

}
