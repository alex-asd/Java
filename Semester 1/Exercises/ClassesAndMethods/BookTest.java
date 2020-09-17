import java.util.Scanner;
public class BookTest {
	public static void main(String[] args)
	{
		String author ,title;
		int pages;
		double price, priceDiscount;
		double discount = 0.2;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the author");
		author = input.nextLine();
		System.out.println("Enter the title");
		title = input.nextLine();
		System.out.println("Enter the price");
		price = input.nextDouble();
		System.out.println("Enter how much pages");
		pages = input.nextInt();
		Book gameOfThrones = new Book(author, title, price, pages);
		priceDiscount = price - (price*discount);
		gameOfThrones.setPrice(priceDiscount);
		
		input.nextLine();
		
		System.out.println("Enter the author");
		author = input.nextLine();
		System.out.println("Enter the title");
		title = input.nextLine();
		System.out.println("Enter the price");
		price = input.nextDouble();
		System.out.println("Enter how much pages");
		pages = input.nextInt();
		Book newBook = new Book(author, title, price, pages);
		newBook.setPrice(newBook.getPrice() - (newBook.getPrice() * discount));
		
		System.out.println(gameOfThrones);
		System.out.println(newBook);
		
		//System.out.println("Author: " + gameOfThrones.getAuthor() + " Title: " + gameOfThrones.getTitle()
				//+ " Price: " + gameOfThrones.getPrice() + " Price with discount: " + priceDiscount + 
				//" Pages: " + gameOfThrones.getPages());
		
		//System.out.println("Author: " + gameOfThrones.getAuthor() + " Title: " + gameOfThrones.getTitle()
				//+ " Price with discount: " + gameOfThrones.getPrice() + 
				//" Pages: " + gameOfThrones.getPages());
		
	}
}
