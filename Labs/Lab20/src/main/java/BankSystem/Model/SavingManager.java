package BankSystem.Model;

import BankSystem.Model.Accounts.SavingAccount;

public class SavingManager extends AccountManager<SavingAccount> {
  public SavingManager(int max) {
    accounts = new SavingAccount[max];
  }
}
