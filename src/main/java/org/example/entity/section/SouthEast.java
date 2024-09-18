package org.example.entity.section;

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

/** Egy digitális szám jobb-alsó szegmensének pontjait deklaráló osztály */
public class SouthEast extends Section {

    protected void createDarkPoints() {
        darkPoints.add(new Point(11, 12));

        darkPoints.add(new Point(10, 13));

        darkPoints.add(new Point(9, 14));
        darkPoints.add(new Point(11, 14));

        darkPoints.add(new Point(10, 15));

        darkPoints.add(new Point(9, 16));
        darkPoints.add(new Point(11, 16));

        darkPoints.add(new Point(10, 17));

        darkPoints.add(new Point(9, 18));
        darkPoints.add(new Point(11, 18));

        darkPoints.add(new Point(10, 19));

        darkPoints.add(new Point(11, 20));
    }

    protected void createLightPoints() {
        lightPoints = new Vector(darkPoints);

        lightPoints.add(new Point(11, 13));

        lightPoints.add(new Point(10, 14));

        lightPoints.add(new Point(9, 15));
        lightPoints.add(new Point(11, 15));

        lightPoints.add(new Point(10, 16));

        lightPoints.add(new Point(9, 17));
        lightPoints.add(new Point(11, 17));

        lightPoints.add(new Point(10, 18));

        lightPoints.add(new Point(11, 19));
    }

}