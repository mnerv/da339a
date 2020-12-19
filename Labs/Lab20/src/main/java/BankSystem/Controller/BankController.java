package BankSystem.Controller;

import BankSystem.Model.BankManager;
import BankSystem.Model.Accounts.AccountType;
import BankSystem.Model.Accounts.SavingAccount;
import BankSystem.View.MainView;

public class BankController {

  private BankManager manager;
  private MainView view;

  private String[] options = { "Add account", "View accounts" };

  // private currCustomer = null;

  public BankController() {

    manager = new BankManager(10);

    view = new MainView(this);

    while (true) {
      showMenu();

    }

  }

  private void showMenu() {
    int choice = 0;

    view.showList(options);
    choice = view.showMenu();
    // TODO: Add account

    // TODO: View accounts

    switch (choice) {
      case 0:
        typeHandler();
        break;
      case 1:
        view.showList(manager.getSavingAccountList());
        break;
    }
  }

  private void typeHandler() {
    int typeChoice = 0;

    switch (typeChoice) {
      case 0:
        addAccount(AccountType.Saving);
        break;

      // case 1:
      // addAccount(AccountType.Salary);
      // break;
    }
  }

  private void addAccount(AccountType type) {
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
