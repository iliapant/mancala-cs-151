package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;


public class MancalaShape
{
    /**
     * Creates a new Mancala shape
     * @param x the x position
     * @param y the y position
     * @param width the width
     */
    public MancalaShape(int x, int y, int height, int width)
    {
        shape = null;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        path = new GeneralPath();
    }
    
    /**
     * adds to the general path
     * @param aShape the Shape reference
     */
    public void add(Shape aShape)
    {
        shape = aShape;
    }
    
    /**
     * draws the composite shape
     * @param g the graphics
     */
    public void draw(Graphics2D g)
    {
        g.draw(shape);
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
    
    /*
    
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
    */
    private GeneralPath path;
    private int x;
    private int y;
    private int width;
    private int height;
    private Shape shape;
    private int stones;
    
}
