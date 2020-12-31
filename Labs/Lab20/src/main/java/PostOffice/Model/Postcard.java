package PostOffice.Model;

/**
 * Postcard has a standard size and weight
 */
public class Postcard extends Letter {
  public Postcard() {
    type = PostalType.Postcard;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
