package lect8.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by andre on 16.04.2016.
 */
public class RegistrationTests extends TestBase {

  @Test
  public void testRegistration(){
    app.registration().start("user1", "user1@localhost.localdomain");
  }
}
