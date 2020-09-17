
public class Client implements Runnable
{

	private Channel ch;
	
	public Client(Channel ch)
	{
		this.ch = ch;
	}
	
	
	@Override
	public void run() 
	{
		while(true)
		{
			wait(1000,15000);
			if(Math.random() > 0.5)
			{
				System.out.println(Thread.currentThread().getName() + " makes request type 'new'");
				String an = ch.call("new");
				if(an.equals("deleted successfully"))
				{
					an = ch.call("new");
				}
				System.out.println(Thread.currentThread().getName() + " receives " + an);
			}
			else
			{
				System.out.println(Thread.currentThread().getName() + " makes request type 'delete'");
				String an = ch.call("delete");
				if(an.equals("done with creating new smthn"))
				{
					an = ch.call("delete");
				}
				System.out.println(Thread.currentThread().getName() + " receives " + an);
			}
			wait(10000,25000);
		}
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
