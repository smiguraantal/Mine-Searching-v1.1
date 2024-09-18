package org.example.entity;

import javax.swing.UIManager;
import java.awt.Color;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/** A kijelző színeit, valamint a mezőkön megjelenő számok színeit
 * definiáló interfész. */
public interface Colors {

    // számok színei
    public static final Color COLOR_ONE = Color.blue;
    public static final Color COLOR_TWO = new Color(0, 128, 0);
    public static final Color COLOR_THREE = Color.red;
    public static final Color COLOR_FOUR = new Color(0, 0, 128);
    public static final Color COLOR_FIVE = new Color(128, 0, 0);
    public static final Color COLOR_SIX = new Color(0, 128, 128);
    public static final Color COLOR_SEVEN = Color.black;
    public static final Color COLOR_EIGHT = new Color(128, 128, 128);
    public static final Color PANEL_BACKGROUND =
            (Color) UIManager.get("Panel.background");

    // kijelző színei
    public static final Color BACKGROUND_COLOR = Color.black;
    public static final Color DARK_COLOR = new Color(128, 0, 0);
    public static final Color LIGHT_COLOR = Color.red;
}