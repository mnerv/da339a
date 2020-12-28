package Model.Ship;

public abstract class Ship {
  protected ShipType type;
  protected int size;

  public ShipType getType() {
    return type;
  }

  public int getSize() {
    return size;
  }

}
