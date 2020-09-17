
public class Task1 
{

	public static double dotProductIterative(double[] v, double[] w)
	{
		double total = 0;
		for (int i = 0; i < v.length; i++) 
		{
			double current = v[i] * w[i];
			total = total + current;
		}
		return total;
	}
	
	public static double dotProductRecursive(double[] v, double[] w, int k)
	{
		if(k == 1)
		{
			return v[0] * w[0];
		}
		if(k > 1)
		{
			return (v[k-1] * w[k-1]) + dotProductRecursive(v, w, k - 1);
		}
		else
			return -1;
	}
	
	public static double formula4(double[] v, double[] w)
	{
		double[][] n = new double[v.length][w.length];
		for (int i = 0; i < v.length; i++) 
		{
			for (int j = 0; j < w.length; j++) 
			{
				n[i][j] = v[j] * w[i];
			}
		}
		double total = 0;
		for (int i = 0; i < v.length; i++) 
		{
			total += n[i][i];
		}
		
		return total;
	}
	
	public static void main(String[] args) 
	{
		double[] v = {1, 6, 8, 3, 44};
		double[] w = {4, 3, 6, 3, 2};
		System.out.println(dotProductIterative(v,w));
		System.out.println(dotProductRecursive(v, w, 5));
		System.out.println(formula4(v,w));
	}
}
