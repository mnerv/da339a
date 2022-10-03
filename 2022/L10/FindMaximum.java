public class FindMaximum extends Task {
    @Override
    public String str() {
        return "Uppgift 2a Hitta största";
    }

    @Override
    public void run() {
        int[] testArray = {32, 27, 64, 18, 95, 14, 90, 70, 95, 37};

        int largest_value_low = Integer.MIN_VALUE;
        int largest_value_position_low = -1;
        for (int i = 0; i < testArray.length; ++i) {
            if (testArray[i] > largest_value_low) {
                largest_value_position_low = i;
                largest_value_low = testArray[i];
            }
        }

        int largest_value_high = Integer.MIN_VALUE;
        int largest_value_position_high = -1;
        for (int i = 0; i < testArray.length; ++i) {
            if (testArray[i] >= largest_value_high) {
                largest_value_position_high = i;
                largest_value_high = testArray[i];
            }
        }

        System.out.println("Variant A: index = " + largest_value_position_low + ", value: " + largest_value_low);
        System.out.println("Variant B: index = " + largest_value_position_high + ", value: " + largest_value_high);
    }
}

