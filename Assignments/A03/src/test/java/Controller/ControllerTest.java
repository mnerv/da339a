package Controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ControllerTest {

  @Test
  public void TestHello() {
    Controller c = new Controller();
    assertEquals("World!", c.Hello());
  }

}
