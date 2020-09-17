package ConfessionChair;

import java.util.ArrayList;

public class ConfessionChair {

	private ArrayList<String> sins;
	private boolean listening;
	
	public ConfessionChair()
	{
		listening = false;
//		sins = new ArrayList<String>();
//		initializeSins();
	}
	
	public synchronized int confession(String confession)
	{
		if(confession.equals("I killed a man"))
			return 99999;
		else if(confession.equals("Didn't listen to lecture"))
			return 10000000;
		else if(confession.equals("Cheated on wife"))
			return 50;
		else if(confession.equals("Cheated on husband"))
			return 10000000;
		else return (int)Math.random() * 1000;
	}
	
	public synchronized String listenToConfession(String confession)
	{
		while(listening)
		{
			try 
			{
				System.out.println("The priest is already listening to another");
				wait();
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(!listening)
		{
			try 
			{
				System.out.println("The priest is waiting for the next sinner");
				wait();
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return confession;
	}
	
	public synchronized void givePenance(int penalty)
	{
		System.out.println(Thread.currentThread().getName() + " has given the penalty of: " + penalty + " ave marias");
	}
	
//	private void initializeSins()
//	{
//		sins.add("Killed a man");
//		sins.add("Swore at relative");
//		sins.add("Shot 34 children with AK47");
//		sins.add("Played too much WoW");
//		sins.add("Didn't listen to lecture");
//		sins.add("Took someone else's wife");
//		sins.add("Cheated");
//	}
}
