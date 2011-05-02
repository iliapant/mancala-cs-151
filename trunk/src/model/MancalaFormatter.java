package model;

import java.awt.Color;
import java.awt.Shape;


public class MancalaFormatter implements ShapeFormatter
{
    /**
     * changes the color
     */
    @Override
    public void formatColor(Color c)
    {
        color = c;
    }

    /**
     * changes the shape
     */
    @Override
    public void formatShape(Shape s)
    {
        shape = s;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public Shape getShape()
    {
        return shape;
    }
    private Color color;
    private Shape shape;
}
