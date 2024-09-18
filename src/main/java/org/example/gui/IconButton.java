package org.example.gui;

import org.example.entity.Constants;
import org.example.entity.DataModule;

import javax.swing.JButton;
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

/** Egy önmagára ikont rajzoló gomb osztálya. */
public class IconButton extends JButton implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** Az aktuális ikon */
    int icon = SMILING_ICON;

    /** A g.translete függvény nem működik helyesen a JButton-nál, így az ikon-
     * rajzolásnál a kinézettől függő eltolás lesz hozzáadva az x-, és y
     * koordinátákhoz */
    int pos;

    /** A kapott ikonnal rajzolja újra a gombot */
    public void drawIcon(int icon) {
        this.icon = icon;
        repaint();
    }

    /** Újrarajzolja a gombot */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // a kinézettől függő origó meghatározása
        pos = dataModule.getLookAndFeel() == MOTIF_LOOK_AND_FEEL ? 10 : 4;

        drawHead(g);
        if (icon == SAD_ICON)
            drawSadIcon(g);
        else if (icon == SMILING_ICON)
            drawSmilingIcon(g);
        else if (icon == SUCCESS_ICON)
            drawSunglassesIcon(g);
    }

    /** Megrajzolja a szomorú ikont */
    private void drawSadIcon(Graphics g) {
        drawSadEyes(g);
        drawSadMouth(g);
    }

    /** Megrajzolja a mosolygós ikont */
    private void drawSmilingIcon(Graphics g) {
        drawSmilingEyes(g);
        drawBigSmilingMouth(g);
    }

    /** Megrajzolja a napszemüveges ikont */
    private void drawSunglassesIcon(Graphics g) {
        drawSunglasses(g);
        drawLittleSmilingMouth(g);
    }

    /** Megrajzolja a fejet */
    private void drawHead(Graphics g) {
        // körvonal
        g.setColor(Color.black);
        g.drawOval(0 + pos, 0 + pos, 16, 16);
        // sárga kitöltés (a drawRect és a fillRect nem ugyanazt a területet
        // határolja körbe, ezért négyzetekkel lesz kitöltve).
        g.setColor(Color.yellow);
        g.fillRect(1 + pos, 6 + pos, 15, 5);
        g.fillRect(2 + pos, 4 + pos, 13, 9);
        g.fillRect(3 + pos, 3 + pos, 11, 11);
        g.fillRect(4 + pos, 2 + pos, 9, 13);
        g.fillRect(6 + pos, 1 + pos, 5, 15);
    }

    /** Egy kicsit mosolygós szájat rajzol */
    private void drawLittleSmilingMouth(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(5 + pos, 11 + pos, 1, 1);
        g.fillRect(6 + pos, 12 + pos, 5, 1);
        g.fillRect(11 + pos, 11 + pos, 1, 1);
    }

    /** Egy nagyon mosolygós szájat rajzol */
    private void drawBigSmilingMouth(Graphics g) {
        g.setColor(Color.black);
        drawLittleSmilingMouth(g);
        g.fillRect(4 + pos, 10 + pos, 1, 1);
        g.fillRect(12 + pos, 10 + pos, 1, 1);
    }

    /** Egy szomorú szájat rajzol */
    private void drawSadMouth(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(4 + pos, 12 + pos, 1, 1);
        g.fillRect(5 + pos, 11 + pos, 1, 1);
        g.fillRect(6 + pos, 10 + pos, 5, 1);
        g.fillRect(11 + pos, 11 + pos, 1, 1);
        g.fillRect(12 + pos, 12 + pos, 1, 1);
    }

    /** Egy mosolygós szemet rajzol */
    private void drawSmilingEyes(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(5 + pos, 5 + pos, 2, 2);
        g.fillRect(10 + pos, 5 + pos, 2, 2);
    }

    /** Egy szomorú szemet rajzol */
    private void drawSadEyes(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(4 + pos, 4 + pos, 1, 1);
        g.fillRect(6 + pos, 4 + pos, 1, 1);
        g.fillRect(5 + pos, 5 + pos, 1, 1);
        g.fillRect(4 + pos, 6 + pos, 1, 1);
        g.fillRect(6 + pos, 6 + pos, 1, 1);

        g.fillRect(10 + pos, 4 + pos, 1, 1);
        g.fillRect(12 + pos, 4 + pos, 1, 1);
        g.fillRect(11 + pos, 5 + pos, 1, 1);
        g.fillRect(10 + pos, 6 + pos, 1, 1);
        g.fillRect(12 + pos, 6 + pos, 1, 1);
    }

    /** Egy napszemüveget rajzol */
    private void drawSunglasses(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(1 + pos, 8 + pos, 1, 1);
        g.fillRect(2 + pos, 7 + pos, 1, 1);
        g.fillRect(3 + pos, 6 + pos, 1, 1);

        g.fillRect(4 + pos, 5 + pos, 4, 3);
        g.fillRect(5 + pos, 8 + pos, 2, 1);

        g.fillRect(8 + pos, 6 + pos, 1, 1);

        g.fillRect(9 + pos, 5 + pos, 4, 3);
        g.fillRect(10 + pos, 8 + pos, 2, 1);

        g.fillRect(13 + pos, 6 + pos, 1, 1);
        g.fillRect(14 + pos, 7 + pos, 1, 1);
        g.fillRect(15 + pos, 8 + pos, 1, 1);
    }
}