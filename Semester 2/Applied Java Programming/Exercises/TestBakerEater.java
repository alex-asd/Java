
public class TestBakerEater {

	public static void main(String[] args)
	{
		CookieJar jar = new CookieJar();
		
		CookieBaker b1 = new CookieBaker(jar);
		CookieBaker b2 = new CookieBaker(jar);
		
		CookieEater e1 = new CookieEater(jar);
		CookieEater e2 = new CookieEater(jar);
		CookieEater e3 = new CookieEater(jar);
		CookieEater e4 = new CookieEater(jar);
		CookieEater e5 = new CookieEater(jar);
		CookieEater e6 = new CookieEater(jar);
		
		Thread thr1 = new Thread(b1, "Baker Jhon");
		Thread thr2 = new Thread(e1, "Piggy eater");
		Thread thr3 = new Thread(e2, "Icko");
		Thread thr4 = new Thread(e3, "Lacho");
		Thread thr5 = new Thread(e4, "Asen");
		Thread thr6 = new Thread(e5, "I petar");
		Thread thr7 = new Thread(e6, "Icko pak");
		Thread thr8 = new Thread(b2, "Baker Matiu");
		
		thr4.start();
		thr5.start();
		thr1.start();
		thr2.start();
		thr3.start();
		thr6.start();
		thr7.start();
		thr8.start();
	}
}
