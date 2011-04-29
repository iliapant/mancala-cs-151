package model;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The model of the Mancala game.
 * 
 *
 */
public class GameModel implements ChangeListener
{
	public static final int PITS_NUM = 14;
	public static final int PLAYER_A_MANCALA = 6;
	public static final int PLAYER_B_MANCALA = 13;
	public static enum GameState {PLACING, ONGOING, ENDED};
	public static enum Player {A, B};
	private int[] pits;
	private Player currentPlayer;
	private GameState currentState;
	
	/**
	 * Basic Constructor of a GameModel.
	 */
	public GameModel()
	{
		pits = new int[PITS_NUM];
		currentPlayer = Player.A;
		currentState = GameState.PLACING;
	}
	
	/**
	 * Given a valid pitIndex, determine who owns it.
	 * 
	 * @param pitIndex
	 * @return the player that owns the pit
	 */
	
	private Player getPitOwner(int pitIndex)
	{
		if (pitIndex >= 0 && pitIndex < PLAYER_A_MANCALA)
			return Player.A;
		// If not assume it's player B's
		return Player.B;
	}
	
	/**
	 * Checks if moving from pitIndex is possible.
	 * 
	 * @param pitIndex the index of the pit
	 * @return true if move can be made, false otherwise
	 */
	public boolean canMakeMove(int pitIndex)
	{
		// Moves can be made only from valid pits
		if (pitIndex < 0 || pitIndex > PITS_NUM
				|| pitIndex == PLAYER_A_MANCALA
				|| pitIndex == PLAYER_B_MANCALA)
			return false;
		
		// Moves can be made only if the state of the game is ONGOING
		if (currentState != GameState.ONGOING)
			return false;
		
		// Moves can be made only from non-empty pits
		if (pits[pitIndex] == 0)
			return false;
		
		// Moves can be made only if the player owns the pit
		if (getPitOwner(pitIndex) != currentPlayer)
			return false;
		
		return true;
	}
	public void makeMove(int pitIndex)
	{
		
	}
	@Override
	public void stateChanged(ChangeEvent e)
	{
		// TODO Auto-generated method stub

	}
}
