package lect2.practice.addressbook.appmanager;

import lect2.practice.addressbook.model.ContactData;
import lect2.practice.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 02.03.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super (wd);
  }

  public void fillContactFrom(ContactData contactData
          //,boolean creation
            ) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getIbitial());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("title"), contactData.getPosition());
    type(By.name("company"), contactData.getCompanyTitle());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("byear"), contactData.getAge());
    type(By.name("address2"), contactData.getSecondAddress());
    type(By.name("phone2"), contactData.getSecondPhone());
    type(By.name("notes"), contactData.getNotes());
    submitChanges();

    //if (creation) {
      //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    //} else{
      //Assert.assertFalse(isElementPresent(By.name("new_group")));
   // }
  }

  public void submitChanges() {

   click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void editContact(int index) {
    click(By.xpath("//table[@id='maintable']/tbody/tr[" + (2 + index) + "]/td[8]/a/img"));
  }

  public void updateContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void modify(int index, ContactData contact) {
    selectContact(index);
    editContact(index);
    fillContactFrom(contact);
    updateContact();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void create(ContactData contact) {
    fillContactFrom(contact);
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.tagName("td"));
      WebElement cell1 = cells.get( 1 );
      WebElement cell2 = cells.get( 2 );
      String firstName = cell2.getText();
      String lastName = cell1.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      contacts.add(new ContactData().withId(id).withName(firstName).withSurname(lastName));
    }
    return contacts;
  }
}
