/**
 * Created by andre on 23.02.2016.
 */
public class Point {
  public double x;
  public double y;

  public Point (double x, double y){
    this.x = x;
    this.y = y;
  }

  public double distance (){
    return Math.sqrt( (this.x - this.x)*(this.x - this.x) + (this.y - this.y)*(this.y - this.y) );
  }

}