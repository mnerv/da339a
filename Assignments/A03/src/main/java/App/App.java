package App;

import javafx.application.Application;

import View.Window;

/**
 * Assignment 03
 */
public class App {

  public static void main(String[] args) {
    boolean nogui = false;

    if (args.length > 0) {
      nogui = args[0].equals("-nogui");
    }

    if (!nogui)
      Application.launch(Window.class, args);
    else {
      System.out.println("no gui");
    }

  }

}