
public class TestBucketSort {

	public static void main(String[] args) {
		Bucket b1 = new Bucket(5);
		
		// NOT A JUNIT TEST CLASS
		
		System.out.println(b1.toString());
		b1.insert(5);
		b1.insert(1);
		b1.insert(24);
		b1.insert(3);
		System.out.println(b1.toString());
		System.out.println(b1.getCount());
		b1.sort();
		System.out.println(b1.toString());
		System.out.println(b1.getCount());
		System.out.println(b1.getFirstElement());
		System.out.println("----------------------------------");
		int[] array = new int[5];
		int a = b1.copyBucketInto(array, 0);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
}
