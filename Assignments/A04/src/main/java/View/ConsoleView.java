package View;

import Controller.GameController;

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

    GameController controller;

    /**
     * Create a 10x10 view
     */
    public ConsoleView(GameController controller) {
        this(controller, 10);
    }

    /**
     * Create a size x size
     *
     * @param size Size of the board
     */
    public ConsoleView(GameController controller, int size) {
        this.controller = controller;
        this.size = size;
    }

    @Override
    public void run() {}

    @Override
    public void update() {}

    private void showBoard() {
        // int[] boardData = controller.getBoardData();

        // if (boardData.length > size)
        //     return;

        // boardFormat = boardFormat;

        // for (int i = 0; i < size * size; i++) {
        //     switch (boardData[i]) {
        //         case 1: // Miss
        //             boardFormat = boardFormat.replace(" x ", " ◦ ");
        //             break;
        //         case 3: // Hit
        //             boardFormat = boardFormat.replace(" x ", " ✕ ");
        //             break;
        //         case 0: // Empty
        //         default:
        //             boardFormat = boardFormat.replace(" x ", "   ");
        //             break;
        //     }
        // }

        // System.out.println(boardFormat);
    }

    @Override
    public void initGrid() {}

    @Override
    public void infoMessage(String title, String message) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean confirmMessage(String title, String message) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void errMessage(String title, String message) {
        // TODO Auto-generated method stub
    }

    @Override
    public String inputDialog(String title, String label) {
        // TODO Auto-generated method stub
        return null;
    }
}
