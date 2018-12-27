import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringHelperTest {

	// Remember the @Test annotation is *not* optional when doing JUnit tests!!
	@Test(timeout=100)
	public void truncateAInFirst2Positions() {
		StringHelper helper = new StringHelper();
		//String expectedOutput = "RTAA";
		//String actualOutput = helper.truncateAInFirst2Positions("RTAA");
		//assertEquals(expectedOutput,actualOutput); //if match=success
		
		// You pass input to the unit (method) you're testing, and test
		// if output is working as expected
		// REMEMBER: Cannot do testing if you don't know what the
		//				expected output is. You have to know what it means
		//				to fail or pass based on your input.
		
		//           output                                   input
		assertEquals("RTAA",helper.truncateAInFirst2Positions("RTAA"));
		assertEquals("BB",helper.truncateAInFirst2Positions("AABB"));
		assertEquals("BBB",helper.truncateAInFirst2Positions("BABB"));	
		
	}

}