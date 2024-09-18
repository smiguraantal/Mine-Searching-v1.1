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

/** Egy aknát tartalmazó címkét megrajzoló oszály */
public class MineLabelDrawer extends LabelDrawer implements Constants {

    /** Konstruktor */
    public MineLabelDrawer(Field field, Graphics g) {
        super(field, g);
        drawMine(g);
    }

    /** Megrajzolja a aknát */
    protected void drawMine(Graphics g) {
        g.setColor(Color.black);
        // akna
        g.drawLine(9, 3, 10, 3);
        g.drawLine(9, 4, 10, 4);
        g.drawLine(5, 5, 5, 5);
        g.drawLine(7, 5, 12, 5);
        g.drawLine(14, 5, 14, 5);
        g.drawLine(6, 6, 13, 6);
        g.drawLine(5, 7, 14, 7);
        g.drawLine(5, 8, 14, 8);
        g.drawLine(3, 9, 16, 9);
        g.drawLine(3, 10, 16, 10);
        g.drawLine(5, 11, 14, 11);
        g.drawLine(5, 12, 14, 12);
        g.drawLine(6, 13, 13, 13);
        g.drawLine(5, 14, 5, 14);
        g.drawLine(7, 14, 12, 14);
        g.drawLine(14, 14, 14, 14);
        g.drawLine(9, 15, 10, 15);
        g.drawLine(9, 16, 10, 16);
        // fény az aknán
        g.setColor(Color.white);
        g.drawLine(7, 7, 8, 7);
        g.drawLine(7, 8, 8, 8);
    }
}