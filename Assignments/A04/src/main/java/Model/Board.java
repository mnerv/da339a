package Model;

import Model.Ship.*;

public class Board {

  Ship data[];

  public Board(int size) {
    data = new Ship[size * size];
  }

}
