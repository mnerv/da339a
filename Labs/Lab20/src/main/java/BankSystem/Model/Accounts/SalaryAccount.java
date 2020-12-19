package BankSystem.Model.Accounts;

/**
 * Salary Account
 */
public class SalaryAccount extends Account {
  private String employerName;

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  public String getEmployerName() {
    return employerName;
  }
}
