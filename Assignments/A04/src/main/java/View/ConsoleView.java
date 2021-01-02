package View;

public class ConsoleView extends View {
    // clang-format off
  final String boardSprite =
    "   │ A │ B │ C │ D │ E │ F │ G │ H │ I │ J │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "1  │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "2  │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "3  │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "4  │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "5  │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "6  │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "7  │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "8  │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "9  │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
    "10 │ x │ x │ x │ x │ x │ x │ x │ x │ x │ x │\n"+
    "───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
    // clang-format on

    String boardFormat;
    int size;

    boolean isRunning = true;

    /**
     * Create a 10x10 view
     */
    public ConsoleView() {
        this(10);
    }

    /**
     * Create a size x size
     *
     * @param size Size of the board
     */
    public ConsoleView(int size) {
        initBoardFormat();
        this.size = size;
    }

    @Override
    public void run() {}

    @Override
    public void update() {}

    public void initBoardFormat() {
        boardFormat = boardSprite.replaceAll("x", "%s");
    }

    public void showBoard(String boardData[]) {
        if (boardData.length > size)
            return;

        String tmpFormat = boardFormat;

        for (int i = 0; i < size * size; i++) {
            tmpFormat.replace("x", boardData[i]);
        }

        System.out.println(tmpFormat);
    }
}
