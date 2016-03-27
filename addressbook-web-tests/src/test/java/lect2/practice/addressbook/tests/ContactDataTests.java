package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by andre on 26.03.2016.
 */
public class ContactDataTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withName("Andrei").withSurname("Ivanov").withPosition("QA Analyst"));
    }
  }

  @Test
  public void testContactData() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData infoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
