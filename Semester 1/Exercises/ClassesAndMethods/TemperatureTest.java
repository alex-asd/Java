import java.util.Scanner;
public class TemperatureTest {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter temperature in fahrenheit");
		double ftemp = input.nextDouble();
		Temperature temp = new Temperature(ftemp);
		
		System.out.println("Fahrenheit : " + temp.getFtemp() + "\n" 
				+ "Celsius: " + temp.getCelsius() + "\n"
				+ "Kelvin: " + temp.getKelvin());
	}
}
