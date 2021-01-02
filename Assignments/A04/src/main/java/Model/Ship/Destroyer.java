package Model.Ship;

/**
 * Destroyer is a type of Ship with its own size.
 */
public class Destroyer extends Ship {
    public Destroyer() {
        super(ShipType.Destroyer, ShipSize.Destroyer);
    }
}
