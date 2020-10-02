package Tasks;

public class Task01 extends Task {

    @Override
    public void Run() {
        int[] arr = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };
        int searchValue = 70;

        int searchIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (searchValue == arr[i]) {
                searchIndex = i;
                break;
            }
        }

        if (searchIndex != -1) {
            printf("Value %d found at index %d\n", searchValue, searchIndex);
        } else {
            printf("There are no value %d\n", searchValue);
        }

    }

}
