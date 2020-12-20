package PostOffice.Model;

/**
 * Letter
 */
public class Letter extends MailItem {

  public Letter() {
    this.type = PostalType.Letter;
  }

  @Override
  public String toString() {
    return String.format("Type: %s, Cost: %.2f kr, Weight: %.2f kg\n%s", type, getCost(), getWeight(),
        super.toString());
  }
}
