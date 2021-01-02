package Model;

import Model.Ship.*;

/**
 * Board stores the board data of where the ship is positioned.
 *
 * <p>
 * The board manage the data and handle the logic to check if there's a hit on the ship.
 * </p>
 */
public class Board {
    Ship data[];

    public Board(int size) {
        data = new Ship[size * size];
    }
}
