package Tasks;

public class Task04 extends Task {

    @Override
    public void Run() {
        double[] arr = { 3.3, 2.7, 6.4, 1.8, 9.5, 1.4, 9.0, 7.0, 6.5, 3.7 };
        double maxNum = Double.MIN_VALUE;
        double minNum = Double.MAX_VALUE;
        double sum = 0.0d;

        for (int i = 0; i < arr.length; i++) {
            double current = arr[i];
            sum += current;
            maxNum = current > maxNum ? current : maxNum;
            minNum = current < minNum ? current : minNum;
        }

        System.out.printf(locale, "Min: %.1f, Average: %.1f, Max: %.1f \n", minNum, sum / arr.length, maxNum);
    }

}
