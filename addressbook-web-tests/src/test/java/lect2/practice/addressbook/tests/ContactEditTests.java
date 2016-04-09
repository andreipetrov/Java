package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import lect2.practice.addressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by andre on 03.03.2016.
 */
public class ContactEditTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0){
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withName("Andrei").withSurname("Ivanov").withPosition("QA Analyst"));
    }
  }

  @Test
  public void testEditContact () {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).
            withName("Sergey").
            withInitial("I").
            withSurname("Ivanov").
            withPosition("QAt").
            withCompanyTitle("AT").
            withAddress("2435 New street, Chisinau, Moldova, MD-2028").
            withMobilePhone("069583300").withEmail("andrei@test.com").
            withAge("25").
            withSecondPhone("N/A").
            withSecondAddress("N/A").
            withNotes("N/A");
    app.contact().modify(contact);
    app.goTo().returnToHomePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
