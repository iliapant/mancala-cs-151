package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.GameModel;
import model.MancalaPitShape;
import model.PitShape;
import model.PitShape;
import model.ShapeFormatter;

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
    public MancalaComponent(GameModel aModel, ShapeFormatter formatter)
    {
        model = aModel;
        pits = new ArrayList<PitShape>();
        shapes = new ArrayList<Shape>();
        
        Rectangle2D.Double boardShape = new Rectangle2D.Double(20, 20, 950, 670); //the board shape
        
        //variables for pit locations
        final int PIT_WIDTH = 100;
        final int PIT_HEIGHT = 150;
        final int TOP_PIT_Y = 75;
        final double BOTTOM_PIT_Y = boardShape.getHeight() - TOP_PIT_Y - PIT_HEIGHT;
        
        setSize(920, 600);
        
        Color c = formatter.formatPitColor();
        //top pits
        PitShape p0 = new PitShape(PIT_WIDTH + PIT_WIDTH/4, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT, c);
        p0.setShape(formatter.formatPitShape(p1));
        
        PitShape p1 = new PitShape(2*PIT_WIDTH + PIT_WIDTH/2, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT, c); //adds a pit 1
        p1.setShape(formatter.formatPitShape(p2));

        PitShape p2 = new PitShape(3*PIT_WIDTH + 3*PIT_WIDTH/4, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT,c ); //adds a pit 2
        p2.setShape(formatter.formatPitShape(p3));

        PitShape p3 = new PitShape(5*PIT_WIDTH, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT,c); //adds a pit 3
        p3.setShape(formatter.formatPitShape(p4));

        PitShape p4 = new PitShape(6*PIT_WIDTH + PIT_WIDTH/4, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT,c); //adds a pit 4
        p4.setShape(formatter.formatPitShape(p5));

        PitShape mancalaPit1 = new PitShape(7*PIT_WIDTH + PIT_WIDTH/2, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT,c); //adds a pit 5
        mancalaPit1.setShape(formatter.formatPitShape(p6));

        addShape(p0);
        addShape(p1);
        addShape(p2);
        addShape(p3);
        addShape(p4);
        addShape(p5);
        
        //bottom pits
        addShape(new PitShape(PIT_WIDTH + PIT_WIDTH/4, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 7
        addShape(new PitShape(2*PIT_WIDTH + PIT_WIDTH/2, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 8
        addShape(new PitShape(3*PIT_WIDTH + 3*PIT_WIDTH/4, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 9
        addShape(new PitShape(5*PIT_WIDTH, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 10
        addShape(new PitShape(6*PIT_WIDTH + PIT_WIDTH/4, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 11
        addShape(new PitShape(7*PIT_WIDTH + PIT_WIDTH/2, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit 12
        //2nd mancala pit 13
        addShape(new MancalaPitShape((int)boardShape.getWidth()-PIT_WIDTH, 120, PIT_WIDTH, 3*PIT_HEIGHT));

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
    public void addShape(PitShape shape)
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
        
        for(PitShape p: pits)
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
    
    /**
     * sets the board to be visible or not
     * @param visible true if visible
     */
    public void setBoardVisible(boolean visible)
    {
        setVisible(visible);
    }
    
    public void format()
    {
        
    }
    
    public void setFormatter(ShapeFormatter sf)
    {
        formatter = sf;
    }
    

    
    
    private ArrayList<Shape> shapes;
    private ArrayList<PitShape> pits;
    private GameModel model;
    private ShapeFormatter formatter;
}
