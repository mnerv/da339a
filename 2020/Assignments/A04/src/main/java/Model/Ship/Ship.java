package Model.Ship;

/**
 * Ship is the base class for all other type of ships.
 */
public abstract class Ship {
    protected final ShipType type;
    protected final int size;
    protected int hp;
    protected int id;

    public Ship(ShipType type, int size) {
        this.type = type;
        this.size = size;
        this.id = type.ordinal();

        hp = size;
    }

    /**
     * Decrement the ship's HP
     */
    public void hit() {
        if (hp > 0)
            hp--;
    }

    /**
     * Check if the ship is destroyed
     *
     * @return True: Ship is destroyed, False: Ships is alive
     */
    public boolean isDead() {
        return hp == 0;
    }

    /**
     * Get Ship type
     *
     * @return Ship Type
     */
    public ShipType getType() {
        return type;
    }

    /**
     * Get Ship size. This depends on what type the ship it is.
     *
     * @return Ship size
     */
    public int getSize() {
        return size;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return type.toString();
    }
}
