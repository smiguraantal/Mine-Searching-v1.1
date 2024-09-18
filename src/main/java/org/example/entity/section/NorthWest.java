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

/** Egy digitális szám bal-felső szegmensének pontjait deklaráló osztály */
public class NorthWest extends Section {

    protected void createDarkPoints() {
        darkPoints.add(new Point(1, 2));

        darkPoints.add(new Point(2, 3));

        darkPoints.add(new Point(1, 4));
        darkPoints.add(new Point(3, 4));

        darkPoints.add(new Point(2, 5));

        darkPoints.add(new Point(1, 6));
        darkPoints.add(new Point(3, 6));

        darkPoints.add(new Point(2, 7));

        darkPoints.add(new Point(1, 8));
        darkPoints.add(new Point(3, 8));

        darkPoints.add(new Point(2, 9));

        darkPoints.add(new Point(1, 10));
    }

    protected void createLightPoints() {
        lightPoints = new Vector(darkPoints);

        lightPoints.add(new Point(1, 3));

        lightPoints.add(new Point(2, 4));

        lightPoints.add(new Point(1, 5));
        lightPoints.add(new Point(3, 5));

        lightPoints.add(new Point(2, 6));

        lightPoints.add(new Point(1, 7));
        lightPoints.add(new Point(3, 7));

        lightPoints.add(new Point(2, 8));

        lightPoints.add(new Point(1, 9));
    }

}