// Name: 

class Player{
	double score=0;
	String lvl;
	
	public String initPlayer(String username){
		// codes check and return player's level based on username
		// there are 3 levels:
		//     I) Junior
		//    II) Senior
		//   III) Master
		return lvl;
	}
	
	public void startGame() {
		// codes to start playing
		// the final score will be stored in variable score
	}
	
	public double getScore() {
		return score;
	}
	
	public void updateLevel(String lvl) {
		// update the player's level
	}
}

public class MiniGame {
	String lvl, username="";
	double score=0;
	int duration=0;
	Player pl;
	
	// constructors
	public MiniGame() {
		pl = new Player();
	}
	
	public MiniGame(Player pl) {
		this.pl = pl;
	}
	
	
	public void startGame (String username) {
			
		lvl = pl.initPlayer(username);
		pl.startGame();
		score = pl.getScore();
	}
	
	// determine the bonus rate based on the player's level
	public int getBonus() {
		if (lvl.equals("Junior"))
			return 5;
		else if (lvl.equals("Senior"))
			return 10;
		else
			return 20;
	}
	
	// update player's level through player's updateLevel method
	public void updateLevel() {
		if (score<0)
			throw new IllegalArgumentException();
		if (score >= 0 && score <= 10000)
			lvl = "Junior";
		else if (score > 10000 && score <= 25000)
			lvl = "Senior";
		else if (score > 25000)
			lvl = "Master";
		pl.updateLevel(lvl);
	}

	// calculate the charge based on playing duration
	public double getCharge(int duration, boolean promo) {
		double charge=0;
		
		if (duration <= 0 || duration >360)
			throw new IllegalArgumentException();
		
		if (duration > 0 && duration <=30)
			if (promo)
				charge = duration * 3.5;
			else
				charge = duration * 4;
		else if (duration > 30 && duration <=120)
			if (promo)
				charge = duration * 2;
			else
				charge = duration * 2.5;
		else if (duration > 120 && duration <= 360)
			if (promo)
				charge = duration * 1;
			else
				charge = duration * 1.5;
		
		return charge;
	}
}
