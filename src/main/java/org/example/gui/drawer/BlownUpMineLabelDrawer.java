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

/** Egy felrobban aknát megrajzoló oszály */
public class BlownUpMineLabelDrawer extends MineLabelDrawer implements Constants {

    /** Konstruktor */
    public BlownUpMineLabelDrawer(Field field, Graphics g) {
        super(field, g);
        field.setBackground(Color.red);
        drawMine(g);
    }
}