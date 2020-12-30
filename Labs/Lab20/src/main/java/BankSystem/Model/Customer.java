package BankSystem.Model;

import BankSystem.Model.Accounts.*;

/**
 * Customer
 * 
 * @discussion The Customer class manage their own accounts. Only one type of
 *             account is allowed(this might not be true).
 */
public class Customer extends Person {
    private String id;

    SalaryAccount salaryAccount;
    SavingAccount savingAccount;

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SalaryAccount getSalaryAccount() {
        return salaryAccount;
    }

    public void setSalaryAccount(SalaryAccount salaryAccount) {
        this.salaryAccount = salaryAccount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    // TODO: Temporary getting all accounts
    public String[] getAccountList() {
        String tmp[] = new String[] { salaryAccount.toString(), savingAccount.toString(), };
        return tmp;
    }

}
