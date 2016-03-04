package lect2.practice.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by andre on 03.03.2016.
 */
public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion (){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
