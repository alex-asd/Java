
public class CookieJar {

	private int plate;
	private int cookies;
	
	public CookieJar()
	{
		plate = 16;
		cookies = 0;
	}
	
	public void setPlate(int newPlate)
	{
		plate = newPlate;
	}
	
	public int getPlate()
	{
		return plate;
	}
	
	public synchronized void bakingCookies()
	{
		while(cookies > 5)
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				// nothing
			}
		}
		System.out.println(Thread.currentThread().getName() + " has baked " + plate + " cookies");
		cookies+=plate;
		notifyAll();
	}
		
	public synchronized void eatingCookies()
	{
		while(cookies < 1)
		{
				try 
				{
					wait();
				} 
				catch (InterruptedException e) 
				{
					// nth
				}
		} 
		System.out.println(Thread.currentThread().getName() + " had eaten 1 cookie");
		cookies--;
		notifyAll();
	}
}
