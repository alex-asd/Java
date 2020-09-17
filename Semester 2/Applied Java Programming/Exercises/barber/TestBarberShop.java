package barber;

public class TestBarberShop {

	public static void main(String[] args) {
		Barber b = new Barber(5);
		BarberRunnable barber = new BarberRunnable(b);
		Thread th1 = new Thread(barber);
		th1.start();
		
		Customer c1 = new Customer(1);
		Customer c2 = new Customer(2);
		Customer c3 = new Customer(3);
		Customer c4 = new Customer(4);
		Customer c5 = new Customer(5);
		Customer c6 = new Customer(6);
		Customer c7 = new Customer(7);
		Customer c8 = new Customer(8);
		
		AddCustomer customer = new AddCustomer(b, c1);
		Thread cust1 = new Thread(customer, "Customer 1");
		cust1.start();
		
		AddCustomer customer2 = new AddCustomer(b, c2);
		Thread cust2 = new Thread(customer2, "Customer 2");
		cust2.start();
		
		AddCustomer customer3 = new AddCustomer(b, c3);
		Thread cust3 = new Thread(customer3, "Customer 3");
		cust3.start();
		
		AddCustomer customer4 = new AddCustomer(b, c4);
		Thread cust4 = new Thread(customer4, "Customer 4");
		cust4.start();
		
		AddCustomer customer5 = new AddCustomer(b, c5);
		Thread cust5 = new Thread(customer5, "Customer 5");
		cust5.start();
		
		AddCustomer customer6 = new AddCustomer(b, c6);
		Thread cust6 = new Thread(customer6, "Customer 6");
		cust6.start();
		
		AddCustomer customer7 = new AddCustomer(b, c7);
		Thread cust7 = new Thread(customer7, "Customer 7");
		cust7.start();
		
		AddCustomer customer8 = new AddCustomer(b, c8);
		Thread cust8 = new Thread(customer8, "Customer 8");
		cust8.start();
	}
}
