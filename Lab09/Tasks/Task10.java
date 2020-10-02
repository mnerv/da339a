package Tasks;

public class Task10 extends Task {

    @Override
    public void Run() {
        // @formatter:off
        int[][] arr = { 
            { 1, 1, 2, 3, 3 }, 
            { 2, 1, 1, 2, 3 }, 
            { 3, 2, 2, 1, 2 }, 
            { 3, 3, 3, 3, 3 }
        };
        // @formatter:on

        boolean[][] board = new boolean[4][5];

        printf("Input: \n");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                printf("%d", arr[i][j]);
                if (j < arr[i].length - 1)
                    printf(" ");
                int sum = 0;

                if (i > 0) {
                    if (j > 0)
                        sum += arr[i - 1][j - 1];

                    sum += arr[i - 1][j];

                    if (j < arr[i].length - 1)
                        sum += arr[i - 1][j + 1];
                }

                if (j > 0)
                    sum += arr[i][j - 1];
                if (j < arr[i].length - 1)
                    sum += arr[i][j + 1];

                if (i < arr.length - 1) {
                    if (j > 0)
                        sum += arr[i + 1][j - 1];
                    sum += arr[i + 1][j];

                    if (j < arr[i].length - 1)
                        sum += arr[i + 1][j + 1];
                }

                if (arr[i][j] == 3 || sum >= 15) {
                    board[i][j] = false;
                } else {
                    board[i][j] = true;
                }

                // printf(" %d ", sum);

            }
            printf("\n");
        }

        printf("\nOutput:\n");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                printf("%s", board[i][j] ? "T" : "F");

                if (j < board[i].length - 1)
                    printf(" ");
            }
            printf("\n");

        }
    }

}
