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

/** Egy digitális szám alsó szegmensének pontjait deklaráló osztály */
public class South extends Section {

    protected void createDarkPoints() {
        darkPoints.add(new Point(5, 19));
        darkPoints.add(new Point(7, 19));

        darkPoints.add(new Point(4, 20));
        darkPoints.add(new Point(6, 20));
        darkPoints.add(new Point(8, 20));

        darkPoints.add(new Point(3, 21));
        darkPoints.add(new Point(5, 21));
        darkPoints.add(new Point(7, 21));
        darkPoints.add(new Point(9, 21));
    }

    protected void createLightPoints() {
        lightPoints = new Vector(darkPoints);
        lightPoints.add(new Point(4, 19));
        lightPoints.add(new Point(6, 19));
        lightPoints.add(new Point(8, 19));

        lightPoints.add(new Point(3, 20));
        lightPoints.add(new Point(5, 20));
        lightPoints.add(new Point(7, 20));
        lightPoints.add(new Point(9, 20));

        lightPoints.add(new Point(2, 21));
        lightPoints.add(new Point(4, 21));
        lightPoints.add(new Point(6, 21));
        lightPoints.add(new Point(8, 21));
        lightPoints.add(new Point(10, 21));

    }
}