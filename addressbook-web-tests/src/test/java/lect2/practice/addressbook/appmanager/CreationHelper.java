package lect2.practice.addressbook.appmanager;

import lect2.practice.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by andre on 02.03.2016.
 */
public class CreationHelper extends HelperBase {

  public CreationHelper(FirefoxDriver wd) {
    super (wd);
  }

  public void fillContactFrom(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getIbitial());
    ty(By.name("lastname"), contactData.getSurname());
    name(By.name("title"), contactData.getPosition());
    name(By.name("company"), contactData.getCompanyTitle());
    name(By.name("address"), contactData.getAddress());
    name(By.name("mobile"), contactData.getMobilePhone());
    name(By.name("email"), contactData.getEmail());
    name(By.name("byear"), contactData.getAge());
    name(By.name("address2"), contactData.getSecondAddress());
    name(By.name("phone2"), contactData.getSecondPhone());
    name(By.name("notes"), contactData.getNotes());
    submitChanges();
  }

  public void submitChanges() {

   click(By.xpath("//div[@id='content']/form/input[21]"));
  }
}
