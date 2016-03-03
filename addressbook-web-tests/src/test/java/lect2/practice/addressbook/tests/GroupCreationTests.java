package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test0", "test1", "test2"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
