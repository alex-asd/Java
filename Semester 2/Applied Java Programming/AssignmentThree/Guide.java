
public class Guide implements Runnable{

	private AirportQueue usa;
	private AirportQueue non;
	
	public Guide(AirportQueue usa, AirportQueue non)
	{
		this.usa = usa;
		this.non = non;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			Passenger temp = nextPassenger();
			wait(2000,5000);
			if(temp.getNationality().equals("USA"))
				{
					System.out.println(Thread.currentThread().getName() + " has put "  + temp + " in the USA citizen queue");
					usa.putPassengerInQueue(temp);
				}
			else
				{
					System.out.println(Thread.currentThread().getName() + " has put "  + temp + " in the non-citizen queue");
					non.putPassengerInQueue(temp);					
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
	
	private Passenger nextPassenger()
	{
		int passNum = (int) Math.floor(Math.random() * 1000000);
		double nat = Math.random();
		String nationality = "";
		if(nat > 0.5)
			nationality = "USA";
		else
			nationality = "non-USA";
		return new Passenger(nationality, passNum);
	}
}
