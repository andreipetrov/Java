package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import lect2.practice.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void UserCreationTests() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().addNewContact();
    ContactData contact = new ContactData("Andrei", null, "Ivanov", "QA Analyst", null, null, null, null, null, null, null, null);
    app.getContactHelper().fillContactFrom(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
    for (ContactData c : after) {
      if (c.getId() > max){
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
