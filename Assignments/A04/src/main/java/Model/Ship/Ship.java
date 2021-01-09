package Model.Ship;

/**
 * Ship is the base class for all other type of ships.
 */
public abstract class Ship {
    protected final ShipType type;
    protected final int size;
    protected int hp;
    protected boolean isDestroyed = false;

    // Ship's origin
    private int row, col;
    private int direction = 0; // 0 Vertical, 1 Horizontal

    public Ship(ShipType type, int size) {
        this.type = type;
        this.size = size;

        hp = size;
    }

    /**
     * Decrement the ship's HP
     */
    public void hit() {
        if (hp > 0 && !isDestroyed)
            hp--;
        else
            isDestroyed = true;
    }

    /**
     * Check if the ship is destroyed
     *
     * @return True: Ship is destroyed, False: Ships is alive
     */
    public boolean getIsDestroyed() {
        return isDestroyed;
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

    public void setOrigin(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
