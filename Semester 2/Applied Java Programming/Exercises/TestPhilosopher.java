
public class TestPhilosopher {

	public static void main(String[] args) 
	{
		Fork[] forks = new Fork[5];
		for (int i = 0; i < forks.length; i++) {
			forks[i] = new Fork(i);
		}
		
		Thread[] philosophers = new Thread[forks.length];
		for (int i = 0; i < philosophers.length; i++) 
		{
			boolean bol = true;
			if(i % 2 == 0)
				bol = false;
			Philosopher philosopher = new Philosopher(i, forks[i], forks[(i+1) % forks.length], bol);
			philosophers[i] = new Thread(philosopher, "Phil" + i);
			philosophers[i].start();
		}
	}
}
