import java.util.Scanner;
public class PrimeChecker {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n,i = 2;
		double result = 0;
		do
		{
			n = input.nextInt();
			while(i <= n / 2)
			{
				if (n % i == 0) 
				{
					result = 1;
			    }
				i++;
			}
			if(result == 1)
				System.out.println("is not prime");
			else
				System.out.println("is prime");
			System.out.println(3 % 2);
		}
		while(n<=0);
	}
}
