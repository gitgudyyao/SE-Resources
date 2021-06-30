package FA;

import junitparams.JUnitParamsRunner;

import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TestFinancialAid {

	
	@Test
	@Parameters(method = "checkStatusParameter")
	public void checkStatusTest(double income, double CGPA, boolean PTPTNLoan, boolean scholar, boolean assist)
	{
		
		FinancialAid aid = new FinancialAid();
		aid.checkStatus(income, CGPA, PTPTNLoan);
		assertEquals(aid.haveScholarship(),scholar);
		assertEquals(aid.haveFinanceAssist(),assist);
		
	}

		private Object[] checkStatusParameter()
		{
			return new Object[] {
					new Object[] {4000, 3.69, false, true, false},
					new Object[] {2000, 2.00, false, true, false},
					new Object[] {4000, 3.69, true, false, true},
					new Object[] {2000, 2.69, true, false, true},
					new Object[] {2000, 3.69, false, true, true},
					new Object[] {5000, 2.50, false, false, false},
			};
		}

		@Test(expected=IllegalArgumentException.class)
		@Parameters(method="checkStatusInvalidParameter") 
		public void checkStatusInvalid(double income, double CGPA, boolean PTPTNLoan) {
			FinancialAid AID = new FinancialAid();
			AID.checkStatus(income, CGPA, PTPTNLoan);
			
		}

		private Object[] checkStatusInvalidParameter() {
			return new Object[] {
				new Object[] {-1000, 3.0, true},
				new Object[] {-2000,  3.5, false},
				new Object[] {500, 4.1, true},
				new Object[] {1500, 5.0, false},
				new Object[] {1500, -1.5, true},
				new Object[] {2500, -1.0, false},
			};
		}
		}