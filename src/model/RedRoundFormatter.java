package model;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public class RedRoundFormatter implements ShapeFormatter
{
    /**
     * changes the color
     */
    @Override
    public Color formatPitColor()
    {
        return Color.RED;
    }

    /**
     * changes the shape
     */
    @Override
    public Shape formatPitShape(PitShape p)
    {
        return new Ellipse2D.Double(p.getX(), p.getY(), p.getWidth(), p.getHeight());
    }
    
}
