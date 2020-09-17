
public class PassportController implements Runnable{

	private AirportQueue queue;

	
	public PassportController(AirportQueue queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			Passenger temp = queue.getNextPassenger();
			System.out.println(Thread.currentThread().getName() + " is checking " + temp);
			wait(4000,15000);
			System.out.println(temp + " has been served, passport num: " + temp.getPassportNumber());
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
