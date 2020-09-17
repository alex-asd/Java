import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Write {
	public static void main(String[] args) 
	{
		try 
		{
			FileOutputStream fileOut = new FileOutputStream("Chauffeurs.bin");
			ObjectOutputStream write = new ObjectOutputStream(fileOut);
			write.writeObject(new Person("Allan", new MyDate(27, 6, 1980)));
			write.writeObject(new Person("Bob", new MyDate(10, 11, 1990)));
			write.writeObject(new Person("Carl", new MyDate(19, 10, 1987)));
			write.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found, or could not be opened");
			System.exit(1);
		} 
		catch (IOException e) 
		{
			System.out.println("IO Error writing to file");
			System.exit(1);
		}
		System.out.println("Done writing");
	}
}
