package org.example.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/** Egy mező egérkattintását figyelő osztály */
public class LabelListener extends MouseAdapter {

    /** Ez a mező lesz figyelve */
    Field field;

    /** Konstruktor */
    public LabelListener(Field field) {
        this.field = field;
    }

    /** A jobb-, illetve a bal egérkattintás függvényében intézkedik */
    public void mousePressed(MouseEvent e) {
        if (e.getModifiers() == e.BUTTON1_MASK)
            field.leftClick();
        if (e.getModifiers() == e.BUTTON3_MASK) {
            field.rightClick();
        }
    }
}
