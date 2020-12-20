package BankSystem.Model;

import BankSystem.Model.Accounts.SalaryAccount;

public class SalaryManager extends AccountManager<SalaryAccount> {
  public SalaryManager(int max) {
    accounts = new SalaryAccount[max];
  }

}
