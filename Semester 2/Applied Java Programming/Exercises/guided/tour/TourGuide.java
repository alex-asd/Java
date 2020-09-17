package guided.tour;

public class TourGuide implements Runnable{
	private Museum m;
	private int num;
	
	public TourGuide(Museum m)
	{
		this.m = m;
		num = 0;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			if(m.isFull())
			{
				m.startTour();
				System.out.println("The tour is starting");
				wait(6000,20000);
				m.endTour();
			}
			else
			{
				m.enter(nextVisitor());
				System.out.println("Visitor is entering");
				wait(500,3000);
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
	
	private Visitor nextVisitor()
	{
		num++;
		return new Visitor(num);
	}
	
}
