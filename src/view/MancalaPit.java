package view;

import java.awt.geom.Ellipse2D;

public class MancalaPit extends MancalaShape
{
    public MancalaPit(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        Ellipse2D.Double mancala = new Ellipse2D.Double(x, y, width, height);
        super.add(mancala);
    }
}
