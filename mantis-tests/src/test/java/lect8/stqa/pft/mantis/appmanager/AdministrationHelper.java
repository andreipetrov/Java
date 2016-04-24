package lect8.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by andre on 21.04.2016.
 */
public class AdministrationHelper extends HelperBase {
  
  public AdministrationHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }


  public void managementMenu() {
    click(By.xpath("/html/body/div[2]/p/span[1]/a"));
  }

  public void manageUser() {
    click(By.xpath("/html/body/table[3]/tbody/tr[5]/td[1]/a"));
  }

  public void resetPassword() {
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public void changePassword(String findNewPasswordLink, String newpassword) {
    wd.get(findNewPasswordLink);
    type(By.name("password"), newpassword);
    type(By.name("password_confirm"), newpassword);
    click(By.cssSelector("input[value='Update User']"));
  }

  public void login(String username, String password) {
      wd.get(app.getProperty("web.baseUrl") + "login.php");
      type(By.name("username"), username);
      type(By.name("password"), password);
      click(By.cssSelector("input[value='Login']"));
  }

  public void manageMenu() {
    click(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[7]"));
  }
}
