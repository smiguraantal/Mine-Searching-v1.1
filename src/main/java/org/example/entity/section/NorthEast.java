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

/** Egy digitális szám jobb-felső szegmensének pontjait deklaráló osztály */
public class NorthEast extends Section {

    protected void createDarkPoints() {
        darkPoints.add(new Point(11, 2));

        darkPoints.add(new Point(10, 3));

        darkPoints.add(new Point(9, 4));
        darkPoints.add(new Point(11, 4));

        darkPoints.add(new Point(10, 5));

        darkPoints.add(new Point(9, 6));
        darkPoints.add(new Point(11, 6));

        darkPoints.add(new Point(10, 7));

        darkPoints.add(new Point(9, 8));
        darkPoints.add(new Point(11, 8));

        darkPoints.add(new Point(10, 9));

        darkPoints.add(new Point(11, 10));
    }

    protected void createLightPoints() {
        lightPoints = new Vector(darkPoints);

        lightPoints.add(new Point(11, 3));

        lightPoints.add(new Point(10, 4));

        lightPoints.add(new Point(9, 5));
        lightPoints.add(new Point(11, 5));

        lightPoints.add(new Point(10, 6));

        lightPoints.add(new Point(9, 7));
        lightPoints.add(new Point(11, 7));

        lightPoints.add(new Point(10, 8));

        lightPoints.add(new Point(11, 9));
    }

}