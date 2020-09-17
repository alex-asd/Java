
public class Program extends Thread{

	private String program;
	private long maxFrequency;
	private String action;
	private int count;
	private final static long RUNTIME = 100000;
	private int variable;
	
	public Program(String program, String action, int count)
	{
		this.program = program;
		this.action = action;
		this.count = count;
//		double r = Math.random();
//		if(r < 0.3)
//		{
//			variable = 30;
//		}
//		else if((r > 0.5) && (r <0.8))
//			variable = 40;
//		else 
//			variable = 50;
	}
	@Override
	public void run() 
	{
		for (int i = 0; i < count; i++) 
		{
			System.out.println(program + " " + action + " ");
			try 
			{
				Thread.sleep(RUNTIME / count);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
