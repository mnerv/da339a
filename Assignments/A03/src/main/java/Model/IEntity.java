/**
 * Author: Pratchaya Khansomboon
 *
 * Created: 2021-01-02
 */
package Model;

/**
 * IEntity
 *
 * <p>
 * Required method for Entity type object
 * </p>
 */
public interface IEntity {
    EntityType getType();
    void setType(EntityType type);

    String getName();
    void setName(String name);

    double getPrice();
    void setPrice(double price);
}