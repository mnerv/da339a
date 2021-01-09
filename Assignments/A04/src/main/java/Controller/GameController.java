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

    View view;
    Board board;

    public GameController() {
        board = new Board(boardSize);
    }

    public GameController(View view) {
        this();
        setView(view);

        view.setTitle("Assignment 04 - Battleship");
        view.setGridSize(10, 10);
        view.initGrid();
    }

    public void setView(View view) {
        this.view = view;
        this.view.setController(this);
    }

    public void run() {
        view.run();
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
