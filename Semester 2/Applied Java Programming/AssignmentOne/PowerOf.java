
public class PowerOf {

	private long x;
	private long n;
	
	public PowerOf(long x, long n)
	{
		this.x = x;
		this.n = n;
	}
	
	public long getX() 
	{
		return x;
	}

	public void setX(long x) 
	{
		this.x = x;
	}

	public long getN() 
	{
		return n;
	}

	public void setN(long n) 
	{
		this.n = n;
	}

	public long power() 
	{
		return power(x, n);
	}
	
	public long power1()
	{
		return power1(x, n);
	}
	
	public long power2()
	{
		return power2(x, n);
	}

	private static long power(long x, long n) {
		if(n == 0) 
			return 1;
		if(n <= 1)
			return x;
		else
			return x * power(x, n - 1);
	}
	
	private static long power1(long x, long n)
	{
		long result = x;
		for (int i = 1; i < n; i++) 
		{
			result *= x;
		}
		return result;
	}
	
	public static long sqr(long x)
	{
		return x * x;
	}

	private static long power2(long x, long n) 
	{
		if(n == 0) 
			return 1;
		if(n == 1)
			return x;
		if(n % 2 == 0)
		{
			if(n / 2 == 1)
				return sqr(x);
			else
				return sqr(power2(x, n / 2));
		}
		else
			return x * power2(x, n - 1);
	}
}
