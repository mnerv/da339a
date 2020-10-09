package Tasks;

public class Task11 extends Task {

    @Override
    public void Run() {
        // @formatter:off
        String[][] treatment = {
            {"Checkup",     "600"},
            {"Repair", "1500"},
            {"Cleanup",     "300"},
        };
        // @formatter:on

        int[] selected = new int[10];

        for (int i = 0; i < selected.length; i++) {
            printf("\n");
            for (int j = 0; j < treatment.length; j++) {
                printf("%d. %s\t  %skr\n", j + 1, treatment[j][0], treatment[j][1]);
            }
            printf("\nEnter -1 to calculate the total");
            HDiv();

            printf("Select: ");
            int s = ReadInt();
            if (s == Integer.MIN_VALUE) {
                i--;
                continue;
            }
            if (s == -1)
                break;

            if (s > 0 && s < 4) {
                selected[i] = s;
            } else {
                printf("\u001b[31;1mNot a valid selection\u001b[0m\n");
            }

        }

        int sum = 0;
        printf("\nReceipt\n\n");
        for (int i = 0; i < selected.length; i++) {
            if (selected[i] > 0) {
                sum += Integer.parseInt(treatment[selected[i] - 1][1]);
                printf("%s\t\t%skr\n", treatment[selected[i] - 1][0], treatment[selected[i] - 1][1]);
            }
        }
        printf("----------------------\n");
        printf("Total\t\t%dkr\n", sum);
        // printf("Discount\t%dkr\n", sum);
        printf("Aoumt to pay\t%dkr\n", sum);
    }

}
