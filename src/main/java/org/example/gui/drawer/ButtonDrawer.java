package org.example.gui.drawer;

import javax.swing.BorderFactory;
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

/** Egy gombot rajzoló osztály */
public class ButtonDrawer {

    /** Konstruktor */
    public ButtonDrawer(JComponent component, Graphics g) {
        component.setBorder(BorderFactory.createBevelBorder(0));
        drawPicture(g);
    }

    /** A gombra az utód oszályok fognak rajzolni */
    protected void drawPicture(Graphics g) {
        //
    }
}