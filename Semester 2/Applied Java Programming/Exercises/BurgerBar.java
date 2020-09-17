
public class BurgerBar {

	private int numberOfBurgers;
	private int maxBurgers;
	
	public BurgerBar(int maxBurgers)
	{
		this.maxBurgers = maxBurgers;
		numberOfBurgers = 0;
	}
	
	public void makeBurger(String empName)
	{
		if(numberOfBurgers >= maxBurgers)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(empName + " makes another burger (" +
				numberOfBurgers + " now)");
		numberOfBurgers++;
	}
	
	public synchronized void eatBurger(String who)
	{
		if(numberOfBurgers <= 0)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(who + " is ready to eat a burger (" +
				numberOfBurgers + " left)");
		numberOfBurgers--;
	}
	
	public int getBurgers()
	{
		return numberOfBurgers;
	}
}
