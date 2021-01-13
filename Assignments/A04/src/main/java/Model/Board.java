package Model;

import Model.Ship.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Board stores the board data of where the ship is positioned.
 *
 * <p>
 * The board manage the data and handle the logic to check if there's a hit on the ship.
 * </p>
 */
public class Board {
    private Ship data[];
    private final int maxShips;

    private int shipCount;

    private int size;
    private Random rng;

    private int shotCount = 0;

    private List<Score> scoreboard;

    public Board(int size) {
        this.size = size;

        data = new Ship[size * size];
        maxShips = ShipType.values().length;
        shipCount = maxShips;

        scoreboard = new ArrayList<>();

        rng = new Random();
    }

    public boolean shoot(int row, int col) {
        return shoot(row * size + col);
    }

    public boolean shoot(int i) {
        var s = data[i];
        shotCount++;

        if (s != null) {
            s.hit();

            if (s.isDead())
                shipCount--;

            return true;
        }

        return false;
    }

    /**
     * Init the board with raw data with id for different ships
     *
     * @param rawData The size should be the same as the boards area
     */
    public void initData(int rawData[]) {
        Ship ships[] = {
            new Carrier(),
            new Battleship(),
            new Cruiser(),
            new Submarine(),
            new Destroyer(),
        };

        for (int i = 0; i < rawData.length; i++) {
            if (rawData[i] != 0)
                data[i] = ships[rawData[i] - 1];
            else
                data[i] = null;
        }
    }

    public Ship getData(int row, int col) {
        return getData(row * size + col);
    }

    public Ship getData(int i) {
        return data[i];
    }

    public void setData(int row, int col, Ship ship) {
        data[row * size + col] = ship;
    }

    public boolean isCompleted() {
        return shipCount == 0;
    }

    public void reset() {
        data = new Ship[size * size];
        shipCount = maxShips;
        shotCount = 0;
    }

    /**
     * Place a ship onto the board.
     *
     * @discussion The method check first if it's a valid position, i.e check for overlap between
     * different ships and if it's outside or not.
     *
     * @param row Col index on the grid
     * @param col Row index on the grid
     * @param ship The ship that needs to be place
     *
     * @return True: Valid placement, False: Invalid placement
     */
    public boolean placeShip(int row, int col, Ship ship) {
        boolean status = false;

        // TODO: Check for overlapping when placing ships

        return status;
    }

    public void addScore(Score score) {
        score.setScore(shotCount);
        scoreboard.add(score);
        shotCount = 0;
    }

    public List<Score> getScoreboard() {
        return scoreboard;
    }

    public int getScoreboardSize() {
        return scoreboard.size();
    }

    /**
     * Randomly place the ships onto the board.
     *
     * <p>
     * The algorithm implemented is not efficient, because it doesn't take into account
     * which spaces are left.
     * </p>
     */
    private void randomPlacement() {
        Ship current = null;
        int i = maxShips - 1;

        while (i > -1) {
            int r = rng.nextInt(size);
            int c = rng.nextInt(size);

            switch (ShipType.values()[i]) {
                case Carrier:
                    current = new Carrier();
                    break;
                case Battleship:
                    current = new Battleship();
                    break;
                case Cruiser:
                    current = new Cruiser();
                    break;
                case Submarine:
                    current = new Submarine();
                    break;
                case Destroyer:
                    current = new Destroyer();
                    break;
            }

            if (placeShip(r, c, current))
                i--;
        }
    }
}
