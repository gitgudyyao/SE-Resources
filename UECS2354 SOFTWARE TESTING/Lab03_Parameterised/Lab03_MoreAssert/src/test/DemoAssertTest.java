package test;
import static org.junit.Assert.*;
import org.junit.Test;

public class DemoAssertTest {
	
	@Test
	public void testAssertArrayEqualsPass() {
		
		int [] expectedResult = {1,2,3,4,5};
		int [] actualResult = {1,2,3,4,5};
		// Both arrays are same length and have exact contents
		// so this test should pass
		assertArrayEquals("Arrays are not equal !!", expectedResult, actualResult);
	}	
	
	@Test
	public void testAssertArrayEqualsFail() {
		
		int [] expectedResult = {1,2,3,4,6};
		int [] actualResult = {1,2,3,4,5};
		// Both arrays are same length but have different contents
		// so this test should fail
		assertArrayEquals("Arrays are not equal !! ", expectedResult, actualResult);
	}	
	
	@Test
	public void testAssertFalseAndAssertTruePass() {
		
		boolean firstCheck = (30 > 2); // results in true
		boolean secondCheck = (10 == 50); // results in false
		// firstCheck is true, so this test passes
		assertTrue("Error ! should be true", firstCheck);

		// secondCheck is false, so this test passes
		assertFalse("Error ! should be false", secondCheck );
	}	

	@Test
	public void testAssertFalseAndAssertTrueFail() {
		
		boolean firstCheck = (6 != 10); // results in true
		boolean secondCheck = (100 <= 99); // results in false

		// secondCheck is false, so this test fails
		assertTrue("Error ! should be true", secondCheck );
		
		// firstCheck is true, so this test fails
		assertFalse("Error ! should be false", firstCheck);
	}	

	@Test
	public void testAssertNullandAssertNotNull() {
		String str1 = null;
		String str2 = "hello there";
		
		// str1 is null, so this test passes
		assertNull("Error ! should be null", str1);
		
		// str2 refers to an object (i.e. it is not null)
		// so this test passes
		assertNotNull("Error ! should be not null", str2);
	}
	
	@Test
	public void testAssertSameAndAssertNotSame() {
		String str1 = "hello there";
		String str2 = str1;
		String str3 = new String("hello there");
		
		// both the reference variables str1 and str2 refer
		// to the same String object, so the test passes
		assertSame("reference variables do not refer to same object ! ", str1, str2);
		
		// str1 and str3 refer to different String objects
		// even though the String objects have the same literal value
		// therefore the test passes
		assertNotSame("reference variables refer to same object ! ", str1, str3);
	}

}
