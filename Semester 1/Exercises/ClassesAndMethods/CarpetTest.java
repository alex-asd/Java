import java.util.Scanner;
public class CarpetTest {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter width:");
		double w = input.nextDouble();
		System.out.println("Enter lenght:");
		double l = input.nextDouble();
		System.out.println("Enter cost per square foot:");
		double c = input.nextDouble();
		
		RoomDimension room = new RoomDimension(l, w);
		RoomCarpet carpet = new RoomCarpet(room, c);
		
		System.out.println(room);
		System.out.println(carpet);
	}
	
}
