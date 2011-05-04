package model;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Strategy pattern that creates blue squares
 *
 */
public class BlueSquareFormatter implements ShapeFormatter
{
    /**
     * changes the color
     */
    @Override
    public Color formatPitColor()
    {
        return Color.BLUE;
    }

    /**
     * changes the shape
     */
    @Override
    public Shape formatPitShape(PitShape p)
    {
        return new Rectangle2D.Double(p.getX(), p.getY(), p.getWidth(), p.getHeight());
    }
    
}
