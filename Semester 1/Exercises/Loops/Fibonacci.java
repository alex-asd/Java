
public class Fibonacci {
	public static void main(String[] args)
	{
		int a = 0;
		int b = 1;
		/**do
		{
			System.out.println(fibonacciNumber + fibonacciNumber2);
			fibonacciNumber = fibonacciNumber + fibonacciNumber2;
			fibonacciNumber2 = fibonacciNumber - fibonacciNumber2;
		}
		while(fibonacciNumber <= 20);**/
		
		for(int i=0; i <= 19; i++)
		{
			System.out.println("fib(" + i + ")" + (a + b));
			a = a + b;
			b = a - b;
		}
	}
}
