import java.util.Scanner;
public class PrintNumbers {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number");
		int n = input.nextInt();
		for(int i = 1; i <= n; i++)
			System.out.println(i);
		
		for(int j = 2; j <= n; j+=2)
			System.out.println(j);
		
		int x = 1;
		while(x<=n)
		{
			System.out.println(x*x);
			x++;
		}	
	}
}
