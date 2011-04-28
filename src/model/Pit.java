package model;

import java.awt.geom.Ellipse2D;


public class Pit extends MancalaShape
{
    public Pit(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        Ellipse2D.Double pit = new Ellipse2D.Double(x, y, width, height);
        super.add(pit);
    }
}
