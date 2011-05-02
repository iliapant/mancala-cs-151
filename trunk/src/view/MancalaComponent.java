package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.GameModel;
import model.MancalaPit;
import model.MancalaShape;
import model.Pit;

/**
 * Creates the component that the shapes/board/buttons are painted on
 *
 */
@SuppressWarnings("serial")
public class MancalaComponent extends JComponent implements ChangeListener
{
    /**
     * Creates a new MancalaComponent
     */
    public MancalaComponent(GameModel aModel)
    {
        model = aModel;
        pits = new ArrayList<MancalaShape>();
        shapes = new ArrayList<Shape>();
        
        Rectangle2D.Double boardShape = new Rectangle2D.Double(20, 20, 950, 670); //the board shape
        
        //variables for pit locations
        final int PIT_WIDTH = 100;
        final int PIT_HEIGHT = 150;
        final int TOP_PIT_Y = 75;
        final double BOTTOM_PIT_Y = boardShape.getHeight() - TOP_PIT_Y - PIT_HEIGHT;
        
        setSize(920, 600);
        //top pits
        addShape(new Pit(PIT_WIDTH + PIT_WIDTH/4, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 0
        addShape(new Pit(2*PIT_WIDTH + PIT_WIDTH/2, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 1
        addShape(new Pit(3*PIT_WIDTH + 3*PIT_WIDTH/4, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 2
        addShape(new Pit(5*PIT_WIDTH, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 3
        addShape(new Pit(6*PIT_WIDTH + PIT_WIDTH/4, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 4
        addShape(new Pit(7*PIT_WIDTH + PIT_WIDTH/2, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 5
        //mancala pits 6
        addShape(new MancalaPit(PIT_WIDTH/4, 120, PIT_WIDTH, 3*PIT_HEIGHT)); 
        
        //bottom pits
        addShape(new Pit(PIT_WIDTH + PIT_WIDTH/4, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 7
        addShape(new Pit(2*PIT_WIDTH + PIT_WIDTH/2, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 8
        addShape(new Pit(3*PIT_WIDTH + 3*PIT_WIDTH/4, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 9
        addShape(new Pit(5*PIT_WIDTH, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 10
        addShape(new Pit(6*PIT_WIDTH + PIT_WIDTH/4, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 11
        addShape(new Pit(7*PIT_WIDTH + PIT_WIDTH/2, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 12
        //2nd mancala pit 13
        addShape(new MancalaPit((int)boardShape.getWidth()-PIT_WIDTH, 120, PIT_WIDTH, 3*PIT_HEIGHT));

        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                for(int i = 0; i < pits.size(); i++)
                {
                    if(pits.get(i).contains(e.getPoint()))
                    {
                        //move
                        
                    }
                }
            }
        });
        
        shapes.add(boardShape);
        setVisible(false);
    }
    
    /**
     * adds a new shape (pit or mancala) to the component
     * @param shape the shape to be added
     */
    public void addShape(MancalaShape shape)
    {
        pits.add(shape);        
    }
    
    /**
     * paints the component
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        for(Shape s: shapes)
            g2.draw(s);
        
        for(MancalaShape p: pits)
            p.draw(g2);
        
    }
    
    /**
     * updates the pits when a change occurs
     */
    @Override
    public void stateChanged(ChangeEvent c)
    {
        int[] pitsArr = model.getPits(); //array containing stones from gameModel
        int pitSize = pits.size(); //the size of pits
        //update the pits with the stones from the model
        for(int i = 0; i < pitSize; i++)
        {
            pits.get(i).setStones(pitsArr[i]);
        }
        
        repaint();
    }
    
    public void setBoardVisible(boolean visible)
    {
        setVisible(visible);
    }
    
    
    private ArrayList<Shape> shapes;
    private ArrayList<MancalaShape> pits;
    private GameModel model;
}
