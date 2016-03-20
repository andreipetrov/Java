package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().closeAlert();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after, before.size() - 1);
  }
}
