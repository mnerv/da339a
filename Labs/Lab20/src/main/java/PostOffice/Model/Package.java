package PostOffice.Model;

/**
 * Package
 */
public class Package extends Parcel {
  public Package() {
    this.type = PostalType.Package;
  }

  // @Override
  // public String toString() {
  // return String.format("Type: %s, Cost: %.2f kr, Weight: %.2f kg\n%s",
  // this.type, getCost(), getWeight(),
  // super.toString());
  // }
}
