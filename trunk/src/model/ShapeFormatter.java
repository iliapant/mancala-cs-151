package model;

import java.awt.Color;
import java.awt.Shape;


/**
 * simple interface outlining requirements for pits 
 *
 */
public interface ShapeFormatter
{
    Color formatPitColor();
    Shape formatPitShape(PitShape p);
}
