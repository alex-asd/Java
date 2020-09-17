
public class TestBakery {

	public static void main(String[] args) 
	{
		NumberDispenser bakery = new NumberDispenser();
		
		Thread[] customers = new Thread[20];
		for (int i = 0; i < customers.length; i++) {
			Customer customer = new Customer(bakery);
			customers[i] = new Thread(customer, "Customer" + i);
			customers[i].start();
		}
		
		Thread[] clerks = new Thread[2];
		for (int i = 0; i < clerks.length; i++) {
			Clerk clerk = new Clerk(bakery);
			clerks[i] = new Thread(clerk, "Clerk" + i);
			clerks[i].start();
		}
	}
}
