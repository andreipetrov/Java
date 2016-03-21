package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by andre on 03.03.2016.
 */
public class ContactEditTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0){
      app.goTo().addNewContact();
      app.contact().create(new ContactData("Andrei", null, "Ivanov", "QA Analyst", null, null, null, null, null, null, null, null));
    }
  }

  @Test
  public void testEditContact () {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1 ;
    ContactData contact = new ContactData(before.get(index).getId(), "Sergey", "I", "Ivanov", "QAt", "AT", "2435 New street, Chisinau, Moldova, MD-2028", "069583300", "andrei@test.com", "1988", "N/A", "N/A", "N/A");
    app.contact().modify(index, contact);
    app.goTo().returnToHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
