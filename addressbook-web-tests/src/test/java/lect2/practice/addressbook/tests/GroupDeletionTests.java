package lect2.practice.addressbook.tests;

import lect2.practice.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by andre on 03.03.2016.
 */
public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
