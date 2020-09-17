package barber;

public class BarberRunnable implements Runnable{

	private Barber b;
	
	public BarberRunnable(Barber b)
	{
		this.b = b;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			Customer c = b.nextToBeCut();
			System.out.println(c + " will be cut next");
			wait(5000, 8000);
			System.out.println(c + " has a new haircut");
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
