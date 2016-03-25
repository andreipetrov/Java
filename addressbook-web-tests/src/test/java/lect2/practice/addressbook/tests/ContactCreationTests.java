package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import lect2.practice.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void userCreationTests() {
    Contacts before = app.contact().all();
    app.goTo().addNewContact();
    ContactData contact = new ContactData().withName("Nikolay").withSurname("Ivanov").withPosition("QA Analyst");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void bugUserCreationTests() {
    Contacts before = app.contact().all();
    app.goTo().addNewContact();
    ContactData contact = new ContactData().withName(" ").withSurname("Ivanov").withPosition("QA Analyst");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}
