import java.io.*;
import java.util.Scanner;
public class ReadBinObejcts {


	public static void main(String[] args)
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("Students.bin");
			ObjectInputStream read = new ObjectInputStream(fileIn);
			while(true)
			{
				try
				{
					Student p = (Student)read.readObject();
					System.out.println(p); 
					}
				catch(EOFException eof)
				{
					System.out.println("End of file");
					break; 
				} 
				catch (ClassNotFoundException e) {
					System.out.println("No such class");
					System.exit(9000);
				}
			}
			read.close(); 
			}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found, or could not be opened");
			System.exit(9000); 
		}
		catch(IOException e)
		{
			System.out.println("IO Error reading file");
			System.exit(9000); 
		}
	}
}