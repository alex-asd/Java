
public class Q1 {

	public static int gcd(int a, int b)
	{
		while(a != b)
		{
			if(a > b)
				a = a - b;
			else
				b = b - a;	
		}
		return a;
	}
	
	
	public static int gcd2(int a, int b)
	{
		if(a == b)
			return a;
		else if(a % b == 0)
			return b;
		else
			return gcd2(b, a%b);
	}
	
	public static int gcd3(int a, int b)
	{
		if(a == b)
			return a ;
		else if(a % 2 == 0 && b % 2 == 0)
		{
			return 2 * gcd3(a/2, b/2);
		}
		else if(a % 2 == 0 && b % 2 != 0)
		{
			return gcd3(a/2, b);
		}
		else if(a % 2 != 0 && b % 2 == 0)
		{
			return gcd3(a, b/2);
		}
		else if(a % 2 != 0 && b % 2 != 0 && a > b)
		{
			return gcd3(a - b, b);
		}
		else if(a % 2 != 0 && b % 2 != 0 && a < b)
		{
			return gcd3(a, b - a);
		}
		return  a;
	}
	
	
	public static void main(String[] args)
	{
//		System.out.println(gcd(6,24));
		System.out.println(gcd3(9,81));
		System.out.println(gcd3(12,3));
		System.out.println(gcd3(12,11));
		System.out.println(gcd3(25,25));
		System.out.println(gcd3(24,6));
//		System.out.println(gcd2(6,24));
//		System.out.println(gcd2(49,7));
//		System.out.println(gcd2(15,5));
//		System.out.println(gcd2(12,24));
	}
}
