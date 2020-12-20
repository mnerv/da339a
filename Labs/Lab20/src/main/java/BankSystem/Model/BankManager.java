package BankSystem.Model;

import BankSystem.Model.Accounts.*;

/**
 * Handles the account creation or existance of accounts
 */
public class BankManager {
  SavingManager savingAccounts;
  SalaryManager salaryAccounts;

  public BankManager(int max) {
    savingAccounts = new SavingManager(max);
    salaryAccounts = new SalaryManager(max);

  }

  public String[] getSavingAccountList() {
    return savingAccounts.getAccountList();
  }

  public SavingManager getSavingManager() {
    return savingAccounts;
  }

  public String[] getSalaryAccountList() {
    return salaryAccounts.getAccountList();
  }

  public SalaryManager getSalaryManager() {
    return salaryAccounts;
  }
}