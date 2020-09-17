import java.util.Scanner;
import java.util.Random;
public class GuessNumber {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		int number = random.nextInt(11);
		
		System.out.println("Guess the number " + number);
		int entNumber = input.nextInt();
		
		while(entNumber != number)
		{
			System.out.println("Try again");
			entNumber = input.nextInt();
		}
		System.out.println("bravo we");
	}
	
}
