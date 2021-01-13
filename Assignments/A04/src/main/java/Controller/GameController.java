package Controller;

import Model.Board;
import Model.Score;
import View.*;
import java.util.Collections;
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
        view.setGridSize(boardSize, boardSize);
        view.initGrid();

        resetBoard();
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
     * @param i Grid location ID
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

        String input = view.inputDialog("Select a board", "Value between 1 to 4:");
        int i = 0;

        try {
            i = Integer.parseInt(input) - 1;
        } catch (NumberFormatException e) {
            i = rng.nextInt(Boards.BOARD_COUNT);
        }

        if (i < 0 || i > Boards.BOARD_COUNT - 1)
            i = rng.nextInt(Boards.BOARD_COUNT);

        board.initData(Boards.BOARDS[i]);
    }

    public boolean isCompleted() {
        return board.isCompleted();
    }

    public void saveScore(String name) {
        String playerName =
            name != null && !name.isBlank() ? name : "DEFAULT - " + board.getScoreboardSize();
        Score score = new Score(playerName);
        board.addScore(score);
    }

    public String[] getNameList() {
        var scores = board.getScoreboard();
        Collections.sort(scores);

        String nameList[] = new String[scores.size()];
        for (int i = 0; i < nameList.length; i++) nameList[i] = scores.get(i).getName();

        return nameList;
    }

    public String[] getScoreList() {
        var scores = board.getScoreboard();
        Collections.sort(scores);

        String scoreList[] = new String[scores.size()];
        for (int i = 0; i < scoreList.length; i++)
            scoreList[i] = String.valueOf(scores.get(i).getScore());

        return scoreList;
    }
}
