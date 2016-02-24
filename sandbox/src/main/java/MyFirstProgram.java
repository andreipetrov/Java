public class MyFirstProgram {
	
	public static void main(String[] args){

		hello("world");
		hello("user");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4,6);
		System.out.println("Площадь прямогульника со сторонами " + r.a + " и " + r.b + " = " + r.area());

		Point p1 = new Point();
		p1.x = 5;
		p1.y = 6;

		Point p2 = new Point();
		p2.x = 7;
		p2.y = 8;

		System.out.println("Расстояние между точкой P1 c координатами x = " + p1.x + " , y = " + p1.y +
						" и точкой P2 c координатами x = " + p2.x + " , y = " + p2.y + " = " + distance(p1, p2));
	}

	public static void hello (String somebody) {
		System.out.println("Hello, " + somebody + "!");

	}

	public static double distance (Point p1, Point p2){
		return Math.sqrt( (p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y) );
	}

}