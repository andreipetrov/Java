package lect2.practice.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test0", "test1", "test2"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
