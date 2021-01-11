/**
 * Author: Pratchaya Khansomboon
 *
 * Created: 2021-01-09
 */
package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class CustomView {
    private GridPane root;
    private MainView view;

    private ListView<String> toppingList;
    private ListView<String> customPizzaList;

    public CustomView(MainView view) {
        this.view = view;

        root = new GridPane();
        root.setPadding(new Insets(10));

        var titleFont = new Font("Arial", 16);

        // Add the header text
        var productsHBox = new HBox();
        var lblPizzas = new Label("Toppings");

        lblPizzas.setFont(titleFont);
        productsHBox.setSpacing(100);
        productsHBox.getChildren().addAll(lblPizzas);

        root.add(productsHBox, 0, 0);

        var lblDetail = new Label("Custom Pizza");
        lblDetail.setFont(titleFont);
        root.add(lblDetail, 1, 0);

        // Items list column
        toppingList = new ListView<>();
        toppingList.getItems().addAll(view.getToppingList());
        toppingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        root.add(toppingList, 0, 1);

        // Order detail column

        customPizzaList = new ListView<>();
        customPizzaList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        root.add(customPizzaList, 1, 1);

        // Order list column
        var bottomHBox = new HBox();
        bottomHBox.setSpacing(10);
        bottomHBox.setAlignment(Pos.CENTER);
        root.add(bottomHBox, 0, 2, 2, 2);

        var addBtn = new Button("Add");
        addBtn.setOnAction(e -> onAddBtn());
        var removeBtn = new Button("Remove");
        removeBtn.setOnAction(e -> onRemoveBtn());
        var doneBtn = new Button("Done");
        doneBtn.setOnAction(e -> onDoneBtn());

        bottomHBox.getChildren().addAll(doneBtn, addBtn, removeBtn);

        // Set Column and Row gap
        root.setHgap(10);
        root.setVgap(5);

        // Column constraints
        var col1 = new ColumnConstraints();
        var col2 = new ColumnConstraints();

        root.getColumnConstraints().add(col1);
        root.getColumnConstraints().add(col2);

        col1.setPercentWidth(50);
        col2.setPercentWidth(50);

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

    public Pane getRoot() {
        return root;
    }

    private void updateLists() {
        customPizzaList.getItems().setAll(view.getAddedToppingList());
    }

    private void onAddBtn() {
        int i = toppingList.getSelectionModel().getSelectedIndex();

        if (i > -1) {
            view.addTopping(i);
            updateLists();
        }
    }

    private void onRemoveBtn() {
        int i = customPizzaList.getSelectionModel().getSelectedIndex();

        if (i > -1) {
            view.removeToppingAt(i);
            updateLists();
        }
    }

    private void onDoneBtn() {
        view.saveCustomPizza();
        view.showOrderView();
    }
}
