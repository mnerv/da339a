package BankSystem.Model;

import BankSystem.Model.Accounts.*;

/**
 * Handles the account creation or existance of accounts
 */
public class BankManager {
  SavingManager savingAccounts;

  public BankManager(int max) {
    savingAccounts = new SavingManager(max);
  }

  public String[] getSavingAccountList() {
    return savingAccounts.getAccountList();
  }

  public SavingManager getSavingManager() {
    return savingAccounts;
  }

}