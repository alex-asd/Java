import static org.junit.Assert.*;
import org.junit.Before; import org.junit.After;
import org.junit.Test;
import java.util.Arrays;
import utility.math.*;
public class TestNaturalNumber
{
 @Before
 public void setUp() throws Exception
 { // nothing
 }
 @After
 public void tearDown() throws Exception
 { // nothing
 }
 @Test
 public void testConstructorAndGet()
 {
 NaturalNumber naturalNumber1 = new NaturalNumber(1);
 assertEquals(1, naturalNumber1.getValue());
 NaturalNumber naturalNumber2 = new NaturalNumber(2);
 assertEquals(2, naturalNumber2.getValue());
 NaturalNumber naturalNumber3 = new NaturalNumber(3510);
 assertEquals(3510, naturalNumber3.getValue());
 }
 
 @Test(expected = IllegalArgumentException.class)
 public void testConstructorException1()
 {
 NaturalNumber naturalNumber = new NaturalNumber(0);
 }
 @Test(expected = IllegalArgumentException.class)
 public void testConstructorException2()
 {
 NaturalNumber naturalNumber = new NaturalNumber(-18);
}
 @Test
 public void testSetAndGet()
 {
 NaturalNumber naturalNumber = new NaturalNumber(1);
 naturalNumber.setValue(2);
 assertEquals(2, naturalNumber.getValue());
 naturalNumber.setValue(17);
 assertEquals(17, naturalNumber.getValue());
 naturalNumber.setValue(991);
 assertEquals(991, naturalNumber.getValue());
 naturalNumber.setValue(1);
 assertEquals(1, naturalNumber.getValue());
 }

 @Test(expected = IllegalArgumentException.class)
 public void testSetValueException1()
 {
 NaturalNumber naturalNumber = new NaturalNumber(1);
 naturalNumber.setValue(0);
 }
 @Test(expected = IllegalArgumentException.class)
 public void testSetValueException2()
 {
 NaturalNumber naturalNumber = new NaturalNumber(1);
 naturalNumber.setValue(-18);
 }
 @Test
 public void testToString()
 {
 NaturalNumber naturalNumber = new NaturalNumber(1);
 assertTrue(naturalNumber.toString().contains("1"));

 naturalNumber.setValue(991);
 assertTrue(naturalNumber.toString().contains("991"));

 naturalNumber.setValue(45329659);
 assertTrue(naturalNumber.toString().contains("45329659"));
 }
 
 @Test
	public void testIsPrime()
	{
		NaturalNumber naturalNumber = new NaturalNumber(10);
		System.out.println("2.Should return false: " + naturalNumber.isPrime());
		naturalNumber.setValue(1);
		System.out.println("3.Should return false: " + naturalNumber.isPrime());
		naturalNumber.setValue(2);
		System.out.println("4.Should return true: " + naturalNumber.isPrime());
		naturalNumber.setValue(14);
		System.out.println("5.Should return false: " + naturalNumber.isPrime());
		
	}
} 