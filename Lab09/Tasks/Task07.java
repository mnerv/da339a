package Tasks;

public class Task07 extends Task {

    @Override
    public void Run() {
        int[][] arr1 = { { 1, 2, 3 }, { 11, 12, 13 }, { 21, 22, 23 } };
        int[][] arr2 = { { 1, 2, 3 }, { 11, 12, 13 }, { 21, 22, 23 } };

        boolean isEqual = true;

        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i].length != arr2[i].length)
                    isEqual = false;
            }
        } else {
            isEqual = false;
        }

        printf("Array 1 and 2 are%s equal\n", isEqual ? "" : " not");

        // TODO: size check done, but not the task
    }

}
