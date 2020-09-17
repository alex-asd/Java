import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ReadBin {


	public static void main(String[] args)
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("numbers.bin");
			ObjectInputStream read = new ObjectInputStream(fileIn);
			while(true)
			{
				try
				{
					int x = read.readInt();
					double y = read.readDouble();
					System.out.println(x + " " + y); }
				catch(EOFException eof)
				{
					System.out.println("End of file");
					break; 
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
