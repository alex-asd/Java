
public class Q2 {

	public static int simpleSelect(int[] arr, int k)
	{
		int i, j, newValue;
	      for (i = 1; i < arr.length; i++) {
	            newValue = arr[i];
	            j = i;
	            while (j > 0 && arr[j - 1] > newValue) {
	                  arr[j] = arr[j - 1];
	                  j--;
	            }
	            arr[j] = newValue;
	      }
		return arr[k - 1];
	}
	
	private static int partition(int[] arr, int first, int last)
	{
		int pivot = arr[first];
		
		int k = first;
		
		for (int i = first+1; i <= last; i++) 
		{
			if(arr[i] < pivot)
			{
				k++;
				swap(arr, i, k);
			}
		}
		swap(arr, first, k);
		return k;
	}

	
	public static int partialSelect(int[] arr, int k)
	{
		for(int i = 0; i >= k-1; i++)
		{
			int idx = findIndexOfSmallestElementIn(arr);
			swap(arr, i, idx);
		}
		return arr[k-1];
	}
	
	private static int findIndexOfSmallestElementIn(int[] arr)
	{
		int smallest = arr[0];
		int indexOfSmallest = 0; 
		for (int i = 1; i < arr.length; i++) 
		{
			if(smallest > arr[i])
			{
				indexOfSmallest = i;
			}
		}
		return indexOfSmallest;
	}
	
	private static void swap(int[] arr, int i, int idx)
	{
		int val = arr[i];
		arr[i] = arr[idx];
		arr[idx] = val;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 11, 2, 27, 4, 8, 15, 9};
//		int a = simpleSelect(arr, 4);
//		System.out.println(a);
		int a = partialSelect(arr, 4);
		System.out.println(a);
//		swap(arr,0 ,2); 
//		System.out.println(arr[0] + " " + arr[2]);
	}
}
