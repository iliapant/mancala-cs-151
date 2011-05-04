package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *  Creates a pit or mancala
 *
 */
public class PitShape
{
    /**
     * Creates a new Mancala shape
     * @param x the x position
     * @param y the y position
     * @param width the width
     * @param c the color
     */
    public PitShape(int x, int y, int width, int height, Color c)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.c = c;
    }


    /**
     * draws the composite shape
     * @param g the graphics
     */
    public void draw(Graphics2D g)
    {
        g.draw(shape);
        fill(g);
    }

    /**
     * fills the composite shape
     * @param g the graphics
     */
    public void fill(Graphics2D g)
    {
        g.setColor(c);
        g.fill(shape);
        
        int counter = 1;
        double radius = Math.min(this.height, this.width) / 4.0;
        if (stones > 0)
        {
        	 g.setColor(Color.GREEN);
        	 
             Font font = new Font("Arial", Font.PLAIN, 18);
             FontMetrics fm = g.getFontMetrics();
             g.setFont(font);
             g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
             
             g.drawString("" + stones, this.x + width/2 - fm.stringWidth(""+stones) / 2, this.y + height/2 + fm.getDescent() / 2);
        }
        for(int i = 0; i < stones; i++)
        {
            //360 degrees => 2 * PI .divide by stones and times by counter to get the angle
        	
            double theta = (2*Math.PI) / (1.0 * stones) * (1.0 * counter);
            // center of pit is (this.x + width/2, this.y + height/2)
            double x = this.x + width / 2 + Math.cos(theta) * radius - radius / 2.0;
            double y = this.y + height / 2 + Math.sin(theta) * radius - radius / 2.0;    
            
            Ellipse2D.Double stone = new Ellipse2D.Double(x, y, STONE_SIZE, STONE_SIZE);
           
            //g.setPaint(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
            g.setPaint(Color.GREEN);
            g.fill(stone);
            g.setColor(Color.BLACK);
            g.draw(stone);
            counter++;
        }
    }

    /**
     * checks if the point is contained in the pit
     * @param aPoint the point x, y
     * @return true if it contains the point
     */
    public boolean contains(Point2D aPoint)
    {
        if(shape.contains(aPoint))
            return true;
        else
            return false;
    }

    /**
     * gets the number of stones in the pit
     * @return the stones
     */
    public int getStones()
    {
        return stones;
    }

    /**
     * sets the number of stones in the pit
     * @param num the number of stones
     */
    public void setStones(int num)
    {
        stones = num;
    }

    /**
     * sets the shape of the pit
     * @param s the shape
     */
    public void setShape(Shape s)
    {
        shape = s;
    }

    /**
     * gets the shape of the pit
     * @return the shape
     */
    public Shape getShape()
    {
        return shape;
    }
    
    /**
     * gets the x coordinate
     * @return the x coordinate
     */
    public int getX()
    {
        return x;
    }

    /**
     * gets the y coordinate
     * @return the y coordinate
     */
    public int getY()
    {
        return y;
    }

    /**
     * gets the width
     * @return the width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * gets the height
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }

    private int x;
    private int y;
    private int width;
    private int height;
    private Shape shape;
    private int stones;
    private Color c;
    final int STONE_SIZE = 20;

}
