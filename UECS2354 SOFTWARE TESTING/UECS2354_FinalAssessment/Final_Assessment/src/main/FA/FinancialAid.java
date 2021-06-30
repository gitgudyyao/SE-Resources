package FA;

public class FinancialAid {

private boolean scholarship, financeAssist;
	
	public FinancialAid() {
		scholarship = financeAssist = false;
	}
	
	public boolean haveScholarship() {
		return scholarship;
	}
	
	public boolean haveFinanceAssist() {
		return financeAssist;
	}
	
	public void checkStatus(double income, double CGPA, boolean PTPTNLoan) {
		
		if (income < 0 || CGPA < 0 || CGPA > 4.0)
			throw new IllegalArgumentException();
		
		if (income < 3000.0) {
			if (CGPA > 3.0) {
				scholarship = financeAssist = true;
			} else {
				if (PTPTNLoan) 
					financeAssist = true;
				else
					scholarship = true;
			}
		}
		else {
			if (CGPA > 3.0) {
				if (PTPTNLoan)
					financeAssist = true;
				else
					scholarship = true;
			} 			
		}
		
	}

}
