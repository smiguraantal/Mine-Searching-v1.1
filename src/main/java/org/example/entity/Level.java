package org.example.entity;

import java.io.Serializable;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/**
 * Egy nehézségi fokhoz tartozó adatokat tároló osztály.
 */
public class Level implements Serializable {

    /**
     * sorok száma
     */
    private int rows;

    /**
     * oszlopok száma
     */
    private int columns;

    /**
     * aknák száma
     */
    private int mines;

    /**
     * konstuktor
     */
    public Level(int rows,
                 int column,
                 int mines) {
        this.rows = rows;
        this.columns = column;
        this.mines = mines;
    }

    /**
     * Két szint már akkor is megegyezik, ha az aknák száma ugyanannyi
     */
    public boolean equals(Object object) {
        return mines == ((Level) object).getMines();
    }

    public int getColumns() {
        return columns;
    }

    public int getMines() {
        return mines;
    }

    public int getRows() {
        return rows;
    }
}