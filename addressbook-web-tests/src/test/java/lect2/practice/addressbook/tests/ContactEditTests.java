package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by andre on 03.03.2016.
 */
public class ContactEditTests extends TestBase {

  @Test
  public void testEditContact () {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().addNewContact();
      app.getContactHelper().createContact(new ContactData("Andrei", null, "Ivanov", "QA Analyst", null, null, null, null, null, null, null, null));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactFrom(new ContactData("Sergey", "I", "Ivanov", "QAt", "AT", "2435 New street, Chisinau, Moldova, MD-2028", "069583300", "andrei@test.com", "1988", "N/A", "N/A", "N/A"));
    app.getContactHelper().updateContact();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
