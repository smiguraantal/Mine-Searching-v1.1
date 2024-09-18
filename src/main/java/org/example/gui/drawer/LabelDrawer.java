package org.example.gui.drawer;

import org.example.entity.Colors;
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

/** Egy címkét megrajzoló oszály */
public class LabelDrawer implements Constants, Colors {

    /** Konstruktor */
    public LabelDrawer(Field field, Graphics g) {
        drawDefaultLabel(field, g);
    }

    /** Megrajzolja az alapértelmezett címkét */
    private void drawDefaultLabel(Field field, Graphics g) {
        field.setBorder(null);
        g.setColor(Color.lightGray);
        g.drawRect(0, 0, UNIT - 1, UNIT - 1);
    }
}

