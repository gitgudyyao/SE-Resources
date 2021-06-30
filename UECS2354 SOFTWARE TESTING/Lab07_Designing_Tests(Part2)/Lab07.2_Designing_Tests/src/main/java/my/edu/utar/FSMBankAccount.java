package my.edu.utar;

enum AccountStates
{ present, overdraft, overdrawn, empty}

enum AccountEvents
{ addMoney, withdrawMoney }

public class FSMBankAccount {

	private int overdraftLimit = -500;
    private int currentBalance = 0;
	private AccountStates currentState = AccountStates.empty;
	
	public FSMBankAccount(int overdraftLimit, int currentBalance, AccountStates currentState) {
		this.overdraftLimit = overdraftLimit;
		this.currentBalance = currentBalance;
		this.currentState = currentState;
	}
    
    public int getOverdraftLimit() {
		return overdraftLimit;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public AccountStates getCurrentState() {
		return currentState;
	}

    public void processEvent(AccountEvents eventToDo, int amount)
    {
    	if (eventToDo == AccountEvents.addMoney) {
    		currentBalance += amount;
    		switch (currentState) {
    			case empty: 
    			case present:
    				currentState = AccountStates.present;
    			break;
    			case overdraft:
    			case overdrawn:
	    			if (currentBalance > 0)
	    				currentState = AccountStates.present;
	    			else if (currentBalance == 0 && currentState == AccountStates.overdrawn)
	    				currentState = AccountStates.empty;
	    			else if (currentBalance < 0)
	    				currentState = AccountStates.overdrawn;
	    			else
	    				throw new IllegalArgumentException();
	    			break;
    		}
        }
    	else if (eventToDo == AccountEvents.withdrawMoney)
    	{
    		currentBalance -= amount;
    		if (currentBalance < overdraftLimit)
    			currentBalance = overdraftLimit;
    		switch (currentState) {
    			case present:
    			case overdrawn:
	    			if (currentBalance == overdraftLimit)
	    				currentState = AccountStates.overdraft;
	    			else if (currentBalance < 0)
	    				currentState = AccountStates.overdrawn;
	    			else if (currentBalance == 0)
	    				currentState = AccountStates.empty;
	    			else 
	    				currentState = AccountStates.present;
	    			break;
    			case empty:
    				if (currentBalance == overdraftLimit)
    					throw new IllegalArgumentException();
    				currentState = AccountStates.overdrawn;
    				break;
    			case overdraft:
    				break;
    		}
    	}
    }
}
	
	


