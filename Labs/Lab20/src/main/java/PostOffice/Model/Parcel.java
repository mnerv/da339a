package PostOffice.Model;

/**
 * Parcel
 */
public class Parcel extends MailItem {
  private Size size;

  public Parcel() {
    type = PostalType.Parcel;
  }

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return String.format("Type: %s, Cost: %.2f kr, Weight: %.2f kg\nDimensions (m): %s\n%s", type, getCost(),
        getWeight(), size.toString(), super.toString());
  }
}
