import java.util.Scanner;
public class QuestionOne {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Type an integer: ");
		int a = input.nextInt();
		System.out.println("Type an integer: ");
		int b = input.nextInt();
		System.out.println("Type an integer: ");
		int c = input.nextInt();
		System.out.println("The product of (" + a + "*" + b + ") is: " + a*b);
		System.out.println("The sum of (" + a + " " + b + ") is: " + (a + b));
		System.out.println("The quotient of (" + b + "/" + c + ") is: " + (double)b/c);
		System.out.println("The difference of (" + b + "-" + c + ") is: " + (b - c));
	}
}
