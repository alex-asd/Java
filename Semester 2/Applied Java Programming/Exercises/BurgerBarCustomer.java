
public class BurgerBarCustomer implements Runnable{

	private int burgersToEat;
	private String name;
	private BurgerBar bar;
	
	public BurgerBarCustomer(String name, int bg, BurgerBar b)
	{
		this.name = name;
		burgersToEat = bg;
		bar = b;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < burgersToEat; i++) 
		{
			bar.eatBurger(name);
//			System.out.println("Ico eats a big and mazen burger");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
