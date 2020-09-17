import java.io.*;
import java.util.Scanner;


public class StudentSave {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Student ico = new Student("HRI100", "100YANOV", "DENMARK");
		Student sasko = new Student("AL3KSANDAR", "100YANOV", "DENMARK");
		Student pepe = new Student("5UR", "100YANOV", "DENMARK");
		try {
			FileOutputStream fileOut = new FileOutputStream("Students.bin");
			ObjectOutputStream write = new ObjectOutputStream(fileOut);
			write.writeObject(ico);
			write.writeObject(sasko);
			write.writeObject(pepe);
			write.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found, or could not be opened");
			System.exit(9000);
		} 
		catch (IOException e) 
		{
			System.out.println("IO Error writing to file ");
			System.exit(9000);
		}
		System.out.println("Done writing");
	}
}

