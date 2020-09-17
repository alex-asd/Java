public class Exercise5 {
	public static void main(String[] args)
	{
		int shares;
		double priceOfBuy, priceOfSell, commision, moneySpend, moneyEarned, stockbroker1, stockbroker2, total;
		
		shares = 1000;
		priceOfBuy = 32.87;
		priceOfSell = 33.92;
		commision = 0.02;
		
		moneySpend = shares * priceOfBuy;
		moneyEarned = shares * priceOfSell;
		stockbroker1 = moneySpend * commision;
		stockbroker2 = moneyEarned * commision;
		total = moneyEarned - (moneySpend + stockbroker1 + stockbroker2);
		
		System.out.println("He spend: " + moneySpend + '\n' + "He earned: " + moneyEarned + '\n' + 
				"Paid to the stockbroker: " + stockbroker1 + " the 1st time and the 2nd: " + stockbroker2
				 + '\n' + "in total he earned: " + total
				);
	}
}
