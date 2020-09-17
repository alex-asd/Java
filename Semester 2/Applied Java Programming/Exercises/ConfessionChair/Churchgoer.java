package ConfessionChair;

public class Churchgoer implements Runnable{
	
	private String sin;
	private ConfessionChair c;

	public Churchgoer(String sin, ConfessionChair c)
	{
		this.sin = sin;
		this.c = c;
	}
	
	@Override
	public void run() 
	{
		System.out.println(Thread.currentThread().getName() + " is going to the confession chair");
		wait(1000,4000);
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
