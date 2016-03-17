package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by andre on 03.03.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModificationTest(){
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test0", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("test0", "test1", "test2"));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
