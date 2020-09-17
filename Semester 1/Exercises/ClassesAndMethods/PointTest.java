
public class PointTest {
	public static void main(String[] args)
	{
		Point p1 = new Point(4,4);
		Point p2 = new Point(10,2);
		System.out.println(p1);
		System.out.println(p2);
		
		p1.move(2, 2);
		p2.moveTo(2, 10);
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(
				Math.sqrt(
						(p2.getX() - p1.getX()) * (p2.getX() - p1.getX())
						+
						(p2.getY() - p1.getY()) * (p2.getY() - p1.getY())
						)
				);
	}
}
