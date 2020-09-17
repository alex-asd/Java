
public class Philosopher implements Runnable{

	private int id;
	private Fork rightFork;
	private Fork leftFork;
	private boolean leftHanded;
	private boolean isFull;
	
	
	public Philosopher(int id, Fork lFork, Fork rFork, boolean leftHanded)
	{
		this.id = id;
		rightFork = rFork;
		leftFork = lFork;
		this.leftHanded = leftHanded;
		isFull = false;
	}


	@Override
	public void run() 
	{
		while (true) 
		{
			if(isFull)
			{
				doSomething("LETING THE OTHERS EAT, HE IS FULL", 15000,15000);
				isFull = false;
			}
			
			if(leftHanded)
			{
				doSomething("THINKING", 10000, 10000);
				leftFork.getFork();
				rightFork.getFork();
				if(rightFork.isItTaken() && !leftFork.isItTaken())
				{
					leftFork.putBackFork();
					rightFork.putBackFork();
				}
				doSomething("EATING", 5000, 5000);
				leftFork.putBackFork();
				rightFork.putBackFork();
				isFull = true;
			}
			else
			{
				doSomething("THINKING", 10000, 10000);
				rightFork.getFork();
				leftFork.getFork();
				if(rightFork.isItTaken() && !leftFork.isItTaken())
				{
					leftFork.putBackFork();
					rightFork.putBackFork();
				}
				doSomething("EATING", 5000, 5000);
				rightFork.putBackFork();
				leftFork.putBackFork();
				isFull = true;
			}
		}
	}
	
	private void doSomething(String what, int min, int max) 
	{
		System.out.println(Thread.currentThread().getName() + " is " +  what);
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
