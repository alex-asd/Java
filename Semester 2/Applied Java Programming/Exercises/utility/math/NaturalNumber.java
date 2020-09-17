package utility.math;

import java.util.ArrayList;

public class NaturalNumber {

	private int value;
	
	public NaturalNumber(int value) throws IllegalArgumentException
	{
		if(value < 1)
		{
			throw new IllegalArgumentException();
		}
		this.value = value;
	}
	
	public void setValue(int value)
	{
		if(value < 1)
		{
			throw new IllegalArgumentException();
		}
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String toString()
	{
		return "Value = " + value;
	}
	
	public int[] getPrimeFactors()
	{
		int value = this.value;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int i = 2;
		while(value > 1)
		{
			while(value % i == 0)
			{
				factors.add(i);
				value = value / i;
			}
			i++;
		}
		return convertToIntArray(factors);
	}
	
	private static int[] convertToIntArray(ArrayList<Integer> arrList)
	{
		int[] temp = new int[arrList.size()];
		for (int i = 0; i < arrList.size(); i++) 
		{
			temp[i] = arrList.get(i);
		}
		return temp;
	}
	
	public boolean isPrime()
	{
		if(value <= 1)
			return false;
		for(int i = 2; i < value; i++) 
		{
			if(value %  i == 0)
				return false;
		}
			return true;
	}
	
	public boolean isPrimePower()
	{
		if(value <= 1)
			return false;
		else if(isPrime())
			return false;
		for (int i = 2; i < value; i++)
		{
			for (int j = i+1; j < value; j++) 
			{
				if((value % i == 0) && (value % j == 0))
					return false;
			}
		}
		return true;
	}
	
	public String getValueInBase(int base)
	{
		return getValueInBase(value, base);
	}
	
	private String getValueInBase(int value, int base)
	{
		if(value <= 0)
			return "";
		if((value % base > 9) && base < 36)
		{
			return getValueInBase(value/base, base) + ((char)('A' + ((value % base) - 10)));
		}
		if(base >= 36)
		{
			long a = value % (base * base);
			long b = value % base;
			long c = value - ((base * base * a) + base * b);
			return getValueInBase(value/base, base) + a + "." + b + "." + c;
		}
			
		else 
			return getValueInBase(value/base, base) + (value % base);
	}
	
}
