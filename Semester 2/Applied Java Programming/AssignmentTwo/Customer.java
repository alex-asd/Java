
public class Customer implements Runnable{

	private TakeANumber cust;
	
	public Customer(TakeANumber cust)
	{
		this.cust = cust;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			waitInLine(10000,15000);
			cust.takeNextNumber();
		}
	}
	
	private void waitInLine(int min, int max)
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
