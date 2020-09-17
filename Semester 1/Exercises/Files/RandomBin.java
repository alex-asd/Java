import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class RandomBin {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("How many niggas do u vant?");
		int num = input.nextInt();
		try {
			FileOutputStream fileOut = new FileOutputStream("numbers.bin");
			ObjectOutputStream write = new ObjectOutputStream(fileOut);
			for (int i = 0; i < num; i++) {
				write.writeInt(((int)Math.floor(Math.random() * 10)));
				write.writeDouble(Math.pow(1.5, i));
			}
			write.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, or could not be opened");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO Error writing to file ");
			System.exit(1);
		}
		System.out.println("Done writing");
	}
}
