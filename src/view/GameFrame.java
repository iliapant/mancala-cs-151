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
        buttonsVisible = new boolean[2]; //holds if the buttons are visible. if they are both false display board
        
        //initialize to true for beginning of game
        buttonsVisible[0] = true;
        buttonsVisible[1] = true;
        JFrame frame = new JFrame();
        final GameModel model = new GameModel();
        mancalaComponent = new MancalaComponent(model);
        final JPanel panel = new JPanel();        
        //add buttons 3 and 4
        JButton button3 = new JButton("3");
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.setNumStones(3);
                setButtonVisible(false, panel);
                buttonsVisible[0] = false;
                model.setCurrentState("STARTED");
            }
        });
        
        JButton button4 = new JButton("4");
        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.setNumStones(4);
                setButtonVisible(false, panel);
                buttonsVisible[0] = false;
                model.setCurrentState("STARTED");
            }
        });
        
        JLabel label = new JLabel("How many stones?");
        panel.add(label);
        panel.add(button3);
        panel.add(button4);
        
        //strategy pattern buttons
        final JPanel stratPanel = new JPanel();
        JButton redButton = new JButton("Red, square");
        redButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //set to red squares
                buttonsVisible[1] = false;
                setButtonVisible(false, stratPanel);
            }
        });
        JButton blueButton = new JButton("Blue, circle");
        blueButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //set to blue circles
                buttonsVisible[1] = false;
                setButtonVisible(false, stratPanel);

            }
        });
        JLabel strategyLabel = new JLabel("Select board style");
        stratPanel.add(strategyLabel);
        stratPanel.add(redButton);
        stratPanel.add(blueButton);
        
        frame.setSize(1000, 750);
        frame.setTitle("Mancala");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mancalaComponent, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(stratPanel, BorderLayout.SOUTH);
        setButtonVisible(true, panel);
        setButtonVisible(true, stratPanel);
        frame.setVisible(true);

    }
    
    /**
     * sets the buttons on the frame visible or not depending on if the game is in session
     * @param visible true if visible
     */
    public void setButtonVisible(boolean visible, JPanel p)
    {
        p.setVisible(visible);
        
        if(!buttonsVisible[0] && !buttonsVisible[1])
        {
            mancalaComponent.setBoardVisible(true);
        }
    }
    private boolean[] buttonsVisible;
    private MancalaComponent mancalaComponent;
}
