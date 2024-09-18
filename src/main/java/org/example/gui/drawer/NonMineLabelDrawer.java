package org.example.gui.drawer;

import org.example.entity.Constants;
import org.example.gui.Field;

import java.awt.Color;
import java.awt.Graphics;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/** Egy tévesen megjelölt, aknát rejtő címkét megrajzoló oszály */
public class NonMineLabelDrawer extends MineLabelDrawer implements Constants {

    /** Konstruktor */
    public NonMineLabelDrawer(Field field, Graphics g) {
        super(field, g);
        // áthúzás (egy 2D-s vonal rajozlása nem lenne szimmetrikus)
        g.setColor(Color.red);
        g.drawLine(3, 3, 4, 3);
        g.drawLine(15, 3, 16, 3);
        g.drawLine(3, 4, 5, 4);
        g.drawLine(14, 4, 16, 4);
        g.drawLine(4, 5, 6, 5);
        g.drawLine(13, 5, 15, 5);
        g.drawLine(5, 6, 7, 6);
        g.drawLine(12, 6, 14, 6);
        g.drawLine(6, 7, 8, 7);
        g.drawLine(11, 7, 13, 7);
        g.drawLine(7, 8, 12, 8);
        g.drawLine(8, 9, 11, 9);
        g.drawLine(8, 10, 11, 10);
        g.drawLine(7, 11, 12, 11);
        g.drawLine(6, 12, 8, 12);
        g.drawLine(11, 12, 13, 12);
        g.drawLine(5, 13, 7, 13);
        g.drawLine(12, 13, 14, 13);
        g.drawLine(4, 14, 6, 14);
        g.drawLine(13, 14, 15, 14);
        g.drawLine(3, 15, 5, 15);
        g.drawLine(14, 15, 16, 15);
        g.drawLine(3, 16, 4, 16);
        g.drawLine(15, 16, 16, 16);
    }
}