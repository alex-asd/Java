import java.util.Scanner;
public class AgeNgender {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your gender (Male/Female | M/F)");
		String gender = input.nextLine();
		char genderChar = gender.charAt(0);
		System.out.println("Now enter your age");
		int age = input.nextInt();
		
		if(((genderChar != 'M') && (genderChar != 'F') && (genderChar != 'm') && (genderChar != 'f')) || age <= 0)
		{
			System.out.println("Error in what u entered");
		}
		else if(((genderChar == 'M') || (genderChar == 'm')) && (age <= 18))
		{
			System.out.println("Boy");
		}
		
		else if(((genderChar == 'M') || (genderChar == 'm')) && (age >= 18))
		{
			System.out.println("Man");
		}
		
		
		else if(((genderChar == 'F') || (genderChar == 'f')) && (age <= 18))
		{
			System.out.println("Girl");
		}
		
		else if(((genderChar == 'F') || (genderChar == 'f')) && (age >= 18))
		{
			System.out.println("Woman");
		}
	}
}
