/**
 * Author: Pratchaya Khansomboon
 *
 * Created: 2020-12-10
 */
package Model;

import java.util.Locale;

/**
 * Entity
 *
 * <p>
 * Name, type and price. This is the super class of all the product available.
 * </p>
 */
public abstract class Entity implements IEntity {
    protected final Locale LOCALE = new Locale("en", "UK");

    protected String name;
    protected EntityType type;

    protected double price;

    private int id;

    @Override
    public EntityType getType() {
        return type;
    }

    @Override
    public void setType(EntityType type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    /**
     * Unique information for Entity subclass
     */
    public abstract String getInfo();
}