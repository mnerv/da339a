package Model;

import Model.Ship.*;
import java.util.Random;

/**
 * Board stores the board data of where the ship is positioned.
 *
 * <p>
 * The board manage the data and handle the logic to check if there's a hit on the ship.
 * </p>
 */
public class Board {
    public Ship data[];
    int maxShips;

    int size;
    Random rng;

    public Board(int size) {
        this.size = size;

        data = new Ship[size * size];
        maxShips = ShipType.values().length;

        rng = new Random();
        // randomPlacement();
        Carrier c = new Carrier();
        placeShip(0, 4, c);
    }

    private Ship getData(int row, int col) {
        return data[row * size + col];
    }

    private void setData(int row, int col, Ship ship) {
        data[row * size + col] = ship;
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
    private boolean placeShip(int row, int col, Ship ship) {
        boolean status = false;

        if (getData(row, col) == null) {
            ship.setOrigin(row, col);
            // Magic number, will need to be refactor
            int dirX = 1, dirY = 0; // Direction
            boolean validRow = false, validCol = false;
            int len = ship.getSize();

            // TODO: Make it so the origin is dynamic instead.
            for (int i = 0; i < ship.getSize(); i++) {
            }
        }

        return status;
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
