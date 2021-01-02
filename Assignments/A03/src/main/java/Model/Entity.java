package Model;

public abstract class Entity implements IEntity {
    protected String name;
    protected EntityType type;

    protected double price;

    public Entity() {
        name = "n/a";
        price = 0;
    }

    @Override
    public EntityType getType() {
        return type;
    }

    @Override
    public void setType(EntityType type) {
        this.type = type;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getInfo();
}
