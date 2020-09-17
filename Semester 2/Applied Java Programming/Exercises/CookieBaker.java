
public class CookieBaker implements Runnable{

	private CookieJar jar;
	public CookieBaker(CookieJar jar)
	{
		this.jar = jar;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			baking(); 
			jar.bakingCookies();
		}
	}
	
	public void baking()
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
			// nth
		}
	}
}
