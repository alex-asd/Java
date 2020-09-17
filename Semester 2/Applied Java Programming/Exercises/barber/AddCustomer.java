package barber;

public class AddCustomer implements Runnable{

	private Barber b;
	private Customer c;
	
	public AddCustomer(Barber b, Customer c)
	{
		this.b = b;
		this.c = c;
	}
	
	@Override
	public void run() 
	{
//		while(true)
//		{
			System.out.println(c + " has arrived to the barber shop");
			b.wantsToBeCut(c);
//		}
	}
	
	private void wait(int min, int max) 
	{
		long time = (long) (Math.random() * (max - min) + min);
		try 
		{
			Thread.sleep(time);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
