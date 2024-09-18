package org.example.gui.drawer;

import javax.swing.JComponent;
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

/** Egy kérdőjelet tartalmazó gombot megrajzoló oszály */
public class QuestionMarkButtonDrawer extends ButtonDrawer {

    /** Konstruktor */
    public QuestionMarkButtonDrawer(JComponent component, Graphics g) {
        super(component, g);
    }

    /** Megrajzolja a kérdőjelet */
    protected void drawPicture(Graphics g) {
        g.fillRect(9, 14, 2, 2);
        g.fillRect(9, 10, 2, 3);
        g.drawLine(10, 9, 12, 9);
        g.fillRect(12, 6, 2, 3);
        g.drawLine(7, 5, 12, 5);
        g.fillRect(6, 6, 2, 2);
    }
}