package BankSystem.Model.Accounts;

import static BankSystem.Model.Accounts.AccountConst.*;

/**
 * Pension Account
 */
public class PensionAccount extends SavingAccount {
  private int minAge = PENSION_MIN_AGE;
  private int withdrawAge = PENSION_MIN_AGE;

  public PensionAccount() {
    minBalance = PENSION_MIN_BALANCE;
  }

  public int getMinAge() {
    return minAge;
  }

  public void setMinAge(int minAge) {
    this.minAge = minAge;
  }

  public int getWithdrawAge() {
    return withdrawAge;
  }

  public void setWithdrawAge(int withdrawAge) {
    this.withdrawAge = withdrawAge;
  }

}
