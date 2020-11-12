package Model;

/**
 * Author: Pratchaya Khansomboon
 */
public class GuestManager {
    Guest[] guests;

    public GuestManager(int maxGuests) {
        this(maxGuests, false);
    }

    public GuestManager(int maxGuests, boolean mockdata) {
        guests = new Guest[maxGuests];

        if (mockdata)
            guests = mockData(maxGuests);
    }

    private Guest[] mockData(int maxGuests) {
        Guest[] tmp = new Guest[maxGuests];

        tmp[0] = new Guest("Leonard", "Baker",
                new Address("Woodlawn Avenue 9311", "Portmarnock", "64424", Countries.Ireland));
        tmp[1] = new Guest("Mikkel", "Sørensen", new Address("Æblehaven 2486", "Hornbæk", "51720", Countries.Denmark));
        tmp[2] = new Guest("Ann", "Morris",
                new Address("Taylor St 3163", "Los Angeles", "17845", Countries.United_States_of_America));

        return tmp;
    }

    public String[] getGuestList() {
        String[] tmp = new String[guests.length];

        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null)
                tmp[i] = guests[i].toString();
        }

        return tmp;
    }

}
