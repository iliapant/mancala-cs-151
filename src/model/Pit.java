package model;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;


public class Pit extends MancalaShape
{
    /**
     * creates a new pit
     * @param x the x position
     * @param y the y position
     * @param width the width
     * @param height the height
     * @param shape the shape of the pits/mancala
     * @param c the color of the pits/mancala
     */
    public Pit(int x, int y, int width, int height, Shape shape, Color c)
    {
        super(x, y, width, height, c);
        //Ellipse2D.Double pit = new Ellipse2D.Double(x, y, width, height);
        super.add(shape);
    }
    /*
    public void setStones(int num)
    {
        super.setStones(num);
    }
    
    public int getStones()
    {
        return super.getStones();
    }
    */
}
