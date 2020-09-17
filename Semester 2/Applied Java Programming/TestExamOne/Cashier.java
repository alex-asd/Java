
public class Cashier implements Runnable{

	private SuperMarket sup;
	
	public Cashier(SuperMarket sup)
	{
		this.sup = sup;
	}

	@Override
	public void run() 
	{
		while(true)
		{
			sup.startNextServing();
			wait(1000,6000);
			sup.serviceFinished();
			wait(5000,7000);
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
