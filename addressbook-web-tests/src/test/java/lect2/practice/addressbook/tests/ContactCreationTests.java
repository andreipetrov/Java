package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void UserCreationTests() {
    List<ContactData> before = app.contact().list();
    app.goTo().addNewContact();
    ContactData contact = new ContactData("Nikolay", null, "Ivanov", "QA Analyst", null, null, null, null, null, null, null, null);
    app.contact().fillContactFrom(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
