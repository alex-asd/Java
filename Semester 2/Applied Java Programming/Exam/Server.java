
public class Server implements Runnable
{

	private Channel ch;
	
	public Server(Channel ch)
	{
		this.ch = ch;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			String what = ch.accept();
			System.out.println(Thread.currentThread().getName() + " has received request of type" + "'" + what + "'");
			switch (what) 
			{
			case "new":
				System.out.println("Server creating new smthn");
				wait(500,1500);
				ch.reply("done with creating new smthn");
				break;
				
			case "delete":
				System.out.println("Server deleting smthn");
				wait(1000,1500);
				ch.reply("deleted successfully");
				break;
			}
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
