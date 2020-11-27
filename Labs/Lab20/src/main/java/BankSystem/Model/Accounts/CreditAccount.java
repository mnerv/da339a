package BankSystem.Model.Accounts;

import static BankSystem.Model.Accounts.AccountConst.*;

/**
 * Credit Account
 */
public class CreditAccount extends Account {

  private long interests = CREDIT_INTERESTS;
  private long limit = CREDIT_MAX_LIMIT;

}
