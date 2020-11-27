package BankSystem.Model.Accounts;

import static BankSystem.Model.Accounts.AccountConst.*;

/**
 * Saving Account
 */
public class SavingAccount extends Account {
  private long interests = SAVING_INTERESTS;
  private long minBalance = SAVING_MIN;

}
