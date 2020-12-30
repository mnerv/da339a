package BankSystem.Model.Accounts;

public interface AccountConst {
  static final long DECIMAL_OFFSET = 1000;

  static final int PENSION_MIN_BALANCE = 0;
  static final int PENSION_MIN_AGE = 0;

  static final long SAVING_INTERESTS = 1 * DECIMAL_OFFSET;
  static final long SAVING_MIN = 10 * DECIMAL_OFFSET;
  static final long SAVING_MAX_WITHD_ANNUALLY = 10000 * DECIMAL_OFFSET;

  static final long CREDIT_INTERESTS = 1000;
  static final long CREDIT_MAX_LIMIT = 0;

}
