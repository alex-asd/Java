
public class ReaderRunnable implements Runnable{

	private ReadWrite lock;
	
	public ReaderRunnable(ReadWrite lock)
	{
		this.lock = lock;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			beforeNAfterReading(4000, 8000);
			lock.acquireRead();
			reading(2000,3000);
			lock.releaseRead();
			beforeNAfterReading(5000, 10000);
		}
	}

	private void beforeNAfterReading(int min, int max) 
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
	
	private void reading(int min, int max) 
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
