package BankSystem.Model.Accounts;

/**
 * Salary Account
 */
public class SalaryAccount extends Account {
  private String employerName;

  public SalaryAccount() {
    accountType = AccountType.Salary;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  public String getEmployerName() {
    return employerName;
  }

  @Override
  public String getInfo() {
    return String.format("Account number: %s\nBalance: %s\nEmployer: %s\n ", accNum, balance, employerName);
  }
}
