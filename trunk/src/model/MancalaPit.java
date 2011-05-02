package model;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;


public class MancalaPit extends MancalaShape
{
    /**
     * creates a new mancala pit
     * @param x the x pos
     * @param y the y pos
     * @param width the width
     * @param height the height
     * @param c the color
     * @param shape the shape
     */
    public MancalaPit(int x, int y, int width, int height, Color c, Shape shape)
    {
        super(x, y, width, height, c);
        //Ellipse2D.Double mancala = new Ellipse2D.Double(x, y, width, height);
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
