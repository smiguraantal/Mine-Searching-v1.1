package org.example.entity;

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
 * Egy digitális szám szegmenseit tartalmazó osztály
 */
public class Number {

    // a számot alkotó szegmensek
    private boolean north;
    private boolean northWest;
    private boolean northEast;
    private boolean center;
    private boolean southWest;
    private boolean southEast;
    private boolean south;

    /**
     * konstruktor
     */
    public Number(boolean north,
                  boolean norhtWest,
                  boolean northEast,
                  boolean center,
                  boolean southWest,
                  boolean southEast,
                  boolean south) {
        this.north = north;
        this.northWest = norhtWest;
        this.northEast = northEast;
        this.center = center;
        this.southWest = southWest;
        this.southEast = southEast;
        this.south = south;
    }

    /**
     * konstruktor
     */
    public Number() {
        this(false, false, false, false, false, false, false);
    }

    public boolean isCenter() {
        return center;
    }

    public boolean isNorth() {
        return north;
    }

    public boolean isNorthEast() {
        return northEast;
    }

    public boolean isNorthWest() {
        return northWest;
    }

    public boolean isSouth() {
        return south;
    }

    public boolean isSouthEast() {
        return southEast;
    }

    public boolean isSouthWest() {
        return southWest;
    }
}