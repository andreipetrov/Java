package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void UserCreationTests() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().addNewContact();
    ContactData contact = new ContactData("Nikolay", null, "Ivanov", "QA Analyst", null, null, null, null, null, null, null, null);
    app.getContactHelper().fillContactFrom(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
