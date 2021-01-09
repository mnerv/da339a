package App;

import Controller.GameController;
import View.*;

/**
 * Battleship Game in Java using Model View Control
 *
 */
public class App {
    public static void main(String[] args) {
        GameController gc = new GameController();

        // if (args.length > 0 && args[0].equalsIgnoreCase("-c")) {
        //     ConsoleView view = new ConsoleView(gc);
        //     gc.setView(view);
        // } else {
        //     // TODO: GUI View
        //     GUIView view = new GUIView();
        //     gc.setView(view);
        // }

        gc.run();
    }
}
