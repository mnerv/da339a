package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Order
 */
public class Order {
    private List<Entity> productList;
    private List<Integer> quantityList;

    int id;

    public Order() {
        productList = new ArrayList<Entity>();
        quantityList = new ArrayList<Integer>();
    }

    public int getID() {
        return id;
    }

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

    public String[] getProductList() {
        String tmpList[] = new String[productList.size()];

        for (int i = 0; i < tmpList.length; i++)
            tmpList[i] =
                productList.get(i).toString() + ", Quantity: " + quantityList.get(i).toString();

        return tmpList;
    }

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

    @Override
    public String toString() {
        return String.format("#%d", id, getTotal());
    }

    public double getTotal() {
        double total = 0.0;

        for (int i = 0; i < productList.size(); i++)
            total += productList.get(i).getPrice() * quantityList.get(i);

        return total;
    }
}