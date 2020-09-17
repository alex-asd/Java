
public class Task2 {

	public static void insertionSort(double[] t, int st, int dr) 
	{
		for (int i = st; i <= dr; i++) 
		{

			int index = i;

			while (index > 0 && t[index] < t[index - 1]) {

				double aux = t[index];
				t[index] = t[index - 1];
				t[index - 1] = aux;

				index--;
			}

		}
	}
	

	public static double mean(double[] A) 
	{

		double total = 0;
		for (int i = 0; i < A.length; i++)
			total += A[i];

		return total / A.length;
	}

	
	public static double median(double[] A) 
	{
		insertionSort(A, 0 , A.length - 1);
		
		if(A.length % 2 == 0)
		{
			return (A[(A.length / 2) - 1] + A[(A.length / 2)]) / 2;
		}
		else
		{
			return A[(int) Math.floor(A.length / 2)];
		}
	}
		
	public static double medianOfMedians(double[] A)
	{		
		int numberOfArrays = A.length / 5;
		int num = 0;
		
		double[] X = new double[numberOfArrays];
		
		for (int i = 0; i < X.length; i++) 
		{
			double[] subArray = new double[5];
			
			for (int j = 0; j < subArray.length; j++) 
			{
				subArray[j] = A[num];
				num++;
			}
			
			insertionSort(subArray, 0, subArray.length - 1);
			X[i] = subArray[2];
		}
		
		return median(X);
	}

	
	public static void main(String[] args) 
	{
		double[] arr = {0.2, 43.2, 33.111, 43.3, 94, 5512.3, 44.5, 69.43, 99.2, 100.1, 44.2, 4124.1, 4123.4, -23, 9,999};
		double[] arr2 = {1, 6, 5, 110, 3, 9};
		double[] arr3 = {-2, 6, 99, 1, 3};
//		System.out.println(medianOfMedians(arr));
//		System.out.println(median(arr));
//		System.out.println(mean(arr3));
//		System.out.println(mean(arr2));
//		System.out.println(mean(arr));
		
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i]);
		}
		
		System.out.println("---------------------");
		
		
		insertionSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i]);
		}
	}
	
}
