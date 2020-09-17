
public class EatTimeBurgers {

	public static void main(String[] args)
	{
		BurgerBar bar1 = new BurgerBar(300);
		
		BurgerBarEmployee emp1 = new BurgerBarEmployee("Monko",bar1);
		BurgerBarEmployee emp2 = new BurgerBarEmployee("Penka",bar1);
		
		BurgerBarCustomer cus1 = new BurgerBarCustomer("Icko", 50, bar1);
		BurgerBarCustomer cus2 = new BurgerBarCustomer("Dimchu", 10, bar1);
		
		Thread thr1 = new Thread(emp1);
		Thread thr2 = new Thread(emp2);
		Thread thr3 = new Thread(cus1);
		Thread thr4 = new Thread(cus2);
		
		thr1.start();
		thr2.start();
		thr3.start();
		thr4.start();
	}
}
