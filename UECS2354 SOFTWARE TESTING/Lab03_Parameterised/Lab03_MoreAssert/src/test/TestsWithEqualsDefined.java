package test;
import static org.junit.Assert.*;
import org.junit.Test;

import program.NewStudent;

public class TestsWithEqualsDefined {	
	@Test
	public void testCheckHumanAge() {		
		NewStudent stud1 = new NewStudent("Ah Beng", 25);
		NewStudent stud2 = stud1;
		NewStudent stud3 = new NewStudent("Ah Beng", 25);
		
		assertSame(stud1, stud2);
		assertNotSame(stud1, stud3);
		assertEquals(stud1, stud3);
	}
}