
public class CarTest {
	public static void main(String[] args)
	{
		Car Porsche = new Car(2013, "Porsche");
		System.out.println("Our car is a " + Porsche.getMake() + 
				" and our current speed is " + Porsche.getSpeed() + " km/h");
		Porsche.acc();
		System.out.println("Speed: " + Porsche.getSpeed());
		Porsche.acc();
		System.out.println("Speed: " + Porsche.getSpeed());
		Porsche.acc();
		System.out.println("Speed: " + Porsche.getSpeed());
		Porsche.acc();
		System.out.println("Speed: " + Porsche.getSpeed());
		Porsche.acc();
		System.out.println("Speed: " + Porsche.getSpeed());
		
		Porsche.br();
		System.out.println("Speed: " + Porsche.getSpeed());
		Porsche.br();
		System.out.println("Speed: " + Porsche.getSpeed());
		Porsche.br();
		System.out.println("Speed: " + Porsche.getSpeed());
		Porsche.br();
		System.out.println("Speed: " + Porsche.getSpeed());
		Porsche.br();
		System.out.println("Speed: " + Porsche.getSpeed());
		
	}
}
