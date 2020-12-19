package BankSystem.Controller;

import BankSystem.Model.BankManager;
import BankSystem.Model.Accounts.AccountType;
import BankSystem.Model.Accounts.SavingAccount;
import BankSystem.View.MainView;

public class BankController {

  private BankManager manager;
  private MainView view;

  // @formatter:off
  private String[] accountTypes = {
    "Corporate",
    "Credit",
    "Pension",
    "Salary",
    "Saving"
  };

  private String[] accountOptions = { 
    "Add account",
    "List account",
  };
  // @formatter:on

  // private currCustomer = null;

  public BankController() {

    manager = new BankManager(10);

    view = new MainView(this);

    while (true) {
      showMainMenu();

    }
  }

  private void showMainMenu() {
    int choice = 0;

    view.hLine();
    view.display("Welcome to the Bank Manager \nThese are the existing account types: ");

    view.showList(accountTypes);

    choice = view.getOption("Select option: ");

    switch (choice) {
      case 4:
        accountTypeHandle(AccountType.Saving);
        break;
      default:
        break;
    }
  }

  private void accountTypeHandle(AccountType type) {
    view.hLine();
    view.display(String.format("Selected %s", type.toString()));
    view.hLine();

    view.showList(accountOptions);

    int choice = view.getOption("Select option: ");

    switch (choice) {
      case 0:
        addAccount(type);
        break;
      case 1:
        listAccountInfo(type);
        break;
    }
  }

  private void addAccount(AccountType type) {
    // TODO add input of balance and such for the account

    switch (type) {
      case Saving:
        SavingAccount tmp = new SavingAccount();
        tmp.setAccountNumber("1234567890");
        tmp.setBalance(100);
        manager.getSavingManager().addAccount(tmp);
        break;
      default:
        break;
    }
  }

  // TODO stop it from printing the balance as that is personal info
  private void listAccountInfo(AccountType type) {
    switch (type) {
      case Saving:
        view.showList(manager.getSavingAccountList());
        break;
      default:
        break;
    }
  }

  private void showAccountInfo(AccountType type, int index) {
    switch (type) {
      case Saving:
        view.showMessage(manager.getSavingManager().getAccountAt(index).toString());
        break;
      default:
        view.showMessage("No account");
        break;
    }
  }

}
