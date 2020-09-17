package barber;

public class Customer {
	private int number;

	public Customer(int number) 
	{
		this.number = number;
	}

	public int getNumber() 
	{
		return number;
	}
	
	public String toString()
	{
		return "Customer " + number;
	}
}