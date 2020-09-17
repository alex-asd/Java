
public class SuperMarket implements ISuperMarket {

	private int no;
	
	public SuperMarket()
	{
		no = 0;
	}
	
	@Override
	public synchronized void enterWaitingLine() 
	{
		System.out.println(Thread.currentThread().getName() + " has joined the waiting line");
		no++;
		System.out.println("Current number of clients: "+ no);
		try 
		{
			notifyAll();
			wait();
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void startNextServing() 
	{
		while(no == 0)
		{
			try 
			{
				System.out.println(Thread.currentThread().getName() + " is waiting for clients");
				notifyAll();
				wait();
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " is starting to serve the next client");
	}

	@Override
	public synchronized void serviceFinished() 
	{
			no--;
			System.out.println(Thread.currentThread().getName() + " has finished serving client " + no + " clients remaining");
			notifyAll();
	}

	
}
