package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GameModel;

public class GameFrame
{
    public GameFrame()
    {
        JFrame frame = new JFrame();
        MancalaComponent mancalaComponent = new MancalaComponent();
        GameModel model = new GameModel(this);
        panel = new JPanel();        
        //add buttons 3 and 4
        JButton button3 = new JButton("3");
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                stones = 3;
                
            }
        });
        
        JButton button4 = new JButton("4");
        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                stones = 4;
                
            }
        });
        
        JLabel label = new JLabel("How many stones?");
        panel.add(label);
        panel.add(button3);
        panel.add(button4);
        
        frame.setSize(1000, 750);
        frame.setTitle("Mancala");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mancalaComponent, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
    
    /**
     * sets the buttons on the frame visible or not depending on if the game is in session
     * @param visible true if visible
     */
    public void setButtonVisible(boolean visible)
    {
        panel.setVisible(visible);
    }
    
    private JPanel panel;
    private int stones;
}
