
public class TestSup {

	public static void main(String[] args) 
	{
		SuperMarket market = new SuperMarket();
		
		Cashier cash = new Cashier(market);
		Thread cashier = new Thread(cash, "Jhonny the casher");
		cashier.start();
		
		Customer c1 = new Customer(market);
		Customer c2 = new Customer(market);
		Customer c3 = new Customer(market);
		Customer c4 = new Customer(market);
		
		Thread cus1 = new Thread(c1, "Gream");
		Thread cus2 = new Thread(c2, "Don");
		Thread cus3 = new Thread(c3, "Valentini");
		Thread cus4 = new Thread(c4, "Valentiniakos");
		
		cus1.start();
		cus2.start();
		cus3.start();
		cus4.start();	
	}
}
