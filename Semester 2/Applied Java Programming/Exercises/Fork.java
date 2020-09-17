
public class Fork {

	private int id;
	private boolean isTaken;
	
	public Fork(int id)
	{
		this.id = id;
		isTaken = false;
	}
	
	public synchronized void getFork()
	{
		if(isTaken)
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				// nothing
			}
		}
		isTaken = true;
		System.out.println(Thread.currentThread().getName() + " has taken fork " + id);
	}
	
	public synchronized void putBackFork()
	{
		isTaken = false;
		System.out.println(Thread.currentThread().getName() + " has put the fork " + id + " down");
	}
	
	public boolean isItTaken()
	{
		return isTaken;
	}
}
