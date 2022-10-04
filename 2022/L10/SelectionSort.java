public class SelectionSort extends Task {
    @Override
    public String str() {
        return "Uppgift 8 Selection Sort REDOVISAS";
    }

    @Override
    public void run() {
        int[] array = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37};
        print_array(array);

        for (int i = 0; i < array.length; ++i) {
            int min_value_index = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[min_value_index])
                    min_value_index = j;
            }

            if (min_value_index != i) {
                final var tmp = array[i];
                array[i]      = array[min_value_index];
                array[min_value_index] = tmp;
            }
        }

        print_array(array);
    }

    private void print_array(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
            else System.out.println("}");
        }
    }
}
