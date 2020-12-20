package BankSystem.Controller;

import BankSystem.Model.BankManager;
import BankSystem.Model.Accounts.*;
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
    view.display("Welcome to the Bank Manager \nThese are the existing account types: \n");

    view.showList(accountTypes);

    choice = view.getOption("Select option: ");

    switch (choice) {
      case 3:
        accountTypeHandle(AccountType.Salary);
        break;
      case 4:
        accountTypeHandle(AccountType.Saving);
        break;
      default:
        break;
    }
  }

  private void accountTypeHandle(AccountType type) {
    view.hLine();
    view.display(String.format("Selected %s\n", type.toString()));
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
    // TODO add input of balance and such for the salary and saving accounts

    switch (type) {
      case Saving:
        SavingAccount savingAccount = new SavingAccount();
        view.display("Enter your saving interests (get a high one ;)\n");
        savingAccount.setInterests(view.inputInt());

        view.display("Enter balance: ");
        savingAccount.setBalance(view.inputInt());

        if (savingAccount.getBalance() > savingAccount.getMinBalance())
          manager.getSavingManager().addAccount(savingAccount);
        else
          view.display(String.format(
              "Error adding account! Stop being poor!\nSpecified balance is less than minimum balance of %s\n",
              savingAccount.getMinBalance()));

        break;
      case Salary:
        SalaryAccount salaryAccount = new SalaryAccount();

        view.display("Input your Employers name:\n");
        salaryAccount.setEmployerName(view.inputText());

        view.display("Enter balance: ");
        salaryAccount.setBalance(view.inputInt());
        manager.getSalaryManager().addAccount(salaryAccount);
      default:
        break;
    }
  }

  private void listAccountInfo(AccountType type) {
    switch (type) {
      case Saving:
        view.showList(manager.getSavingAccountList());
        break;

      case Salary:
        view.showList(manager.getSalaryAccountList());

      default:
        break;
    }
  }

  // TODO make this work so we get a balance and stuff from the account that we
  // choce (implement so we can chose)
  private void showAccountInfo(AccountType type, int index) {
    switch (type) {
      case Saving:
        view.showMessage(manager.getSavingManager().getAccountAt(index).toString());
        break;

      case Salary:
        view.showMessage(manager.getSalaryManager().getAccountAt(index).toString());
        break;

      default:
        view.showMessage("No account");
        break;
    }
  }
}