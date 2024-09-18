package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.Number;

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/** Egy maximum három jegyű digitális számot megjelenítő panel */
public class DisplayPanel extends JPanel implements Constants {

    /** Százas helyiérték */
    NumberPanel pnHundred;

    /** Tizes helyiérték */
    NumberPanel pnTen;

    /** Egyes helyiérték */
    NumberPanel pnOne;

    GridLayout gridLayout1 = new GridLayout();

    /** Konstruktor */
    public DisplayPanel(int value) {
        try {
            jbInit(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /** Felépíti a panelt */
    void jbInit(int value) throws Exception {
        this.setLayout(gridLayout1);
        add(pnHundred = new NumberPanel());
        add(pnTen = new NumberPanel());
        add(pnOne = new NumberPanel());
        setValue(value);
    }

    /** Meghatározza az egyes helyiértékeken megjelenő számok értékét */
    public void setValue(int value) {
        if (value < 10) {
            pnHundred.setNumber(ZERO);
            pnTen.setNumber(ZERO);
            pnOne.setNumber(number(value));
        } else if (value < 100) {
            pnHundred.setNumber(ZERO);
            pnTen.setNumber(number((value / 10)));
            pnOne.setNumber(number(value % 10));
        } else if (value < 1000) {
            pnHundred.setNumber(number(value / 100));
            pnTen.setNumber(number((value / 10) % 10));
            pnOne.setNumber(number((value % 100) % 10));
        }
    }

    /** Az érték alapján visszaad egy szám objektumot */
    private Number number(int value) {
        Number number = null;
        switch (value) {
            case 0:
                number = ZERO;
                break;
            case 1:
                number = ONE;
                break;
            case 2:
                number = TWO;
                break;
            case 3:
                number = THREE;
                break;
            case 4:
                number = FOUR;
                break;
            case 5:
                number = FIVE;
                break;
            case 6:
                number = SIX;
                break;
            case 7:
                number = SEVEN;
                break;
            case 8:
                number = EIGHT;
                break;
            case 9:
                number = NINE;
                break;
        }
        return number;
    }
}