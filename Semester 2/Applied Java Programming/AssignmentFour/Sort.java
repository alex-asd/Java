

public class Sort {
	private static Bucket b1;
	private static Bucket b2;
	private static Bucket b3;
	private static Bucket b4;
	
	public static int[] bucketSort(int[] A, int m)
	{
		b1 = new Bucket(m);
		b2 = new Bucket(m);
		b3 = new Bucket(m);
		b4 = new Bucket(m);
		for (int i = 0; i <= A.length - 1; i++) 
		{
			if(A[i] <= 25)
				b1.insert(A[i]);
			else if(A[i] > 25 && A[i] <= 50)
				b2.insert(A[i]);
			else if(A[i] > 50 && A[i] <= 75)
				b3.insert(A[i]);
			else
				b4.insert(A[i]);
		}
		b1.sort();
		b2.sort();
		b3.sort();
		b4.sort();
		int[] newArray = new int[A.length];
		int a = b1.copyBucketInto(newArray, 0);
		int b = b2.copyBucketInto(newArray, a);
		int c = b3.copyBucketInto(newArray, b);
		b4.copyBucketInto(newArray, c);
		return newArray;
	}
	public static void main(String[] args) 
	{
		int[] arr = {78, 17, 39, 26, 72, 84, 21, 4, 47, 12, 58, 87};
		int[] newfuckinarray = bucketSort(arr, 5);
		for (int i = 0; i < newfuckinarray.length; i++) {
			System.out.println(newfuckinarray[i]);
		}
	}
}
