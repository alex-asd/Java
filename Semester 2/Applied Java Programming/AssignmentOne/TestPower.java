import static org.junit.Assert.*;

import org.junit.Test;

public class TestPower {

	PowerOf num = new PowerOf(5,2);
	 @Test
	   public void power()
	   {
		 assertEquals(25, num.power());
		 num.setN(3);
		 assertEquals(125, num.power());
		 num.setN(4);
		 assertEquals(625, num.power1());
	   }
	 
	 @Test
	   public void power1()
	   {
		 assertEquals(25, num.power1());
		 num.setN(3);
		 assertEquals(125, num.power1());
		 num.setN(4);
		 assertEquals(625, num.power1());
	   }
	 
	 @Test
	   public void power2()
	   {
		 assertEquals(25, num.power2());
		 num.setN(3);
		 assertEquals(125, num.power2());
		 num.setN(4);
		 assertEquals(625, num.power2());
	   }
}
