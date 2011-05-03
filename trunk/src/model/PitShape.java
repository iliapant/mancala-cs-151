package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * super class MancalaShape. Creates a pit or mancala
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
        //TODO.: draw stones

    }

    /**
     * fills the composite shape
     * @param g the graphics
     */
    public void fill(Graphics2D g)
    {
        g.setColor(c);
        g.fill(shape);
        g.setColor(Color.BLACK);
        double x = 0;
        double y = 0;
        double theta = 0;
        int counter = 1;
        for(int i = 0; i < stones; i++)
        {
            //circumference of circle is 2*pi. divide by stones and times by counter to get the positions
            theta = 2*Math.PI/stones * counter; 
            x = Math.cos(theta);
            y = Math.sin(theta);
            Ellipse2D.Double stone = new Ellipse2D.Double(x, y, 10, 10);
            g.draw(stone);
            counter++;
        }
    }

    public boolean contains(Point2D aPoint)
    {
        if(shape.contains(aPoint))
            return true;
        else
            return false;
    }

    public int getStones()
    {
        return stones;
    }

    public void setStones(int num)
    {
        stones = num;
    }

    public void setShape(Shape s)
    {
        shape = s;
    }

    public Shape getShape()
    {
        return shape;
    }


    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

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

}
