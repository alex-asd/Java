package model;

public class Timer extends Thread{

	private Clock clock;
	private String time;
	
	public Timer(Clock clock)
	{
		this.clock = clock;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			if(clock.getCurrentTime().equals(time))
			{
				System.out.println("RABOTIWE");
				break;
			}
		}
	}

	
}
