package View;

/**
 * View is the base class for all the main view.
 *
 * <p>
 * This class is used for other class to derive from and change its functionality such as getting
 * input and drawing to the screen.
 * </p>
 */
public abstract class View {
    /**
     * Call once to start the program
     */
    public abstract void run();

    /**
     * Calls everytime anything is updated
     */
    public abstract void update();
}
