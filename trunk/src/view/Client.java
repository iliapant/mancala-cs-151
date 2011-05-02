package view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GameModel;

import view.MancalaComponent;

/**
 * Client class. Contains the main method that starts the game. Creats the JFrame
 */
public class Client 
{

    /**
     * Creates the frame
     * @param args the args
     */
    public static void main(String[] args)
    {
        GameFrame frame = new GameFrame();
    }

}
