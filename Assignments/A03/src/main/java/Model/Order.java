package Model;

import java.util.ArrayList;
import java.util.List;

public class Order {
  List<Entity> entities;
  long id;

  private static long idIndex = 0;

  public Order() {
    entities = new ArrayList<Entity>();

    id = idIndex;
  }

  public long getID() {
    return id;
  }

}
