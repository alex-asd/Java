public class CookieEater implements Runnable{

	private CookieJar jar;
	public CookieEater(CookieJar jar)
	{
		this.jar = jar;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			eating();
			jar.eatingCookies();
		}
	}
	
	public void eating()
	{
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// nth
		}
	}
}