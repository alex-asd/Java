import java.util.InputMismatchException;
import java.util.Scanner;

public class MathTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		int y = 0;
		boolean suc = false;
		do
		{
			System.out.println("Enter x: ");
			try {
				x = scanner.nextInt();
				suc = true;
			} catch (InputMismatchException e) {
				System.out.println("You must enter an int");
				scanner.nextLine();
			}
		}
		while(!suc);
		System.out.println("Enter y: ");
		y = scanner.nextInt();
		System.out.println("x + y = " + (x + y));
		System.out.println("x - y = " + (x - y));
		try {
			System.out.println("x / y = " + (double)x / y);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("x * y = " + (x * y));
	}
}