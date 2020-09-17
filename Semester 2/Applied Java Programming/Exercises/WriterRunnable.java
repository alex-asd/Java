
public class WriterRunnable implements Runnable{

	private ReadWrite lock;
	
	public WriterRunnable(ReadWrite lock)
	{
		this.lock = lock;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			beforeNAfterWriting(4000, 6000);
			lock.acquireWrite();
			writing(8000,9000);
			lock.releaseWrite();
			beforeNAfterWriting(20000, 30000);
		}
	}

	private void beforeNAfterWriting(int min, int max) 
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
	
	private void writing(int min, int max) 
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