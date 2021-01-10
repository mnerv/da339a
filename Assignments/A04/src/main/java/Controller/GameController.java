package Controller;

import Model.Board;
import View.*;
import java.util.Random;

/**
 * GameController for Battleship.
 * <p>
 *  This manage the game states.
 * </p>
 */
public class GameController {
    private int boardSize = 10;

    private View view;
    private Board board;

    private Random rng;

    public GameController() {
        board = new Board(boardSize);

        rng = new Random();
    }

    public GameController(View view) {
        this();
        setView(view);

        view.setTitle("Assignment 04 - Battleship");
        view.setGridSize(10, 10);
        view.initGrid();

        board.initData(Boards.BOARD_1);
    }

    public void setView(View view) {
        this.view = view;
        this.view.setController(this);
    }

    public void run() {
        view.run();
    }

    /**
     * Shoot at this coordinate.
     *
     * @param row Position in coordinate space
     * @param column Position in coordinate space
     */
    public boolean shoot(int row, int column) {
        return shoot(row * boardSize + column);
    }

    /**
     * Shoot at the raw location in memory
     *
     * @param i Location
     * @return True if hit, false if missed
     */
    public boolean shoot(int i) {
        boolean isHit = board.shoot(i);
        var ship = board.getData(i);

        if (ship != null && ship.isDead())
            view.infoMessage("Ship destroyed!", ship.getName() + " is down!");

        return isHit;
    }

    public void resetBoard() {
        board.reset();
        board.initData(Boards.BOARDS[rng.nextInt(Boards.BOARD_COUNT)]);
    }

    public boolean isAllShipDestroyed() {
        return board.isAllShipDestroyed();
    }
}
