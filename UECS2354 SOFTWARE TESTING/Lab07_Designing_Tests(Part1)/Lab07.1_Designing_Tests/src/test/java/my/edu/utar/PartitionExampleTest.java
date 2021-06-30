package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.PartitionExample;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class PartitionExampleTest {
	
	PartitionExample pe = new PartitionExample();
	
	@Test
	@Parameters({"25,F", "55,D", "65,C", "75,B", "90,A" })
	public void testGetGradeValidValues(int mark, String expectedGrade) {
		String grade = pe.getGrade(mark);
		assertEquals(expectedGrade, grade);
	}	

	@Test(expected=IllegalArgumentException.class)	
	@Parameters({"-5", "120"})
	public void testGetGradeInvalidValues(int mark) {
		pe.getGrade(mark);
	}

}
