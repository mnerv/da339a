package BankSystem.Model.Accounts;

/**
 * Base Account
 */
public abstract class Account implements IAccount {
  // TODO: Transactions

  // TODO: auto generate account number

  protected String accNum; // Account number
  protected long balance;

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

  @Override
  public void setBalance(long balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return String.format("Account nbr. %s, Balance: %d", accNum, balance);
  }
}