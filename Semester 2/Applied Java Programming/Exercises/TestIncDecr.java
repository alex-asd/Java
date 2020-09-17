
public class TestIncDecr {
	
	public static void main(String[] args)
	{
		Counter c1 = new Counter(-10,10);
//		Counter c2 = new Counter(-10,10);
		
		CounterIncrementer ci1 = new CounterIncrementer(c1,20);
		CounterIncrementer ci2 = new CounterIncrementer(c1,20);
		
		CounterDecrementer cd1 = new CounterDecrementer(c1,20);
		CounterDecrementer cd2 = new CounterDecrementer(c1,20);
		
		Thread thr1 = new Thread(ci1, "Increment 1");
		Thread thr2 = new Thread(ci2, "Increment 2");
		Thread thr3 = new Thread(cd1, "Decrement 1");
		Thread thr4 = new Thread(cd2, "Decrement 2");
		
		thr1.start();
		thr2.start();
		thr3.start();
		thr4.start();
//		
	}
}
