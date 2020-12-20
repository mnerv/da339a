package PostOffice.Controller;

import PostOffice.Model.Letter;
import PostOffice.Model.MailItem;

public class PostalController {
  MailItem item;

  public PostalController() {
    item = new Letter();
  }

  public String[] getPostalList() {
    return new String[] { "Hello", "World!" };
  }

  public String getPostalAt(int i) {
    return getPostalList()[i];
  }

}
