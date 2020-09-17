import java.util.Scanner;
public class Age {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		if( age <= 0)
		{
			System.out.println("Error! You entered invalid age");
		}
		
		else if ( age <= 12)
		{
			System.out.println("Child");
		}
		
		else if ( age >= 13 && age <= 19)
		{
			System.out.println("Teenager");
		}
		
		else if ( age >= 20 && age <= 65)
		{
			System.out.println("Adult");
		}
		
		else if ( age > 65)
		{
			System.out.println("Your level is too damn high sir");
		}
		
		else
		{
			System.out.println("Error");
		}
	}
}
