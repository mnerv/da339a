/**
 * Author: Pratchaya Khansomboon
 *
 * Created: 2020-11-29
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Order
 *
 * <p>
 * Order contain the product that the user has added and can calculate the total price.
 * </p>
 */
public class Order {
    private List<Entity> productList;
    private List<Integer> quantityList;

    private int id;

    public Order() {
        productList = new ArrayList<Entity>();
        quantityList = new ArrayList<Integer>();
    }

    /**
     * Set oder ID. This is set by the OrderManager
     *
     * @param id The unique ID of the order.
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Get order ID.
     *
     * @return Order ID.
     */
    public int getID() {
        return id;
    }

    /**
     * Add product to the list. This method checks if there is already a product with the same name
     * and increase the quantity value instead of adding it onto the list.
     *
     * @param entity Product that needs to be add.
     * @param quantity The quantity of the product that needs to be added.
     */
    public void addProduct(Entity entity, int quantity) {
        int location = -1;
        boolean inList = false;

        for (int i = 0; i < productList.size(); i++) {
            if (entity.getName().equalsIgnoreCase(productList.get(i).name)) {
                location = i;
                inList = true;
                break;
            }
        }

        if (inList) {
            int q = quantityList.get(location);
            quantityList.set(location, q + q);
        } else {
            productList.add(entity);
            quantityList.add(quantity);
        }
    }

    /**
     * Remove a product in the cart list.
     *
     * @discussion If the quantity is higher than the ones in the cart list the product will be
     * remove from list instead. The algorithm for checking is iterating through the list until it
     * is found, this is slow if the list is big and the data is not in the list or is in the back
     * of the list.
     *
     * @param i Location index in the cart list
     * @param quantity Quantity that should be removed.
     *
     * @return True if successful and False if unsuccessful
     */
    public boolean removeProductAt(int i, int quantity) {
        if (i > -1 && i < productList.size()) {
            if (quantity > quantityList.get(i) - 1) {
                productList.remove(i);
                quantityList.remove(i);
            } else {
                int q = quantityList.get(i) - quantity;
                quantityList.set(i, q);
            }

            return true;
        }

        return false;
    }

    /**
     * Get the product list in order.
     *
     * @return Array of strings.
     */
    public String[] getProductList() {
        String tmpList[] = new String[productList.size()];

        for (int i = 0; i < tmpList.length; i++)
            tmpList[i] =
                productList.get(i).toString() + ", Quantity: " + quantityList.get(i).toString();

        return tmpList;
    }

    /**
     * Check the order if there is any pizza.
     *
     * @return False for none and True for at least one.
     */
    public boolean isTherePizza() {
        boolean s = false;

        for (Entity e : productList) {
            if (e.getType() == EntityType.Food) {
                s = true;
                break;
            }
        }

        return s;
    }

    /**
     * Get the total price of the order.
     *
     * @return Price for the order.
     */
    public double getTotal() {
        double total = 0.0;

        for (int i = 0; i < productList.size(); i++)
            total += productList.get(i).getPrice() * quantityList.get(i);

        return total;
    }

    @Override
    public String toString() {
        return String.format("#%d", id, getTotal());
    }
}