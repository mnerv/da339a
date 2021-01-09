package Model;

/**
 * IEntity
 */
public interface IEntity {
    EntityType getType();
    void setType(EntityType type);

    String getName();
    void setName(String name);

    double getPrice();
    void setPrice(double price);
}