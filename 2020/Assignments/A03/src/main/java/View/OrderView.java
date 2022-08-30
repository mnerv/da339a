/**
 * Author: Pratchaya Khansomboon
 *
 * Created: 2021-01-09
 */
package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class OrderView {
    private GridPane root;
    private MainView view;

    ListView<String> productList;
    ListView<String> detailList;
    ListView<String> orderList;

    VBox detailsContainer;
    Label totalLbl, productLbl;

    String drinksTxt = "Drinks", pizzaTxt = "Pizza";
    Button switchProductBtn;
    CheckBox over18Cb;

    public OrderView(MainView view) {
        this.view = view;

        root = new GridPane();
        root.setPadding(new Insets(10));
        // root.setGridLinesVisible(true);

        var titleFont = new Font("Arial", 16);

        // Add the header text
        var productsHBox = new HBox();
        productLbl = new Label(pizzaTxt);

        var productBtnHBox = new HBox();
        switchProductBtn = new Button(drinksTxt);
        switchProductBtn.setOnAction(e -> onSwitchProductBtn());
        over18Cb = new CheckBox("18+");
        over18Cb.setOnAction(e -> onOver18());
        productBtnHBox.setAlignment(Pos.CENTER_RIGHT);
        productBtnHBox.setSpacing(10);
        productBtnHBox.getChildren().addAll(switchProductBtn, over18Cb);

        productLbl.setFont(titleFont);

        productsHBox.setSpacing(10);
        productsHBox.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(productLbl, Priority.ALWAYS);
        HBox.setHgrow(productBtnHBox, Priority.ALWAYS);
        productLbl.setMaxWidth(Double.MAX_VALUE);
        productBtnHBox.setMaxWidth(Double.MAX_VALUE);
        productsHBox.getChildren().addAll(productLbl, productBtnHBox);
        // productsHBox.setBackground(new Background(
        //     new BackgroundFill(Color.web("#222222"), CornerRadii.EMPTY, Insets.EMPTY)));

        root.add(productsHBox, 0, 0);

        var lblDetail = new Label("Order details");
        lblDetail.setFont(titleFont);
        root.add(lblDetail, 1, 0);

        var lblOrders = new Label("Orders");
        lblOrders.setFont(titleFont);
        root.add(lblOrders, 2, 0);

        // Items list column
        productList = new ListView<>();
        productList.getItems().addAll(view.getPizzaList());
        productList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        root.add(productList, 0, 1);

        // Order detail column
        detailsContainer = new VBox();
        detailsContainer.setSpacing(10);
        detailsContainer.setAlignment(Pos.TOP_LEFT);
        detailsContainer.setPadding(new Insets(0, 0, 5, 0));
        detailList = new ListView<>();
        detailList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        totalLbl = new Label("Total: 0.00 kr");
        VBox.setVgrow(detailList, Priority.ALWAYS);
        detailsContainer.getChildren().addAll(detailList, totalLbl);
        detailsContainer.setFillWidth(true);

        root.add(detailsContainer, 1, 1);

        // Order list column
        orderList = new ListView<>();
        orderList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        root.add(orderList, 2, 1);

        var bottomHBox = new HBox();
        bottomHBox.setSpacing(10);
        bottomHBox.setAlignment(Pos.CENTER);
        root.add(bottomHBox, 0, 2, 3, 2);

        var customBtn = new Button("Custom");
        customBtn.setOnAction(e -> onCustomBtn());
        var addBtn = new Button("Add");
        addBtn.setOnAction(e -> onAddBtn());
        var removeBtn = new Button("Remove");
        removeBtn.setOnAction(e -> onRemoveBtn());
        var checkoutBtn = new Button("Checkout");
        checkoutBtn.setOnAction(e -> onCheckoutBtn());
        var viewOrderBtn = new Button("View Order");
        viewOrderBtn.setOnAction(e -> onViewOrderBtn());

        // var btnRemoveAll = new Button("Remove");
        // btnRemoveAll.setOnAction(e -> onRemoveAllBtn());

        bottomHBox.getChildren().addAll(customBtn, addBtn, removeBtn, checkoutBtn, viewOrderBtn);

        // Set Column and Row gap
        root.setHgap(10);
        root.setVgap(5);

        // Column constraints
        var col1 = new ColumnConstraints();
        var col2 = new ColumnConstraints();
        var col3 = new ColumnConstraints();

        root.getColumnConstraints().add(col1);
        root.getColumnConstraints().add(col2);
        root.getColumnConstraints().add(col3);

        col1.setPercentWidth(50);
        col2.setPercentWidth(40);
        col3.setPercentWidth(10);

        // Row constraints
        var row1 = new RowConstraints();
        var row2 = new RowConstraints();
        var row3 = new RowConstraints();

        root.getRowConstraints().add(row1);
        root.getRowConstraints().add(row2);
        root.getRowConstraints().add(row3);

        row1.setPrefHeight(21);
        row2.setVgrow(Priority.ALWAYS);
        row3.setPrefHeight(64);
    }

    void setTotal(String value) {
        totalLbl.setText("Total: " + value);
    }

    void updateProductList(String list[]) {
        productList.getItems().setAll(list);
    }

    void updateDetailList(String list[]) {
        detailList.getItems().setAll(list);
    }

    Pane getRoot() {
        return root;
    }

    private void updateDetailView() {
        detailList.getItems().setAll(view.getDetailList());
        setTotal(view.getDetailTotal());
    }

    private void onSwitchProductBtn() {
        if (productLbl.getText().equalsIgnoreCase(pizzaTxt)) {
            switchProductBtn.setText(pizzaTxt);
            productLbl.setText(drinksTxt);

            productList.getItems().setAll(view.getBeverageList());
        } else {
            switchProductBtn.setText(drinksTxt);
            productLbl.setText(pizzaTxt);

            productList.getItems().setAll(view.getPizzaList());
        }
    }

    private void onOver18() {
        view.setIsOver18(over18Cb.isSelected());
        if (productLbl.getText().equalsIgnoreCase(drinksTxt))
            updateProductList(view.getBeverageList());
    }

    private void onCustomBtn() {
        view.showCustomView();
    }

    private void onAddBtn() {
        int i = productList.getSelectionModel().getSelectedIndex();
        int q = -1;

        while (q < 0) {
            String input = view.inputDialog("Quantity to add", "Quantity:");
            if (input == null)
                break;

            try {
                q = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                q = -1;
            }
        }

        if (q > 0 && i > -1)
            view.addProduct(i, q);

        updateDetailView();
    }

    private void onRemoveBtn() {
        int i = detailList.getSelectionModel().getSelectedIndex();
        int q = -1;

        while (q < 0) {
            String input = view.inputDialog("Quantity to remove", "Quantity:");
            if (input == null)
                break;

            try {
                q = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                q = -1;
            }
        }

        if (q > 0 && i > -1)
            view.removeProductAt(i, q);

        updateDetailView();
    }

    private void onRemoveAllBtn() {
        System.out.println("Remove all");
    }

    private void onCheckoutBtn() {
        view.checkout();

        orderList.getItems().setAll(view.getOrderList());
        updateDetailView();
    }

    private void onViewOrderBtn() {
        int i = orderList.getSelectionModel().getSelectedIndex();

        if (i > -1) {
            String m = view.getOrderDetail(i);
            int id = view.getOrderID();

            view.infoMessage("Order detail: #" + id, m);
        }
    }
}
