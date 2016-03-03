package lect2.practice.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void UserCreationTests() {
    addNewContact();
    fillContactFrom(new ContactData("Andrei", "I", "surname", "QA Analyst", "AT", "2435 New street, Chisinau, Moldova, MD-2028", "069583300", "andrei@test.com", "1988", "N/A", "N/A", "N/A"));
  }

}
