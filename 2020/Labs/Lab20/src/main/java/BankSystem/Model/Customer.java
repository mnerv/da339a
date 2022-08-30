package BankSystem.Model;

import BankSystem.Model.Accounts.*;

/**
 * Customer
 *
 * @discussion The Customer class manage their own accounts. Only one type of
 *             account is allowed(this might not be true).
 */
public class Customer extends Person {
    private String id;

    Account accounts[];
    int accountCount = 0;

    public Customer() {
        this(5);
    }

    public Customer(int max) {
        accounts = new Account[max];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean addAccount(Account account) {
        if (accountCount > accounts.length - 1)
            return false;

        accounts[accountCount] = account;
        accountCount++;

        return true;
    }

    public Account getAccountAt(int i) {
        if (i > -1 && i < accountCount)
            return accounts[i];

        return null;
    }

    public String[] getAccountList() {
        String[] accountList = new String[accountCount];
        for (int i = 0; i < accountCount; i++) {
            accountList[i] = accounts[i].toString();
        }
        return accountList;
    }
}
