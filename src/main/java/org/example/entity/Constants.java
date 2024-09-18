package org.example.entity;

import java.util.GregorianCalendar;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/** Konstansadatokat definiáló interfész. */
public interface Constants {

    // A mezők mérete
    public static final int UNIT = 20;

    // A játék lehetséges állapotai
    public static final int STOP = 0;
    public static final int PLAY = 1;
    public static final int PAUSE = 2; // még nincs szerepe!

    // A mezők gombkénti állapota
    public static final int EMPTY_BUTTON = 3;
    public static final int FLAG_BUTTON = 4;
    public static final int QUESTION_MARK_BUTTON = 5;

    // A mezők címkekénti állapota
    public static final int EMPTY_LABEL = 6;
    public static final int MINE_LABEL = 7;
    public static final int COUNTER_LABEL = 8;
    public static final int BLOWN_UP_MINE_LABEL = 9;
    public static final int NON_MINE_LABEL = 10;

    /** A kinézet lehetséges értékei */
    public static final int WINDOWS_LOOK_AND_FEEL = 11;
    public static final int METAL_LOOK_AND_FEEL = 12;
    public static final int MOTIF_LOOK_AND_FEEL = 13;

    /** Az "Új" gomb ikonjai */
    public static final int SMILING_ICON = 14;
    public static final int SAD_ICON = 15;
    public static final int SUCCESS_ICON = 16;

    /** Az egyéni aknamező beállításának szélsőértékei */
    public static final int MIN_ROWS = 9;
    public static final int MAX_ROWS = 16;
    public static final int MIN_COLUMNS = 9;
    public static final int MAX_COLUMNS = 30;
    public static final int MIN_MINES = 1;
    public static final int MAX_RATE = 30; // a mezők max ennyi százaléka lehet akna

    // Maximális játékidő
    public static final int MAX_TIME = 999;

    // Kitöltetlen név helyett...
    public static final String ANONYM = "Névtelen";

    // Alapértelmezett dátum
    public static final GregorianCalendar DEFAULT_DATE =
            new GregorianCalendar(2004, 0, 1);

    // Nehézségi szintek
    public static final Level BEGINNER = new Level(9, 9, 10);
    public static final Level ADVANCED = new Level(16, 16, 40);
    ;
    public static final Level MASTER = new Level(16, 30, 70);
    ;

    // A kijelző méretei
    public static final int DISPLAY_UNIT = 1;
    public static final int DISPLAY_WIDTH = 13;
    public static final int DISPLAY_HEIGHT = 23;

    // A kijelzőn megjelenő számok
    public static final Number ZERO = new Number(true, true, true, false, true, true, true);
    public static final Number ONE = new Number(false, false, true, false, false, true, false);
    public static final Number TWO = new Number(true, false, true, true, true, false, true);
    public static final Number THREE = new Number(true, false, true, true, false, true, true);
    public static final Number FOUR = new Number(false, true, true, true, false, true, false);
    public static final Number FIVE = new Number(true, true, false, true, false, true, true);
    public static final Number SIX = new Number(true, true, false, true, true, true, true);
    public static final Number SEVEN = new Number(true, false, true, false, false, true, false);
    public static final Number EIGHT = new Number(true, true, true, true, true, true, true);
    public static final Number NINE = new Number(true, true, true, true, false, true, true);
}







