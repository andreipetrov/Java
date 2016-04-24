package lect8.stqa.pft.mantis.tests;

import lect8.stqa.pft.mantis.model.MailMessage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Created by andre on 21.04.2016.
 */
public class PasswordChangeTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void changePasswordTest () throws IOException, MessagingException {
    String email = "user1461038087979@localhost.localdomain";
    String username = "user1461038087979";
    long now = System.currentTimeMillis();
    String newpassword = String.format("np%s", now);
    String adminname = "administrator";
    String adminpass = "root";
    app.administration().login(adminname, adminpass);
    app.administration().manageMenu();
    app.administration().managementMenu();
    app.administration().manageUser();
    app.administration().resetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findChangeLink(mailMessages, email);
    app.administration().changePassword(confirmationLink, newpassword);
    app.newSession().login(username, newpassword);
  }

  private String findChangeLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findAny().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();}
}
