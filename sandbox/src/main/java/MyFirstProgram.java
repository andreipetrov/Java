public class MyFirstProgram {
	
	public static void main(String[] args){

		Point p1 = new Point(5, 6);

		Point p2 = new Point(7, 8);

		System.out.println("Расстояние между точкой P1 c координатами x = " + p1.x + " , y = " + p1.y +
						" и точкой P2 c координатами x = " + p2.x + " , y = " + p2.y + " = " + p1.distance(p2));
	}

}