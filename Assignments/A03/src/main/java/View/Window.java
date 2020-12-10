package View;

import Controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Window extends Application {
  final String TITLE = "Assignment 03";

  Stage primary;
  Scene mainScene;

  Controller c;

  ListView<String> productList;
  ListView<String> detailList;
  ListView<String> orderList;

  @Override
  public void start(Stage stage) throws Exception {
    primary = stage;
    c = new Controller(this);

    var grid = new GridPane();
    grid.setPadding(new Insets(10));
    // grid.setGridLinesVisible(true);

    var titleFont = new Font("Arial", 16);

    var lblPizzas = new Label("Pizzas");
    lblPizzas.setFont(titleFont);
    grid.add(lblPizzas, 0, 0);

    var lblDetail = new Label("Order details");
    lblDetail.setFont(titleFont);
    grid.add(lblDetail, 1, 0);

    var lblOrders = new Label("Orders");
    lblOrders.setFont(titleFont);
    grid.add(lblOrders, 2, 0);

    productList = new ListView<>();
    productList.getItems().addAll("Hello, World!", "Charlie", "SpaceX", "We are here");
    productList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    grid.add(productList, 0, 1);

    var detailVBox = new VBox();
    detailVBox.setSpacing(10);
    detailVBox.setAlignment(Pos.CENTER_LEFT);
    detailVBox.setPadding(new Insets(0, 0, 5, 0));
    detailList = new ListView<>();
    detailList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    var lblTotal = new Label("Total: 0.00 kr");
    detailVBox.getChildren().addAll(detailList, lblTotal);
    grid.add(detailVBox, 1, 1);

    orderList = new ListView<>();
    orderList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    grid.add(orderList, 2, 1);

    var bottomHBox = new HBox();
    bottomHBox.setSpacing(10);
    bottomHBox.setAlignment(Pos.CENTER);
    grid.add(bottomHBox, 0, 2, 3, 2);

    var btnAdd = new Button("Add");
    var btnRemove = new Button("Remove");
    bottomHBox.getChildren().addAll(btnAdd, btnRemove);

    // Set Column and Row gap
    grid.setHgap(10);
    grid.setVgap(5);

    // Column constraints
    var col1 = new ColumnConstraints();
    var col2 = new ColumnConstraints();
    var col3 = new ColumnConstraints();

    grid.getColumnConstraints().add(col1);
    grid.getColumnConstraints().add(col2);
    grid.getColumnConstraints().add(col3);

    col1.setPercentWidth(50);
    col2.setPercentWidth(40);
    col3.setPercentWidth(10);

    // Row constraints
    var row1 = new RowConstraints();
    var row2 = new RowConstraints();
    var row3 = new RowConstraints();

    grid.getRowConstraints().add(row1);
    grid.getRowConstraints().add(row2);
    grid.getRowConstraints().add(row3);

    row1.setPrefHeight(21);
    row2.setVgrow(Priority.ALWAYS);
    row3.setPrefHeight(64);

    // Add layout to the scene
    mainScene = new Scene(grid, 640, 480);
    mainScene.getStylesheets().add("main.css");
    stage.setScene(mainScene);

    stage.setTitle(TITLE);
    stage.show();
  }

}