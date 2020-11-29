package View;

import Controller.Controller;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Window extends Application {

  Stage primary;
  Scene mainScene;

  Controller c;

  @Override
  public void start(Stage stage) throws Exception {
    primary = stage;

    c = new Controller(this);

    var label = new Label("Hello, JavaFX");
    label.setFont(new Font("Arial", 64));
    var button = new Button();
    button.setMinWidth(80);
    button.setText("Click me!");
    button.setOnAction(e -> {
      Alert a = new Alert(AlertType.WARNING);
      a.setTitle("Info");
      a.setHeaderText(null);
      a.setContentText("F");
      a.showAndWait();

    });

    var layout = new VBox(10);
    layout.setAlignment(Pos.BASELINE_CENTER);
    layout.getChildren().addAll(label, button);

    mainScene = new Scene(layout, 640, 480);
    mainScene.getStylesheets().add("main.css");
    stage.setScene(mainScene);

    System.out.printf("Arguments: %s\n", getParameters().getUnnamed());

    stage.setTitle("Assignment 03");
    stage.show();
  }

}