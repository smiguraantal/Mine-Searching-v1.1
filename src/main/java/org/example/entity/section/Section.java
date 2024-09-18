package org.example.entity.section;

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

/** Absztrakt szegmens osztály */
public abstract class Section {

    /** Megvilágítatlan pontok */
    protected Vector darkPoints = new Vector();

    /** Kivilágított pontok */
    protected Vector lightPoints = new Vector();

    /** Konsturktor */
    protected Section() {
        createDarkPoints();
        createLightPoints();
    }

    /** A megvilágítatlan pontok meghatárohása */
    protected abstract void createDarkPoints();

    /** A kivilágított pontok meghatározása */
    protected abstract void createLightPoints();

    public Vector getDarkPoints() {
        return darkPoints;
    }

    public Vector getLightPoints() {
        return lightPoints;
    }
}