package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.ContactData;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by andre on 27.03.2016.
 */
public class ContactInfoTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withName("Andrei").withSurname("Ivanov").withPosition("QA Analyst").
              withAddress("Moscow").withEmail("Ivanov@test.com").withEmail2("A.Ivanov@test.com").withEmail3("N/A")
              .withHomePhone("111222").withMobilePhone("222333").withWorkPhone("333444"));
    }
  }

  @Test
  public void testContactInfoData() {
    app.goTo().homePage();
    ContactData contact = app.db().contacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(contact);
    WebElement contactInfo = app.contact().contactInfoFromInfoForm(contact);
    String contactInformation = cleaned(contactInfo);
    String contactFromEdit = mergeContactInfo(contactInfoFromEditForm);
    assertThat(contactInformation, equalTo(contactFromEdit));

  }

  private String mergeContactInfo(ContactData contact) {
    return Arrays.asList(contact.getName(),contact.getSurname(),contact.getAddress(),
                         contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone(),
                         contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((c) -> ! c.equals(""))
            .map(ContactInfoTests::cleaned)
            .collect(Collectors.joining(""));
  }

  public static String cleaned(String data){
    return data.replaceAll("\\n", "").replaceAll("[-()]", "").replaceAll(" ", "");
  }

  private String cleaned(WebElement contactInfo){
    String contact = contactInfo.getText().replace("www.test.com", "").replace("www.gmail.com", "").replace("()", "").replace("H:", "").replace("M:", "").replace("W:", "")
            .replace("\n", "").replace(" ", "").replace("-", "");
    return contact;
  }
}
