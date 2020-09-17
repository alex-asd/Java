import java.util.Scanner;
public class Numbers {
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		int a, b, c;
		double d, x1, x2;
		System.out.println("Enter 3 integers");
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		
		d = b*b - (4*a*c);
		System.out.println("D = " + d);
		
		if(d > 0)
		{
			x1 = (-b + Math.sqrt(d)) / 2 * a ;
			x2 = (-b - Math.sqrt(d)) / 2 * a ;
			System.out.println("1st solution = " + x1 + " and 2nd one is = " + x2);
		}
		
		else if(d == 0)
		{
			x1=x2= (double)-b / 2 * a;
			System.out.println("one solution = " + x1);
		}
		
		else
		{
			System.out.println("There is no solution");
		}
	}	
}
