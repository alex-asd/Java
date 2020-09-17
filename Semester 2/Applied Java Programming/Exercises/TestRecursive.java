
public class TestRecursive {

	public static void main(String[] args) {
		int[] arr = {1,5,3,5,6,7,2,4,8,9,5,4,15};
		System.out.println(linearSearch(5, arr, 0));
	}
	
	public static int linearSearch(int x, int[] array, int first) 
	{
		int c = 0;
		if (first >= array.length) 
		{
			return -1;
		}
		if (x == array[first]) 
		{
			c++;
		}
		if(first == array.length - 1)
		{
			return c;
		}
			
		return linearSearch(x, array, first + 1);
	}
}
