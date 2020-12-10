package Model;

public abstract class Entity {
  String name;
  EntityType type;

  int price;

  public Entity() {
    name = "n/a";
    price = 0;
  }

  public void setType(EntityType type) {
    this.type = type;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public EntityType getType() {
    return type;
  }

}
