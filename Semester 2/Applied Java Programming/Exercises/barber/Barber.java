package barber;

public class Barber implements BarberShop{

	private QueueATD<Customer> chairs;
	
	public Barber(int chairs)
	{
		this.chairs = new BoundedArrayQueue<Customer>(chairs);
	}
	
	@Override
	public synchronized void wantsToBeCut(Customer c) 
	{
		while(chairs.isFull())
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e)
			{
				// don't do shit
			}
			finally
			{
				System.out.println(Thread.currentThread().getName() + " leaves because its full, he will be back");
			}
		}
		chairs.enqueue(c);
		notifyAll();
	}

	@Override
	public synchronized Customer nextToBeCut() 
	{
		while(chairs.isEmpty())
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) {
				// nth
			}
			fallsToSleep();
		}
		notifyAll();
		return chairs.dequeue();
	}

	private void fallsToSleep()
	{
		System.out.println("The barber falls to sleep");
	}
	
	private void wakeUp()
	{
		System.out.println("Customer has woken up the barber");
	}
}
