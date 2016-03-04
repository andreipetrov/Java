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
  }

  public void submitChanges() {

   click(By.xpath("//div[@id='content']/form/input[21]"));
  }
}
