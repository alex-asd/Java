import java.io.*;
import java.util.Scanner;
public class Friends {
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of the file u shiet");
		String fileName = input.nextLine();
		fileName+=".txt";
		PrintWriter write = null;
		String name = "";
		try 
		{
			FileOutputStream fileOut = new FileOutputStream(fileName);
			write = new PrintWriter(fileOut);

		} catch (FileNotFoundException e) {
			System.out.println("File not found, or could not be opened");
			System.exit(9000);
		}
		
		System.out.println("Write ur friends m8");
		write.println(fileName);
		while(!(name.equals("DONE")))
		{
			System.out.println("Enter fr name");
			name = input.nextLine();
			if(name.equals("DONE"))
				break;
			write.println(name);
		}
		System.out.println("Done m8, check");
		write.close();
	}
}
