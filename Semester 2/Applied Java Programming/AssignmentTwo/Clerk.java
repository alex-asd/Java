
public class Clerk implements Runnable{

	private TakeANumber clerk;
	
	public Clerk(TakeANumber clerk)
	{
		this.clerk = clerk;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			int next = clerk.nextCustomer() - 1;
			System.out.println(Thread.currentThread().getName() + " is serving customer with number: " + next);
			wait(3000,6000);
			System.out.println("Customer "+ next +" served");
		}
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
