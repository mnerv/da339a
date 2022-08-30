//
// Author: Pratchaya Khansomboon
//

package Model;

/**
 * This class manage the Guest model
 */
public class GuestManager {
    Guest[] guests;

    int guestCount = 0;

    public GuestManager(int maxGuests) {
        this(maxGuests, false);
    }

    public GuestManager(int maxGuests, boolean mockdata) {
        guests = new Guest[maxGuests];

        if (mockdata)
            guests = mockData(maxGuests);

        calculateGuestCount();
    }

    public boolean addGuest(Guest guest) {
        if (getGuestCount() >= getMaxGuests())
            return false;

        guests[getGuestCount()] = guest;

        return true;
    }

    public Guest getGuestAt(int i) {
        return guests[i];
    }

    public void setGuestAt(int i, Guest guest) {
        guests[i] = guest;
    }

    public int getGuestCount() {
        calculateGuestCount();
        return guestCount;
    }

    public void deleteAt(int i) {
        guests[i] = null;
        moveNulls();
    }

    public int getMaxGuests() {
        return guests.length;
    }

    public String[] getGuestList() {
        String[] tmp = new String[guestCount]; // Don't know if this is buggy.
        int listIndex = 1;

        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                tmp[i] = listIndex + ". " + guests[i].toString();
                listIndex++;
            }

        }

        return tmp;
    }

    /**
     * Move the null values to the last in the list.
     */
    private void moveNulls() {
        int nullCount = 0;

        for (Guest guest : guests)
            nullCount += guest != null ? 1 : 0;

        for (int i = 0; i < guests.length - 1; i++) {
            if (guests[i] == null)
                swap(i, i + 1);

            if (i == guests.length - 2 && nullCount > 0) {
                nullCount--;
                i = 0;
            }
        }
    }

    private void swap(int a, int b) {
        Guest tmp = guests[a];
        guests[a] = guests[b];
        guests[b] = tmp;
    }

    private void calculateGuestCount() {
        guestCount = 0;

        for (Guest guest : guests) guestCount += guest != null ? 1 : 0;
    }

    private Guest[] mockData(int maxGuests) {
        Guest[] tmp = new Guest[maxGuests];

        tmp[0] = new Guest("Leonard", "Baker",
                new Address("Woodlawn Avenue 9311", "Portmarnock", "64424", Countries.Ireland));
        tmp[1] = new Guest("Mikkel", "Sørensen", new Address("Æblehaven 2486", "Hornbæk", "51720", Countries.Denmark));
        tmp[2] = new Guest("Ann", "Morris",
                new Address("Taylor St 3163", "Los Angeles", "17845", Countries.United_States_of_America));
        tmp[3] = new Guest("Pratchaya", "Khansomboon", new Address("YES", "Malmö", "11111", Countries.Sverige));

        return tmp;
    }

}
