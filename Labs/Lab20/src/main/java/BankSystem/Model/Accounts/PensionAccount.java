package BankSystem.Model.Accounts;

import static BankSystem.Model.Accounts.AccountConst.*;

/**
 * Pension Account
 */
public class PensionAccount extends SavingAccount {
  private long minAge = PENSION_MIN_AGE;
  private long minBalance = PENSION_MIN_BALANCE;
}
