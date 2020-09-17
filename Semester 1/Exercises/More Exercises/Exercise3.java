import java.util.Scanner;
public class Exercise3 {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("The tax = (in decimals, ex: 0.25)");
		double tax = input.nextDouble();
		System.out.println("Enter the price of the item ");
		int itemOne = input.nextInt();
		System.out.println("Do you want to enter another Item? (0 = no ; 1 = yes");
		int decision = input.nextInt();
		//if (decision == 1)
		//{
			//System.out.println("Enter the price of the second item");
			//int itemTwo; = input.nextInt();
		//}
		double addedTax1, addedTax2;

		addedTax1 = itemOne * tax;
		//addedTax2 = itemTwo * tax;
		

		System.out.println("The item with price without tax costs: $" + itemOne + " and with tax: $" + (addedTax1 + itemOne));
		//System.out.println("The item with price without tax costs: $" + itemTwo + " and with tax: $" + (addedTax2 + itemTwo));
	
	}
	}
}
