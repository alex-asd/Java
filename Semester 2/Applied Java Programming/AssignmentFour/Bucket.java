
public class Bucket {
	private int[] bucket;
	private int count; 
	// the next free place in the bucket
	/*
	 * size is the max number of elements that can be held in the bucket You may
	 * assume that the user of the bucket never inserts more than 'size'
	 * elements.
	 */

	public Bucket(int size) 
	{
		bucket = new int[size];
		count = 0;
	}

	/* Inserts x on the next free place in the bucket */
	public void insert(int x) 
	{
		count++;
		bucket[count - 1] = x;
	}

	/* Sorts bucket, using a simple sorting method */
	public void sort() {
		int i, j, newValue;
	      for (i = 1; i < bucket.length; i++) {
	            newValue = bucket[i];
	            j = i;
	            while (j > 0 && bucket[j - 1] > newValue) {
	                  bucket[j] = bucket[j - 1];
	                  j--;
	            }
	            bucket[j] = newValue;
	      }
	}

	
	public String toString()
	{
		String str = "";
		for (int i = 0; i < bucket.length; i++) {
			if(i == bucket.length - 1)
				str+= bucket[i];
			else
				str += bucket[i] + ",";
		}
		return str;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public int getFirstElement()
	{
		return bucket[0];
	}
	
	/*
	 * Copies the bucket elements into A; ‘first’ is the first place in A to
	 * copy an element from the bucket. Returns number of elements being copied
	 * from the bucket
	 */
	public int copyBucketInto (int[] A, int first)
	{
//		for (int i = 0; i < bucket.length; i++) {
//			if(bucket[i] != 0)
//				A[first] = bucket[i];
//		}
		int i = 0;
		while(i < bucket.length)
		{
			if(bucket[i] != 0)
				{
					A[first] = bucket[i];
					first++;
				}
			i++;
		}
		
		return first;
	}
}