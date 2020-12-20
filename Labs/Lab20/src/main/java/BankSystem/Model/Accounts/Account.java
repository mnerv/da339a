package BankSystem.Model.Accounts;

import java.util.UUID;

/**
 * Base Account
 */
public abstract class Account implements IAccount {
  // TODO: Transactions

  // TODO: auto generate account number

  protected String accNum; // Account number
  protected long balance;

  private static long accountNumCounter = 123456780;

  public Account() {
    accountNumCounter++;
    // accNum = UUID.randomUUID().toString();
    accNum = String.valueOf(accountNumCounter);
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
  public String toString() {
    return String.format("Account: %s", accNum);
  }
}