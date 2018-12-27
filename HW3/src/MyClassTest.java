import static org.junit.Assert.*;
import org.junit.Test;

/* 
 * To create such a class, click on the 'src' directory
 * then click on File > New > JUnit Test Case
 */

public class MyClassTest {

	@Test
	public void testAdd() {
		// set up
		int x = 5;
		int y = 2;
		MyClass tester = new MyClass();
		// test              comment, expected, actual
		assertEquals("5 + 2 should be 7",7,tester.add(x, y));
	}
	
	@Test
	public void testMultiply() {
		// set up
		int x = 5;
		int y = 2;
		MyClass tester = new MyClass();
		// test              comment, expected, actual
		assertEquals("5 * 2 should be 10",10,tester.multiply(x, y));
		
	}	

}
