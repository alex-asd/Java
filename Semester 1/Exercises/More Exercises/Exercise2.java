import java.util.Scanner;
public class Exercise2 {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("a = ");
		double a = input.nextDouble();
		System.out.println("b = ");
		double b = input.nextDouble();
		System.out.println("c = ");
		double c = input.nextDouble();
		double sum = (a + b + c);
		System.out.println(sum);
	}
}
