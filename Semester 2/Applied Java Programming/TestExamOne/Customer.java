public class Customer implements Runnable{

	private SuperMarket sup;
	
	public Customer(SuperMarket sup)
	{
		this.sup = sup;
	}

	@Override
	public void run() 
	{
		int i = 2;
		while(i > 0)
		{
			sup.enterWaitingLine();
			wait(10000,20000);
			i--;
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