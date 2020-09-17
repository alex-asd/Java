import java.util.Scanner;
public class Numbers2 {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int max = 0, mid = 0 , min = 0;
		
		if((a >= b) && (a>=c))
		{
			 max = a;
			if( b >= c)
			{
				mid = b;
				min = c;
			}
			else 
			{
				mid = c;
				min = b;
			}
		}
		
		else if((b >= a) && (b>=c))
		{
			max = b;
			if( a >= c)
			{
				mid = a;
				min = c;
			}
			else 
			{
				mid = c;
				min = a;
			}
		}
		
		else if((c >= b) && (c>=a))
		{
			max = c;
			if( b >= a)
			{
				mid = b;
				min = a;
			}
			else 
			{
				mid = a;
				min = b;
			}
		}
		System.out.println(max + " " + mid + " " + min);
	}
}
