// Name: 

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TestMiniGame {
	
	// ================= Part 1 ======================

	
	// Methods to test getCharge()
	@Test
	@Parameters(method = "getChargeParam")
	public void getChargeTest(int duration ,boolean promo , double expectedChange)
	{
		
		
		MiniGame mini = new MiniGame();
		double actualChange =mini.getCharge(duration, promo);
		assertEquals(actualChange,expectedChange,0.0);
		
	}
	
	private Object[] getChargeParam()
	{
		return new Object[] {
				new Object[] {1,true,3.5},
				new Object[] {30,true,105.0},
				new Object[] {31,true,62.0},
				new Object[] {120,true,240.0},
				new Object[] {121,true,121.0},
				new Object[] {360,true,360.0},
				new Object[] {1,false,4.0},
				new Object[] {30,false,120.0},
				new Object[] {31,false,77.5},
				new Object[] {120,false,300.0},
				new Object[] {121,false,181.5},
				new Object[] {360,false,540.0}
		};
	}

	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="getChargeInvalidParams")
	public void GetChargeTestInvalid(int duration, boolean promo) {
		
		MiniGame mg = new MiniGame();
		double actualCharge = mg.getCharge(duration, promo);
		
	}
	
	private Object[] getChargeInvalidParams() {
		return new Object[] {
			new Object[] {0, true},
			new Object[] {0, false},
			new Object[] {361, true},
			new Object[] {361, false}
		};
	}
	
	
	
	// ================= Part 2 ======================
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="updateLevelInvalidParams")
	public void updateLevelTestInvalid(double score) {
		
	Player playerMock = mock(Player.class);
	when (playerMock.getScore()).thenReturn(score);
	
	MiniGame mg = new MiniGame(playerMock);
	mg.startGame(anyString());
	mg.updateLevel();

		
	}
	
	private Object[] updateLevelInvalidParams() {
		return new Object[] {
			new Object[] {-1.0}
	};
	}
	
	
	// Methods to test getBonus() and updateLevel()
	@Test
	@Parameters(method ="getBonusParam")
	public void getBonusTest(String level, int expectedBonus)
	{
		Player playerMock = mock(Player.class);
		when (playerMock.initPlayer(anyString())).thenReturn(level);
		
		MiniGame minigame = new MiniGame(playerMock);
		minigame.startGame(anyString());
		int actualBonus= minigame.getBonus();
		
		assertEquals(actualBonus,expectedBonus);
	}
	
	private Object[] getBonusParam()
	{
		return new Object[] {
				new Object[] {"Junior",5},
				new Object[] {"Senior",10},
				new Object[] {"Master",20},

		};
	}
	
	
	@Test
	@Parameters(method ="updateLevelParam")
	public void updateLevelTest(String level,double score,String expectedLevel)
	{
		Player playerMock = mock(Player.class);
		when (playerMock.initPlayer(anyString())).thenReturn(level);
		when (playerMock.getScore()).thenReturn(score);
		
		MiniGame minigame = new MiniGame(playerMock);
		minigame.startGame(anyString());
		minigame.updateLevel();

		verify(playerMock).updateLevel(expectedLevel);
	}
	
	private Object[] updateLevelParam(){
		return new Object[] {
			new Object[] {"Junior",0,"Junior"},
			new Object[] {"Junior",10000,"Junior"},
			new Object[] {"Junior",10001,"Senior"},
			new Object[] {"Junior",25000,"Senior"},
			new Object[] {"Junior",25001,"Master"}
		};
	}
}
