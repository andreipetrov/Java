package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by andre on 03.03.2016.
 */
public class ContactDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0){
      app.goTo().addNewContact();
      app.contact().create(new ContactData("Andrei", null, "Ivanov", "QA Analyst", null, null, null, null, null, null, null, null));
    }
  }

  @Test
  public void testDeleteContact(){
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().closeAlert();
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
