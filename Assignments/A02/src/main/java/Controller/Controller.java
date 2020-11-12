package Controller;

import View.*;
import Model.*;

/**
 * Author: Pratchaya Khansomboon
 */
public class Controller {
    MainFrame view;
    GuestManager gm;

    public Controller(int maxGuests) {
        gm = new GuestManager(maxGuests, true);

        view = new MainFrame(this);
        view.updateGuestList(gm.getGuestList()); // TODO: updateGuestList

        view.setNumGuest(String.valueOf(gm.getGuestCount()));
    }

    public void guestTypeChanged(ButtonType btn) {
        // TODO: guestTypeChanged
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
        System.out.println("Hello, setCountryItem " + country.toString() + ", i: " + index);
        // TODO: setCountryItem
    }

    public void buttonPressed(ButtonType btn) {
        switch (btn) {
            case Add:
                break;
            case Change:
                break;
            case Delete:
                break;
            default:
                break;
        }

        System.out.println("Hello, Pressed: " + btn.name());
    }

    public Countries[] getCountries() {
        return Countries.values();
    }

    private void updateView(int index) {
        // TODO: updateView
        Guest guest = gm.getGuestAt(index);
        if (guest == null)
            return;

        view.setNumGuest(String.valueOf(gm.getGuestCount()));

        view.setFirstNameText(guest.getFirstname());
        view.setLastNameText(guest.getLastname());
        view.setStreetText(guest.getAddress().getStreet());
        view.setCityText(guest.getAddress().getCity());
        view.setZipCodeText(guest.getAddress().getZipcode());
        view.setSelectedCountry(guest.getAddress().getCountry());

    }

    private boolean validateIndex(int index) {
        // TODO: validateIndex
        return false;
    }

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
        else
            view.errMessage("Name is empty");

        try {
            guest.setLastName(lastName);
            guest.setAddress(new Address(street, city, zipCode, country));
        } catch (Exception e) {
            view.errMessage("Invalid values");

            return null;
        }

        return guest;
    }

}
