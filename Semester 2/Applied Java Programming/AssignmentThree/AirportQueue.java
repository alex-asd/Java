
public class AirportQueue implements PassengerQueue{

	private LinkedQueue<Passenger> q;
	
	public AirportQueue()
	{
		q = new LinkedQueue<Passenger>();
	}
	
	@Override
	public synchronized void putPassengerInQueue(Passenger p) 
	{
		q.enqueue(p);
		notifyAll();
	}

	@Override
	public synchronized Passenger getNextPassenger() 
	{
		if(q.isEmpty())
		{
			try 
			{
				wait();
			}
			catch (InterruptedException e) {
				// nothing
			}
			notifyAll();
		}
		return q.dequeue();
	}
}
