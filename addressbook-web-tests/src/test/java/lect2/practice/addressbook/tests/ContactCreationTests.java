package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import lect2.practice.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void UserCreationTests() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().addNewContact();
    app.getContactHelper().fillContactFrom(new ContactData("Andrei", null, "Ivanov", "QA Analyst", null, null, null, null, null, null, null, null));
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
