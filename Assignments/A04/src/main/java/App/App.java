package App;

import Controller.GameController;
import View.*;

/**
 * Battleship Game in Java using Model View Control
 *
 */
public class App {
    public static void main(String[] args) {
        GUIView v = new GUIView();
        GameController gc = new GameController(v);
        gc.run();
    }
}
