package BankSystem.Model.Accounts;

/**
 * Base Account
 */
public abstract class Account implements IAccount {
  // TODO: Transactions

  private String accNum;
  private long balance;

  @Override
  public String getAccountNumber() {
    return accNum;
  }

  @Override
  public void setAccountNumber(String accountNumber) {
    this.accNum = accountNumber;
  }

  @Override
  public long getBalance() {
    return balance;
  }

}
