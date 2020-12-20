package PostOffice.Controller;

import PostOffice.Model.Address;
import PostOffice.Model.Countries;
import PostOffice.Model.Letter;
import PostOffice.Model.Package;
import PostOffice.Model.Parcel;
import PostOffice.Model.Person;
import PostOffice.Model.Postcard;
import PostOffice.Model.Receiver;
import PostOffice.Model.Sender;
import PostOffice.Model.Size;
import PostOffice.View.MainFrame;
import Utilities.IOManager;

/**
 * PostalController
 */
public class PostalController {
  Letter letter;
  Postcard postcard;
  Parcel parcel;

  Package _package;

  MainFrame view;

  // TODO: Create view for display

  public PostalController() {
    view = new MainFrame(this);

    postcard = createPostcard();
    letter = createLetter();
    parcel = createParcel();
    _package = createPackage();

    IOManager.Clear();
    System.out.println(getLetter());
    System.out.println();
    System.out.println(getPostcard());
    System.out.println();
    System.out.println(getParcel());
    System.out.println();
    System.out.println(getPackage());

  }

  public void listIndexChanged(int index) {
  }

  public String getLetter() {
    return letter.toString();
  }

  public String getPostcard() {
    return postcard.toString();
  }

  public String getParcel() {
    return parcel.toString();
  }

  public String getPackage() {
    return _package.toString();
  }

  public Countries[] getCountries() {
    return Countries.values();
  }

  private Letter createLetter() {
    Letter newLetter = new Letter();

    // TODO: Get values from view for letter

    Sender sender = new Sender(new Person("Charlie", "Ringstrom"),
        new Address("Per Albin Hanssons väg", "Malmö", "214 32", Countries.Sweden));
    Receiver receiver = new Receiver(new Person("Pratchaya", "Khansomboon"),
        new Address("Lars väg 27-19", "Hjärup", "245 63", Countries.Sweden));

    newLetter.setCost(20);
    newLetter.setSender(sender);
    newLetter.setReceiver(receiver);
    newLetter.setWeight(10);

    return newLetter;
  }

  private Postcard createPostcard() {
    Postcard newPostcard = new Postcard();

    // TODO: Get values from view for postcard

    Sender sender = new Sender(new Person("Charlie", "Ringstrom"),
        new Address("Per Albin Hanssons väg", "Malmö", "214 32", Countries.Sweden));
    Receiver receiver = new Receiver(new Person("Pratchaya", "Khansomboon"),
        new Address("Lars väg 27-19", "Hjärup", "245 63", Countries.Sweden));

    newPostcard.setCost(10);
    newPostcard.setSender(sender);
    newPostcard.setReceiver(receiver);
    newPostcard.setWeight(0.01);

    return newPostcard;
  }

  private Parcel createParcel() {
    Parcel newParcel = new Parcel();

    // TODO: Get values from view for parcel

    Sender sender = new Sender(new Person("Charlie", "Ringstrom"),
        new Address("Per Albin Hanssons väg", "Malmö", "214 32", Countries.Sweden));
    Receiver receiver = new Receiver(new Person("Pratchaya", "Khansomboon"),
        new Address("Lars väg 27-19", "Hjärup", "245 63", Countries.Sweden));

    Size size = new Size();
    size.setLength(1);
    size.setWidth(1);
    size.setHeight(1);

    newParcel.setSender(sender);
    newParcel.setReceiver(receiver);
    newParcel.setSize(size);
    newParcel.setWeight(10);
    newParcel.setCost(100);

    return newParcel;
  }

  private Package createPackage() {
    Package newPackage = new Package();

    // TODO: Get values from view for package

    Sender sender = new Sender(new Person("Charlie", "Ringstrom"),
        new Address("Per Albin Hanssons väg", "Malmö", "214 32", Countries.Sweden));
    Receiver receiver = new Receiver(new Person("Pratchaya", "Khansomboon"),
        new Address("Lars väg 27-19", "Hjärup", "245 63", Countries.Sweden));

    Size size = new Size();
    size.setLength(1);
    size.setWidth(1);
    size.setHeight(1);

    newPackage.setSender(sender);
    newPackage.setReceiver(receiver);
    newPackage.setSize(size);
    newPackage.setWeight(10);
    newPackage.setCost(100);

    return newPackage;
  }
}
// public void productTypeChanged(ButtonType radiobtn)
// {
// switch (radiobtn)
// {
// case rbtnBook:
// {
// product.setProductType(ProductType.Books);
// validateAndSaveProduct();
// break;
// }

// case rbtnFood:
// {
// product.setProductType(ProductType.Food);
// validateAndSaveProduct();
// break;
// }

// case rbtnOther:
// {
// product.setProductType(ProductType.Other);
// validateAndSaveProduct();
// break;
// }
// }
// }