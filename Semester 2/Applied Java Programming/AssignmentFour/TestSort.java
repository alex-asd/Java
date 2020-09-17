import static org.junit.Assert.*;

import org.junit.Test;

public class TestSort {

	
	Bucket b1 = new Bucket(5);
	
	@Test

	public void testInsert()
	{
		b1.insert(1);
		b1.insert(3);
		b1.insert(5);
		b1.insert(24);
		assertEquals("1,3,5,24", b1.toString());
		System.out.println(b1.toString());
	}
	
}
