package PostOffice.Model;

/**
 * Parcel
 */
public class Parcel extends MailItem {
  private Size size;

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }
}
