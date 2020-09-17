import java.util.Scanner;
public class Exercise1 {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("The name of your city/town/village?");
		String name = input.nextLine();
		System.out.println("");

		int numberOfLetters = name.length();
		String upper = name.toUpperCase();
		String lower = name.toLowerCase();
		char firstChar = name.charAt(0);
		
		System.out.println("You are in: " + name + '\n' + " " + upper + '\n' +" " +
								lower + '\n' + firstChar + '\n' + "The number of letters is: "
								+ numberOfLetters);
	}
}
