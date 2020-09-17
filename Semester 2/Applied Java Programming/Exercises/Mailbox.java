
public class Mailbox extends Thread{

	private long maxFrequency;
	private int count;
	private final static long RUNTIME = 100000;
	
	public Mailbox(int count)
	{
		this.count = count;
		maxFrequency = 1000;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < count; i++) 
		{
			System.out.println("New mail in your mailbox...");
			try 
			{
				Thread.sleep(RUNTIME / 50);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
