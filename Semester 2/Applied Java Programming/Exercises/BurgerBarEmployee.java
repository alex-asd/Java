public class BurgerBarEmployee implements Runnable{

	private String name;
	private BurgerBar bar;
	
	public BurgerBarEmployee(String name, BurgerBar b)
	{
		this.name = name;
		bar = b;
	}

	@Override
	public void run()
	{
		while(true)
		{
			bar.makeBurger(name);
//			System.out.println(name +" prai oshte 1 burgerche za Icko");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}