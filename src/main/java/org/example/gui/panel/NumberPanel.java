package org.example.gui.panel;

import org.example.entity.Colors;
import org.example.entity.Constants;
import org.example.entity.Number;
import org.example.entity.section.Center;
import org.example.entity.section.North;
import org.example.entity.section.NorthEast;
import org.example.entity.section.NorthWest;
import org.example.entity.section.South;
import org.example.entity.section.SouthEast;
import org.example.entity.section.SouthWest;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/** Egy digitális számot megjelenítő panel */
public class NumberPanel extends JPanel implements Constants, Colors {

    /** A megjeleníteni kívánt szám */
    Number number = new Number();

    BorderLayout borderLayout1 = new BorderLayout();

    /** Konstruktor */
    public NumberPanel() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /** A méret és a háttérszín meghatározása */
    void jbInit() throws Exception {
        this.setLayout(borderLayout1);
        setBackground(BACKGROUND_COLOR);
        setPreferredSize(new Dimension(DISPLAY_WIDTH * DISPLAY_UNIT, DISPLAY_HEIGHT * DISPLAY_UNIT));
    }

    /** A szám szegmensei alapján megrajzolja a digitális számot */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, DISPLAY_WIDTH * DISPLAY_UNIT, DISPLAY_HEIGHT * DISPLAY_UNIT);

        // felső szegmens
        if (number.isNorth())
            drawPoints(g, new North().getLightPoints(), LIGHT_COLOR);
        else
            drawPoints(g, new North().getDarkPoints(), DARK_COLOR);

        // középső szegmens
        if (number.isCenter())
            drawPoints(g, new Center().getLightPoints(), LIGHT_COLOR);
        else
            drawPoints(g, new Center().getDarkPoints(), DARK_COLOR);

        // alsó szegmens
        if (number.isSouth())
            drawPoints(g, new South().getLightPoints(), LIGHT_COLOR);
        else
            drawPoints(g, new South().getDarkPoints(), DARK_COLOR);

        // bal felső szegmens
        if (number.isNorthWest())
            drawPoints(g, new NorthWest().getLightPoints(), LIGHT_COLOR);
        else
            drawPoints(g, new NorthWest().getDarkPoints(), DARK_COLOR);

        // jobb felső szegmens
        if (number.isNorthEast())
            drawPoints(g, new NorthEast().getLightPoints(), LIGHT_COLOR);
        else
            drawPoints(g, new NorthEast().getDarkPoints(), DARK_COLOR);

        // bal alsó szegmens
        if (number.isSouthWest())
            drawPoints(g, new SouthWest().getLightPoints(), LIGHT_COLOR);
        else
            drawPoints(g, new SouthWest().getDarkPoints(), DARK_COLOR);

        // jobb alsó szegmens
        if (number.isSouthEast())
            drawPoints(g, new SouthEast().getLightPoints(), LIGHT_COLOR);
        else
            drawPoints(g, new SouthEast().getDarkPoints(), DARK_COLOR);
    }

    /** Kirajzolja a szemens ponjait */
    private void drawPoints(Graphics g, Vector points, Color color) {
        g.setColor(color);
        for (int i = 0; i < points.size(); i++) {
            Point point = (Point) points.get(i);
            g.fillRect(point.x * DISPLAY_UNIT,
                    point.y * DISPLAY_UNIT,
                    DISPLAY_UNIT,
                    DISPLAY_UNIT);
        }
    }

    public void setNumber(Number number) {
        this.number = number;
        repaint();
    }
}
