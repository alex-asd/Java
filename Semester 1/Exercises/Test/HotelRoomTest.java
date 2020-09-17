import java.util.Scanner;
public class HotelRoomTest {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		HotelRoom room1 = new HotelRoom(5, "Nikolay", 4500);
		HotelRoom room2 = new HotelRoom(6, 6000);
		
		System.out.println("Room: " + room1.getRoomNumber() + " is not for rent, it is rented by " + room1.getName());
		System.out.println("Room: " + room2.getRoomNumber() + " is for rent");
		
		room1.checkOut();
		room2.checkIn("Blago");
		System.out.println("Enter new rent");
		double rent;
		do
		{
			rent = input.nextDouble();
			room2.setRent(rent);
		}
		while(rent < 0);

		System.out.println(room1);
		System.out.println(room2);
	}
}
