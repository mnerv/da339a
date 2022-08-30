package BankSystem.Model;

import BankSystem.Model.Accounts.Account;

public class AccountManager<T extends Account> {
    protected T accounts[];
    protected int count = 0;

    public AccountManager() {}

    public AccountManager(T accounts[]) {
        this.accounts = accounts;
    }

    public boolean addAccount(T account) {
        if (count > accounts.length - 1) {
            return false;
        }

        accounts[count] = account;
        count++;

        return true;
    }

    public boolean removeAccountAt(int i) {
        if (i > -1 && i < accounts.length) {
            accounts[i] = null;
            count--;
            return true;
        }

        return false;
    }

    public T getAccountAt(int i) {
        if (i > -1 && i < accounts.length) {
            return accounts[i];
        }

        return null;
    }

    public boolean setAccountAt(int i, T account) {
        if (i > -1 && i < accounts.length) {
            accounts[i] = account;
            return true;
        }

        return false;
    }

    public void moveNulls() {
        int nullCount = accounts.length - count;

        for (int i = 0; i < accounts.length - 1; i++) {
            if (accounts[i] == null) {
                T tmp = accounts[i];
                accounts[i] = accounts[i + 1];
                accounts[i + 1] = tmp;
            }

            if (i == accounts.length - 2 && nullCount > 0) {
                nullCount--;
                i = 0;
            }
        }
    }

    public int getTotalAccounts() {
        return count;
    }

    public String[] getAccountList() {
        String[] tmp = new String[count]; // Don't know if this is buggy.
        int listIndex = 0;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                tmp[i] = accounts[i].toString();
                listIndex++;
            }
        }
        return tmp;
    }
}