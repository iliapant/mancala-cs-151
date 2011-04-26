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
	private int[] pits;
	private int player;
	public boolean canMakeMove(int pitIndex)
	{
		return false;
	}
	public void makeMove(int pitIndex)
	{
		
	}
	// TODO: everything
	@Override
	public void stateChanged(ChangeEvent e)
	{
		// TODO Auto-generated method stub

	}

}
