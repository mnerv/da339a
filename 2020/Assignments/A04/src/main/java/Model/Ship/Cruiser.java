package Model.Ship;

/**
 * Cruiser is a type of Ship with its own size.
 */
public class Cruiser extends Ship {
    public Cruiser() {
        super(ShipType.Cruiser, ShipSize.Cruiser);
    }
}
