import java.util.Scanner;
public class ReverseStrings {
	public static void main(String[] args)
	{
		String word;
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("Enter a word");
			word = input.nextLine();
			for(int i=word.length() - 1 ; i >= 0; i--)
			{
				System.out.print(word.charAt(i));
			}
			System.out.println("");
		}
		
		while(!word.equals("quit"));
	}
}
