package utility.math;

public class MyMath {

//	public static int factorial(int n)
//	{
//		
//	}
	public static int sum(int n)
	{
		if(n <= 1)
			return 1;
		return n + sum(n--);
	}
}
