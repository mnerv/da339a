//
// Author: Pratchaya Khansomboon
//

package Controller;

import javax.swing.*;

public class App {

    static int DEFAULT_MAXGUESTS = 10;

    public static void main(String args[]) {

        int maxGuests = DEFAULT_MAXGUESTS;

        if (args.length > 1 && args[0].equals("-g"))
            try {
                maxGuests = Integer.parseInt(args[1]);
            } catch (Exception e) {
                maxGuests = DEFAULT_MAXGUESTS;
            }
        else {
            String tmp = JOptionPane.showInputDialog("Enter maximum guest");

            try {
                maxGuests = Integer.parseInt(tmp);
            } catch (Exception e) {
                maxGuests = DEFAULT_MAXGUESTS;
                JOptionPane.showMessageDialog(null, "No input. The default will be set to " + DEFAULT_MAXGUESTS);
            }

        }

        Controller c = new Controller(maxGuests);

    }

}
