package Controller;

import Model.Board;
import View.*;

/**
 * GameController for Battleship.
 * <p>
 *  This manage the game states.
 * </p>
 */
public class GameController {
    int boardSize = 10;

    // View view;
    Board board;

    public GameController() {
        board = new Board(boardSize);
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                String sprite = " ";
                if (board.data[i * boardSize + j] != null) {
                    switch (board.data[i * boardSize + j].getType()) {
                        case Carrier:
                            sprite = "A";
                            break;
                        case Battleship:
                            sprite = "B";
                            break;
                        case Cruiser:
                            sprite = "C";
                            break;
                        case Submarine:
                            sprite = "D";
                            break;
                        case Destroyer:
                            sprite = "E";
                            break;
                    }
                }

                if (j == 0)
                    System.out.print("|");
                System.out.print(sprite);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void setView(View view) {
        // this.view = view;
    }

    public void run() {
        // view.run();
    }

    /**
     * Shoot at this coordinate
     *
     * @param row Position in coordinate space
     * @param column Position in coordinate space
     */
    public void shoot(int row, int column) {}

    // TODO: Return character of arrays for the view to use
    public int[] getBoardData() {
        return null;
    }
}
