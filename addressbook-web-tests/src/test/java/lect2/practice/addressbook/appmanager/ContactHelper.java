package lect2.practice.addressbook.appmanager;

import lect2.practice.addressbook.model.ContactData;
import lect2.practice.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by andre on 02.03.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void fillContactFrom(ContactData contactData
                              //,boolean creation
  ) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getIbitial());
    type(By.name("lastname"), contactData.getSurname());
    attach(By.name("photo"), contactData.getPhoto());
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

  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void editContactById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  private void clickContactInfoById(int id) {wd.findElement(By.cssSelector("a[href='view.php?id=" + id + "']")).click();
  }

  public void updateContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    editContactById(contact.getId());
    fillContactFrom(contact);
    updateContact();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    contactCache = null;
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void create(ContactData contact) {
    fillContactFrom(contact);
    contactCache = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;


  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));

      String firstName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      String address = cells.get(3).getText();
      String allPhones = cells.get(5).getText();
      String allEmails =  cells.get(4).getText();

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      contactCache.add(new ContactData().withId(id).withName(firstName).withSurname(lastName).withAddress(address)
              .withAllEmails(allEmails)
              .withAllPhones(allPhones));
    }
    return new Contacts(contactCache);
  }

  public ContactData contactInfoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstName).withSurname(lastName).withAddress(address)
             .withEmail(email1).withEmail2(email2).withEmail3(email3)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  private void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public WebElement contactInfoFromInfoForm(ContactData contact) {
    clickContactInfoById(contact.getId());
    WebElement element = wd.findElement(By.xpath(".//*[@id='content']"));
    return element;
  }

}
