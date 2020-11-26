package Task03.Controller;

import Task03.View.*;
import Task03.Model.*;

public class Controller {

    MainFrame view;
    Product product;

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

    void validateAndSaveProduct() {
        String name = view.getNameText();
        String strPrice = view.getPriceText();

        if (name != null && !name.isEmpty())
            product.setName(name);
        else
            view.errMessage("Give a valid name");

        try {
            product.setPrice(Double.parseDouble(strPrice));
        } catch (NumberFormatException e) {
            view.errMessage("Invalid price or count!");
        }

    }

    void updateView() {
        view.showProductInfo(product.toString());
    }

}
