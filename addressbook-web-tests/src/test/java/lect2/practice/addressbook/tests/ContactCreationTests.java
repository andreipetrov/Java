package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import lect2.practice.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
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
    File photo = new File("src/test/resources/test.png");
    ContactData contact = new ContactData().withName("Andrei").withSurname("Ivanov").withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

  @Test(enabled = true)
  public void userCreationTest() {
    app.goTo().addNewContact();
    File photo = new File("src/test/resources/test.png");
    app.contact().fillContactFrom(
            new ContactData().withName("Alex").withSurname("Petrov").withPhoto(photo));
    app.goTo().homePage();
  }

  @Test(enabled = false)
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/test.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
