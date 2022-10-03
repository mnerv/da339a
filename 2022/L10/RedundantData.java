public class RedundantData extends Task {
    @Override
    public String str() {
        return "Uppgift 6 Redundant data REDOVISAS";
    }

    @Override
    public void run() {
        //int[] array = {12,13,14,13,0,0,15,15,0,13};
        int[] array = {0,12,13,14,13,0,0,15,15,0,13,0,0,15,34};
        print_array(array);

        var zero_count = 0;
        for (int i = 0; i < array.length; ++i)
            if (array[i] == 0) ++zero_count;

        for (int i = 0; i < zero_count; ++i) {
            for (int j = 0; j < array.length - 1; ++j) {
                if (array[j] == 0) {
                    final var tmp = array[j];
                    array[j]      = array[j + 1];
                    array[j + 1]  = tmp;
                }
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

