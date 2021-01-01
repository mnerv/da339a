package Model.Ship;

public abstract class Ship {
  protected final ShipType type;
  protected final int size;
  protected int hp;

  public Ship(ShipType type, int size) {
    this.type = type;
    this.size = size;
  }

  public ShipType getType() {
    return type;
  }

  public int getSize() {
    return size;
  }

}
