package lect1.practice.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by andre on 26.02.2016.
 */
public class PointTests {

  @Test
  public void TestArea(){
    Point p1 = new Point (4, 5);
    Point p2 = new Point (7, 8);
    Assert.assertEquals(p1.distance(p2), 4.242640687119285);
  }
}
