package lect2.practice.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by andre on 03.03.2016.
 */
public class ContactDeletionTest extends TestBase {

  @Test
  public void testDeleteContact(){
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().closeAlert();
    app.getNavigationHelper().goToHomePage();
  }
}
