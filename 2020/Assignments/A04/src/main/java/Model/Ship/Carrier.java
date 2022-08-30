package Model.Ship;

/**
 * Carrier is a type of Ship with its own size.
 */
public class Carrier extends Ship {
    public Carrier() {
        super(ShipType.Carrier, ShipSize.Carrier);
    }
}
