package Controller;

import View.*;
import Model.*;

/**
 * Author: Pratchaya Khansomboon
 */
public class Controller {
    MainFrame view;
    GuestManager gm;

    public Controller(int maxGuestCount) {
        gm = new GuestManager();

        view = new MainFrame(this);
//        view.updateGuestList(); // TODO: updateGuestList

    }

    public void guestTypeChanged(ButtonType btn) {
        // TODO: guestTypeChanged
    }

    public void guestListIndexChanged(int index) {
        // TODO: guestListIndexChanged
    }


    public void setCountryItem(Object country, int index) {
        // TODO: setCountryItem
    }

    public void buttonPressed(ButtonType btn) {
        // TODO: buttonPressed
        System.out.println("Hello, Pressed: " + btn.name());
    }

    public Countries[] getCountries() {
        return Countries.values();
    }

    private void updateView(int index) {
        // TODO: updateView
    }

    private boolean validateIndex(int index) {
        // TODO: validateIndex
        return false;
    }

//    private Guest getGuestDataFromView() {
//        // TODO: getGuestDataFromView
//    }


}
