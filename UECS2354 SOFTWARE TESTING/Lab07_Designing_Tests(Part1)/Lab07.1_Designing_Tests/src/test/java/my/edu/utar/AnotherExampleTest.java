package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.AnotherExample;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class AnotherExampleTest {
	
	AnotherExample ae = new AnotherExample();
	
	@Test
	@Parameters(method="CombineStringParam")
	public void testCombineStringsValidValues(String words, int x, String expectedResult) {
		String result = ae.combineStrings(words, x);
		assertEquals(expectedResult, result);
	}
	
	private Object[] CombineStringParam(){
		return new Object[]{
			new Object[]{"cat mouse horse",10,""},
			new Object[]{"",2,""},
			new Object[]{"cat dog horse",3,"horse"},
			new Object[]{"mouse house boat",4,"mouse house"},
			new Object[]{"cat dog",-5,"cat dog"}
		};
	}

	
	@Test
	public void testCombineStringsInvalidValuesV1() {
		ae.combineStrings(null, 5);
	}

}
