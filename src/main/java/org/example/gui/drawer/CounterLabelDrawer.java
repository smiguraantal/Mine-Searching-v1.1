package org.example.gui.drawer;

import org.example.entity.DataModule;
import org.example.gui.Field;

import javax.swing.UIManager;
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

/** Egy számláló mezőt rajzoló osztály */
public class CounterLabelDrawer extends LabelDrawer {

    /** Konstruktor */
    public CounterLabelDrawer(Field field, Graphics g) {
        super(field, g);
        field.setForeground(field.isHidden() ?
                ((Color) UIManager.get("Panel.background")) :
                DataModule.getDataModule().createColor(field.getNeighbourMines())); // számláló színe
        field.setText("" + field.getNeighbourMines());
    }
}