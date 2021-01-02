package Model.Ship;

/**
 * Submarine is a type of Ship with its own size.
 */
public class Submarine extends Ship {
    public Submarine() {
        super(ShipType.Submarine, ShipSize.Submarine);
    }
}
