package BankSystem.Model.Accounts;

/**
 * Base Account
 */
public abstract class Account implements IAccount {
  protected String accNum; // Account number
  protected long balance;
  protected AccountType accountType;

  private static long accountNumCounter = 0; // Starting ID number

  public Account() {
    accountNumCounter++;
    accNum = String.valueOf(accountNumCounter);
    balance = 0;
  }

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
  public AccountType getAccountType() {
    return accountType;
  }

  @Override
  public void setAccountType(AccountType type) {
    accountType = type;
  }

  @Override
  public String toString() {
    return String.format("Type: %s, Nbr. %s", getAccountType(), getAccountNumber().toString());
  }

}