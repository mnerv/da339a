package BankSystem.Controller;

import BankSystem.Model.BankManager;

public class BankController {

  BankManager bm;

  public BankController() {

    bm = new BankManager(10);

  }

}