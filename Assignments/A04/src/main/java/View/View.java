package View;

import Controller.GameController;

/**
 * View is the base class for all the main view.
 *
 * <p>
 * This class is used for other class to derive from and change its functionality such as getting
 * input and drawing to the screen.
 * </p>
 */
public abstract class View {
    protected String title;
    protected GameController controller;
    protected int row, col;

    /**
     * Call once to start the program
     */
    public abstract void run();

    /**
     * Calls everytime anything is updated
     */
    public abstract void update();

    /**
     * Initial the grid in the view
     */
    public abstract void initGrid();

    /**
     * Get confirmation message
     *
     * @param title The title of the message
     * @param message The message content
     *
     * @return True for confirm and False for deny
     */
    public abstract boolean confirmMessage(String title, String message);

    /**
     * Display information message
     *
     * @param title The title of the message
     * @param message The message contente
     */
    public abstract void infoMessage(String title, String message);

    /**
     * Display error message
     *
     * @param title The title of the message
     * @param message The message contente
     */
    public abstract void errMessage(String title, String message);

    /**
     * Get input
     *
     * @param title The title of the message
     * @param message The message contente
     *
     * @return The input frm the user
     */
    public abstract String inputDialog(String title, String label);

    /**
     * Show the scoreboard
     */
    public abstract void showScoreBoard();

    /**
     * Disable the grid input
     */
    public abstract void disableGrid();

    public void setGridSize(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setController(GameController c) {
        controller = c;
    }
}
