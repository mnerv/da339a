package PostOffice.Controller;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PostalControllerTest {

  @Test
  public void postalList() {
    PostalController pc = new PostalController();

    assertArrayEquals(new String[] { "Hello", "World!" }, pc.getPostalList());
  }

}
