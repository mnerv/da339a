package BankSystem.Model;

import java.util.Arrays;

import BankSystem.Model.Accounts.*;

/**
 * Handles the account creation or existance of accounts
 */
public class BankManager {
  CorporateAccount corporates[];
  CreditAccount credits[];
  PensionAccount pensions[];
  SalaryAccount salaries[];
  SavingAccount savings[];

  int corporateCount = 0;;
  int creditCount = 0;
  int pensionCount = 0;
  int salaryCount = 0;
  int savingCount = 0;

  private static long accNumCounter = 0;

  public BankManager(int max) {

    corporates = new CorporateAccount[max];
    credits = new CreditAccount[max];
    pensions = new PensionAccount[max];
    salaries = new SalaryAccount[max];
    savings = new SavingAccount[max];

    corporates[0] = new CorporateAccount();
    corporates[0].setOrgNum("Hello, World!");

    System.out.println(corporates[0].getOrgNum());

  }

  public boolean createAccount(AccountType type) {
    switch (type) {
      case Corporate:
        if (corporateCount > corporates.length - 1)
          return false;

        corporates[corporateCount] = new CorporateAccount();
        corporates[corporateCount].setAccountNumber(String.valueOf(accNumCounter));
        corporateCount++;

        break;
      case Credit:
        if (creditCount > credits.length - 1)
          return false;

        credits[creditCount] = new CreditAccount();
        credits[creditCount].setAccountNumber(String.valueOf(accNumCounter));

        creditCount++;

        break;
      case Pension:
        if (pensionCount > pensions.length - 1)
          return false;

        pensions[pensionCount] = new PensionAccount();
        pensions[pensionCount].setAccountNumber(String.valueOf(accNumCounter));

        pensionCount++;

        break;
      case Salary:
        if (salaryCount > salaries.length - 1)
          return false;

        salaries[salaryCount] = new SalaryAccount();
        salaries[salaryCount].setAccountNumber(String.valueOf(accNumCounter));

        salaryCount++;

        break;
      case Saving:
        if (savingCount > savings.length - 1)
          return false;

        savings[savingCount] = new SavingAccount();
        savings[savingCount].setAccountNumber(String.valueOf(accNumCounter));

        savingCount++;

        break;
    }

    accNumCounter++;
    return true;
  }

  public CorporateAccount getCorporateAccount(int index) {
    if (index > -1 && index < corporates.length && corporates[index] != null) {
      return corporates[index];
    }

    return null;
  }

  public SavingAccount getSavingAccountAt(int index) {
    if (index > -1 && index < savings.length && savings[index] != null) {
      return savings[index];
    }

    return null;
  }

  public boolean setSavingAccountAt(int index, SavingAccount account) {
    if (index > -1 && index < savings.length && savings[index] != null) {
      savings[index] = account;

      return true;
    }

    return false;
  }

  public PensionAccount getPensionAccountAt(int index) {
    if (index > -1 && index < pensions.length && pensions[index] != null) {
      return pensions[index];
    }

    return null;
  }

  public void removeAccountAt(AccountType type, int index) {
    // TODO: Remove account
  }

  public String[] getCorporateAccounts() {
    String[] tmp = new String[corporateCount]; // Don't know if this is buggy.
    int listIndex = 0;

    for (int i = 0; i < corporates.length; i++)
      if (corporates[i] != null) {
        tmp[i] = listIndex + ". " + corporates[i].toString();
        listIndex++;
      }

    return tmp;
  }

  public String[] getCreditAccounts() {
    String[] tmp = new String[creditCount]; // Don't know if this is buggy.
    int listIndex = 0;

    for (int i = 0; i < credits.length; i++)
      if (credits[i] != null) {
        tmp[i] = listIndex + ". " + credits[i].toString();
        listIndex++;
      }

    return tmp;
  }

  public String[] getPensionAccounts() {
    String[] tmp = new String[pensionCount]; // Don't know if this is buggy.
    int listIndex = 0;

    for (int i = 0; i < pensions.length; i++)
      if (pensions[i] != null) {
        tmp[i] = listIndex + ". " + pensions[i].toString();
        listIndex++;
      }

    return tmp;
  }

  public String[] getSalaryAccounts() {
    String[] tmp = new String[salaryCount]; // Don't know if this is buggy.
    int listIndex = 0;

    for (int i = 0; i < salaries.length; i++)
      if (salaries[i] != null) {
        tmp[i] = listIndex + ". " + salaries[i].toString();
        listIndex++;
      }

    return tmp;
  }

  public String[] getSavingAccounts() {
    String[] tmp = new String[savingCount]; // Don't know if this is buggy.
    int listIndex = 0;

    for (int i = 0; i < savings.length; i++)
      if (savings[i] != null) {
        tmp[i] = listIndex + ". " + savings[i].toString();
        listIndex++;
      }

    return tmp;
  }

}