package Model.Ship;

/**
 * Battleship is a type of Ship with its own size.
 */
public class Battleship extends Ship {
    public Battleship() {
        super(ShipType.Battleship, ShipSize.Battleship);
    }
}