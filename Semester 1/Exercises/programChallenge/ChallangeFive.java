package programChallenge;

public class ChallangeFive {
	public static void main(String args[])
	{
		double tax = 0.25; 
		int item1 = 80, item2 = 140, item3 = 230;
		double addedTax1, addedTax2, addedTax3;

		addedTax1 = item1 * tax;
		addedTax2 = item2 * tax;
		addedTax3 = item3 * tax;

		System.out.println("The item with price without tax costs: $" + item1 + " and with tax: $" + (addedTax1 + item1));
		System.out.println("The item with price without tax costs: $" + item2 + " and with tax: $" + (addedTax2 + item2));
		System.out.println("The item with price without tax costs: $" + item3 + " and with tax: $" + (addedTax3 + item3));
	}
}
