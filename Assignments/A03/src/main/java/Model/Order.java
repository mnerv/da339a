package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Order
 */
public class Order {
    List<Entity> productList;
    long id;

    public Order() {
        productList = new ArrayList<Entity>();
    }

    public long getID() {
        return id;
    }

    public void addProduct(Entity product) {
        productList.add(product);
    }

    public boolean removeProductAt(int i) {
        if (i > -1 && i < productList.size()) {
            productList.remove(i);
            return true;
        }

        return false;
    }

    public String[] getProductList() {
        String tmpList[] = new String[productList.size()];
        for (int i = 0; i < tmpList.length; i++) tmpList[i] = productList.get(i).toString();

        return tmpList;
    }

    @Override
    public String toString() {
        return String.format("#%d", id);
    }
}