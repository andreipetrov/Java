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
public class ContactDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0){
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withName("Andrei").withSurname("Ivanov").withPosition("QA Analyst"));
    }
  }

  @Test
  public void testDeleteContact(){
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().closeAlert();
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
