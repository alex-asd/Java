
public class NumberDispenser implements TakeANumber{

	private int nextNumberToTake;
	private int nextNumberToBeServed;
	
	public NumberDispenser()
	{
		nextNumberToTake = 1;
		nextNumberToBeServed = 1;
	}
	
	@Override
	public synchronized void takeNextNumber() 
	{
//		int position = nextNumberToTake;						//works better without
//		while (nextNumberToBeServed < position) // no-one
//		{
//			try 
//			{
//				wait();
//			} 
//			catch (InterruptedException e)
//			{
//				// nth
//			} 
//			notifyAll();
//		}
		System.out.println(Thread.currentThread().getName() + " has taken the number: " + nextNumberToTake);
		nextNumberToTake++;
		notifyAll();
	}

	@Override
	public synchronized int nextCustomer() 
	{
		while(nextNumberToBeServed >= nextNumberToTake)
		{
			System.out.println("Wait for customers");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyAll();
		}
		nextNumberToBeServed++;
		return nextNumberToBeServed;
	}
}
