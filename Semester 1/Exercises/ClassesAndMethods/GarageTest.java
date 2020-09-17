
public class GarageTest {
	public static void main(String[] args)
	{
		Garage garage = new Garage();
		Garage garage2 = new Garage();
		Car porsche = new Car("Porsche", "911 GT3 Turbo", "Black", "5SA4FS332", 2013);
		Car lambo = new Car("Lamborghini", "Reventon", "Red", 2015);
		
		
		System.out.println(garage.isParkingAreaTaken(1));
		System.out.println(garage.isParkingAreaTaken(2));
		garage.park(porsche, 1);
		garage.park(lambo, 2);
		garage2.park(porsche, 2);
		garage2.park(lambo, 1);
		System.out.println("Garage 1: " + garage + '\n');
		System.out.println("Garage 2: " + garage2 + '\n');
		System.out.println(garage.equals(garage2));
		System.out.println(garage2.leaveGarage(1));
		System.out.println(garage2.leaveGarage(2));
		garage2.park(porsche, 1);
		garage2.park(lambo, 2);
		System.out.println(garage.equals(garage2));
		
	}
}
