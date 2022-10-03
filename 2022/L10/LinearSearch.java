public class LinearSearch extends Task {
    @Override
    public String str() {
        return "Uppgift 1 Linjär sökning";
    }

    @Override
    public void run() {
        int test_array[] = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37};
        int search_value = 95;
        int search_index = -1;
        for (int i = 0; i < test_array.length; ++i) {
            if (test_array[i] == search_value) {
                search_index = i;
                break;
            }
        }

        System.out.println("Search for: " + search_value);
        System.out.println("Found at position: " + search_index);
    }
}

