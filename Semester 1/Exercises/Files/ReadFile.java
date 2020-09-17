import java.io.*;
import java.util.Scanner;
public class ReadFile {
	
	public static void main(String[] args) 
	{
		Scanner read = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter filename u want to read");
		String fileName = input.nextLine();
		fileName += ".txt";
		try
		{
		FileInputStream fileIn = new FileInputStream(fileName);
		read = new Scanner(fileIn);
		}
		catch(FileNotFoundException e)
		{
		System.out.println("File not found, or could not be opened");
		System.exit(9000);
		}
		System.out.println("Content of the file: " + fileName);
		while(read.hasNext())
		{
		System.out.println(read.nextLine());
		}
		read.close();

	}
}
