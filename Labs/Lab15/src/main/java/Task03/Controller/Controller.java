package Task03.Controller;

import Task03.View.*;
import Task03.Model.*;

public class Controller {

    private MainFrame view;
    private Product product;

    public Controller() {
        product = new Product();
        view = new MainFrame(this);
        updateView();
    }

    public void buttonPressed(ButtonType button) {
        switch (button) {
            case Add:
            case Change:
                validateAndSaveProduct();
                break;
            case Delete:
                product = new Product();
                break;
            default:
                break;
        }

        updateView();
    }

    public void setUnitItem(Object unit) {
        if (product != null)
            product.setUnit((UnitType) unit);
    }

    public UnitType[] getUnitItems() {
        return UnitType.values();
    }

    private void validateAndSaveProduct() {
        String name = view.getNameText();
        String strPrice = view.getPriceText();
        String strCount = view.getCount();

        if (name != null && !name.isEmpty())
            product.setName(name);
        else
            view.errMessage("Give a valid name");

        try {
            product.setPrice(Double.parseDouble(strPrice));
        } catch (NumberFormatException e) {
            view.errMessage("Invalid price or count!");
        }

        try {
            product.setCount(Integer.parseInt(strCount));
        } catch (NumberFormatException e) {
            view.errMessage("Invalid quantity");
        }

        product.setProductType(view.getProductType());
    }

    private void updateView() {
        view.showProductInfo(product.toString());
        view.setProductType(product.getProductType());
    }

}
