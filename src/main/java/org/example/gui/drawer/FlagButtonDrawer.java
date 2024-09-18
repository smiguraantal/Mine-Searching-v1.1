package org.example.gui.drawer;

import javax.swing.JComponent;
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

/** Egy olyan gombot rajzoló oszály, melyen egy zászló látható */
public class FlagButtonDrawer extends ButtonDrawer {

    /** Konstruktor */
    public FlagButtonDrawer(JComponent component, Graphics g) {
        super(component, g);
    }

    /** A zászló megrajzolása */
    protected void drawPicture(Graphics g) {
        g.drawLine(4, 15, 15, 15);
        g.drawLine(5, 14, 14, 14);
        g.drawLine(6, 13, 13, 13);
        g.fillRect(9, 10, 2, 3);

        g.setColor(Color.red);
        g.fillRect(9, 4, 2, 6);
        g.fillRect(8, 5, 1, 5);
        g.fillRect(7, 6, 1, 3);
        g.fillRect(6, 7, 1, 1);
    }
}