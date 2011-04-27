package view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class MancalaComponent extends JComponent
{
    public MancalaComponent()
    {
        pits = new ArrayList<MancalaShape>();
        shapes = new ArrayList<Shape>();
        
        Rectangle2D.Double boardShape = new Rectangle2D.Double(20, 20, 900, 670); //the board shape
        
        //variables for pit locations
        final int PIT_WIDTH = 100;
        final int PIT_HEIGHT = 150;
        final int TOP_PIT_Y = 75;
        final double BOTTOM_PIT_Y = boardShape.getHeight() - TOP_PIT_Y - PIT_HEIGHT;
        
        setSize(920, 600);
        //top pits
        addShape(new Pit(2*PIT_WIDTH, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit
        addShape(new Pit(3*PIT_WIDTH + PIT_WIDTH/2, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit
        addShape(new Pit(5*PIT_WIDTH, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit
        addShape(new Pit(6*PIT_WIDTH + PIT_WIDTH/2, TOP_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit
        
        //bottom pits
        addShape(new Pit(2*PIT_WIDTH, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit
        addShape(new Pit(3*PIT_WIDTH + PIT_WIDTH/2, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit
        addShape(new Pit(5*PIT_WIDTH, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit
        addShape(new Pit(6*PIT_WIDTH + PIT_WIDTH/2, (int)BOTTOM_PIT_Y, PIT_WIDTH, PIT_HEIGHT)); //adds a pit
        
        //mancala pits
        addShape(new MancalaPit(PIT_WIDTH-20, 120, PIT_WIDTH, 3*PIT_HEIGHT));
        addShape(new MancalaPit((int)boardShape.getWidth()-PIT_WIDTH-40, 120, PIT_WIDTH, 3*PIT_HEIGHT));

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
        
        repaint();
    }
    
    public void addShape(MancalaShape shape)
    {
        pits.add(shape);        
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        for(Shape s: shapes)
            g2.draw(s);
        
        for(MancalaShape p: pits)
            p.draw(g2);
        
        
    }
    private ArrayList<Shape> shapes;
    private ArrayList<MancalaShape> pits;
}
