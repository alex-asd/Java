
public class Mathmatical {
	public static void main(String[] args)
	{
		int a = 30;
		int b = 1;
		double x = 0;
		
		for(int i = 0; i < 30; i++)
		{
			double c = (double)b/a;
			x = x + c;
			System.out.println(x);
			a--;
			b++;
		}
	}
}
