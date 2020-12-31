package BankSystem.Model.Accounts;

import static BankSystem.Model.Accounts.AccountConst.*;

/**
 * Saving Account
 */
public class SavingAccount extends Account {
  private long interests = SAVING_INTERESTS;
  protected long minBalance = SAVING_MIN;

  private long maxWithdAnn = SAVING_MAX_WITHD_ANNUALLY; // Max withdrawal annually

  public SavingAccount() {
    accountType = AccountType.Saving;
  }

  public long getInterests() {
    return interests;
  }

  public void setInterests(long interests) {
    this.interests = interests;
  }

  public long getMinBalance() {
    return minBalance;
  }

  public void setMinBalance(long minBalance) {
    this.minBalance = minBalance;
  }

  /**
   * Get Max Withdrawal Annually
   * 
   * @return Max withdrawal annully
   */
  public long getMaxWithdAnn() {
    return maxWithdAnn;
  }

  /**
   * Set max withdrawal annually
   * 
   * @param maxWithdAnn max withdrawal annully value
   */
  public void setMaxWithdAnn(long maxWithdAnn) {
    this.maxWithdAnn = maxWithdAnn;
  }

  @Override
  public String getInfo() {
    return String.format("Account number: %s\nBalance: %s\nIntereset: %s\nMax Widrawal Annually: %s", accNum, balance,
        interests, maxWithdAnn);
  }
}