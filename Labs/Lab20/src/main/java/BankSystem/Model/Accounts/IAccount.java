package BankSystem.Model.Accounts;

/**
 * Interface for Account
 */
public interface IAccount {
  public String getAccountNumber();

  public void setAccountNumber(String accountNumber);

  public long getBalance();

  public void setBalance(long balance);

  public AccountType getAccountType();

  public void setAccountType(AccountType type);

}
