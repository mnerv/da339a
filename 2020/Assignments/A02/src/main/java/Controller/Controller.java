//
// Author: Pratchaya Khansomboon
//

package Controller;

import View.*;
import Model.*;

/**
 * Controller act as an interface between the model and view.
 */
public class Controller {
    MainFrame view;
    GuestManager gm;

    public Controller(int maxGuests) {
        this(maxGuests, false);
    }

    public Controller(int maxGuests, boolean mockdata) {
        gm = new GuestManager(maxGuests, mockdata);

        view = new MainFrame(this);
        view.updateGuestList(gm.getGuestList());

        view.setNumGuest(String.valueOf(gm.getGuestCount()));
    }

    /**
     * Called in EastPanelGuestList in valueChanged method from list whenever the
     * item in list is selected
     *
     * @param index Selected item index in the list.
     */
    public void guestListIndexChanged(int index) {
        updateView(index);
    }

    public void setCountryItem(Object country, int index) {
        // TODO: setCountryItem
    }

    /**
     * This is registered on all 3 buttons listener. The button type is passed in
     * when it is called.
     *
     * @param btn ButtonType
     */
    public void buttonPressed(ButtonType btn) {
        Guest guest;

        int index = 0;

        switch (btn) {
            case Add:
                guest = getGuestDataFromView();
                if (!gm.addGuest(guest))
                    view.errMessage("Guest list is full, max is " + gm.getMaxGuests());
                break;
            case Change:
                index = view.getListIndex();
                if (validateIndex(index)) {
                    guest = getGuestDataFromView();
                    gm.setGuestAt(index, guest);
                }
                break;
            case Delete:
                index = view.getListIndex();
                if (validateIndex(index))
                    gm.deleteAt(index);
                break;
            default:
                break;
        }

        view.setNumGuest(Integer.toString(gm.getGuestCount()));
        view.updateGuestList(gm.getGuestList());
    }

    public Countries[] getCountries() {
        return Countries.values();
    }

    private void updateView(int index) {
        Guest guest = gm.getGuestAt(index);

        if (guest == null)
            return;

        view.setNumGuest(Integer.toString(gm.getGuestCount()));

        view.setFirstNameText(guest.getFirstname());
        view.setLastNameText(guest.getLastname());
        view.setStreetText(guest.getAddress().getStreet());
        view.setCityText(guest.getAddress().getCity());
        view.setZipCodeText(guest.getAddress().getZipcode());
        view.setSelectedCountry(guest.getAddress().getCountry());

    }

    /**
     * Check if the selected list index is inside the list
     * 
     * @param index Selected list index
     * @return True if it is inside
     */
    private boolean validateIndex(int index) {
        return index > -1 && index < gm.getGuestCount();
    }

    /**
     * Get input data from the input fields
     * 
     * @return Guest or null, if some field are empty it'll return null
     */
    private Guest getGuestDataFromView() {
        Guest guest = new Guest();
        String firstName = view.getFirstNameText();
        String lastName = view.getLastNameText();
        String street = view.getStreetText();
        String city = view.getCityText();
        String zipCode = view.getZipCodeText();

        Countries country = (Countries) view.getSelectedCountry();

        if (firstName != null && !firstName.isEmpty())
            guest.setFirstName(firstName);
        else {
            view.errMessage("First name is empty");
            return null;
        }

        if (lastName != null && !lastName.isEmpty())
            guest.setLastName(lastName);
        else {
            view.errMessage("Last name is empty");
            return null;
        }

        try {
            guest.setAddress(new Address(street, city, zipCode, country));
        } catch (Exception e) {
            view.errMessage("The address is empty");
            return null;
        }

        return guest;
    }

}
