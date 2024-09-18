package org.example.gui;

import org.example.entity.Constants;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/** Sikeres felderítés után a zászlóval jelölt mezőket villogtató osztály */
public class Flash implements Constants {

    /** A villogtatni kívánt mezők */
    Vector fields;

    /** A villogás időzítője */
    Timer timer;

    /** konstruktor */
    public Flash(Vector fields) {
        this.fields = fields;
        initTimer();
    }

    /** beállítja az időzítőt */
    private void initTimer() {
        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < fields.size(); i++) {
                    Field field = (Field) fields.get(i);
                    if (field.getButtonState() == FLAG_BUTTON) // ha zászlós
                        field.setButtonState(EMPTY_BUTTON);
                    else // ha üres
                        field.setButtonState(FLAG_BUTTON);
                    field.repaint();
                }
            }
        });
    }

    /** elindítja az időzítőt */
    public void start() {
        timer.setInitialDelay(1000);
        timer.start();
    }

    /** megállítja az időzítőt */
    public void stop() {
        timer.stop();
        timer = null;
    }
}