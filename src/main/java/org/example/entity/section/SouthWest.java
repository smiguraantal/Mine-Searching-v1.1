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

/** Egy digitális szám bal-alsó szegmensének pontjait deklaráló osztály */
public class SouthWest extends Section {

    protected void createDarkPoints() {
        darkPoints.add(new Point(1, 12));

        darkPoints.add(new Point(2, 13));

        darkPoints.add(new Point(1, 14));
        darkPoints.add(new Point(3, 14));

        darkPoints.add(new Point(2, 15));

        darkPoints.add(new Point(1, 16));
        darkPoints.add(new Point(3, 16));

        darkPoints.add(new Point(2, 17));

        darkPoints.add(new Point(1, 18));
        darkPoints.add(new Point(3, 18));

        darkPoints.add(new Point(2, 19));

        darkPoints.add(new Point(1, 20));
    }

    protected void createLightPoints() {
        lightPoints = new Vector(darkPoints);

        lightPoints.add(new Point(1, 13));

        lightPoints.add(new Point(2, 14));

        lightPoints.add(new Point(1, 15));
        lightPoints.add(new Point(3, 15));

        lightPoints.add(new Point(2, 16));

        lightPoints.add(new Point(1, 17));
        lightPoints.add(new Point(3, 17));

        lightPoints.add(new Point(2, 18));

        lightPoints.add(new Point(1, 19));
    }

}