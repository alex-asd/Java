
public class Channel implements IChannel{

	private String message;
	
	public Channel()
	{
		message = null;
	}
	
	@Override
	public synchronized String call(String message) 
	{
		this.message = message;
		notifyAll();
		while(this.message.equals("new") || this.message.equals("delete"))
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.message;
	}

	@Override
	public synchronized String accept() 
	{
		while(message == null || message.equals("done with creating new smthn") || message.equals("deleted successfully"))
		{
			try 
			{
				wait();
				System.out.println("Server waiting for msg");
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public synchronized void reply(String answer) 
	{
		System.out.println("Server answers with " + answer);
		notify();
		this.message = answer;
	}

}
