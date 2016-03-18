package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by andre on 03.03.2016.
 */
public class ContactDeletionTest extends TestBase {

  @Test
  public void testDeleteContact(){
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().addNewContact();
      app.getContactHelper().createContact(new ContactData("Andrei", null, "Ivanov", "QA Analyst", null, null, null, null, null, null, null, null));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().closeAlert();
    app.getNavigationHelper().goToHomePage();
  }
}
