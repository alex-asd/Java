
public class CounterIncrementer implements Runnable{

	private Counter counter;
	private int updates;
	
	public CounterIncrementer(Counter counter, int updates)
	{
		this.counter = counter;
		this.updates = updates;
	}
	@Override
	public void run() 
	{
		for (int i = 0; i < updates; i++) 
		{
			try {
				counter.increment();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(counter.getValue() + ": " + Thread.currentThread().getName());
		}
		System.out.println(counter.getValue());
	}

}
