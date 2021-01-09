package View;

import Controller.Controller;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class MainView extends Application {
    final String TITLE = "Assignment 03";
    final int WIDTH = 900, HEIGHT = 600;

    private Stage primary;
    private Scene scene;
    private Controller c;

    private OrderView orderView;
    private CustomView customView;

    @Override
    public void start(Stage stage) throws Exception {
        primary = stage;
        c = new Controller(this);

        orderView = new OrderView(this);
        customView = new CustomView(this);
        // orderScene = new Scene(orderView.getRoot(), WIDTH, HEIGHT);
        scene = new Scene(orderView.getRoot(), WIDTH, HEIGHT);
        // customScene = new Scene(customView.getRoot(), WIDTH, HEIGHT);

        showOrderView();

        stage.setScene(scene);
        stage.setTitle(TITLE);
        stage.show();
    }

    String[] getPizzaList() {
        return c.getPizzaList();
    }

    String[] getBeverageList() {
        return c.getBeverageList();
    }

    String[] getDetailList() {
        return c.getDetailList();
    }

    String[] getOrderList() {
        return c.getOrderList();
    }

    String[] getToppingList() {
        return c.getToppingList();
    }

    String[] getAddedToppingList() {
        return c.getAddedToppingList();
    }

    void setIsOver18(boolean tof) {
        c.setOver18(tof);
    }

    String getDetailTotal() {
        return c.getTotal();
    }

    String getOrderDetail(int i) {
        c.setSelectOrder(i);
        return c.getSelectedOrderDetail();
    }

    int getOrderID() {
        return c.getSelectedOrderID();
    }

    void addProduct(int i, int quantity) {
        c.addProduct(i, quantity);
    }

    boolean addTopping(int i) {
        return c.addTopping(i);
    }

    void removeToppingAt(int i) {
        c.removeToppingAt(i);
    }

    void removeProductAt(int i, int quantity) {
        c.removeProductAt(i, quantity);
    }

    boolean checkout() {
        return c.checkout();
    }

    void saveCustomPizza() {
        c.saveCustomPizza();
    }

    void showOrderView() {
        scene.setRoot(orderView.getRoot());
        orderView.updateProductList(getPizzaList());
    }

    void showCustomView() {
        String input = inputDialog("Custom Pizza name", "Name:", "Custom");
        c.newCustomPizza(input);
        scene.setRoot(customView.getRoot());
    }

    void infoMessage(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(primary);
        alert.showAndWait();
    }

    String inputDialog(String title, String label) {
        return inputDialog(title, label, "1");
    }

    String inputDialog(String title, String label, String value) {
        TextInputDialog dialog = new TextInputDialog(value);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(label);
        dialog.initOwner(primary);

        Optional<String> r = dialog.showAndWait();
        return r.isPresent() ? r.get() : null;
    }
}