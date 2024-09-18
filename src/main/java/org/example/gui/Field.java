package org.example.gui;

import org.example.entity.Colors;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.drawer.BlownUpMineLabelDrawer;
import org.example.gui.drawer.ButtonDrawer;
import org.example.gui.drawer.CounterLabelDrawer;
import org.example.gui.drawer.FlagButtonDrawer;
import org.example.gui.drawer.LabelDrawer;
import org.example.gui.drawer.MineLabelDrawer;
import org.example.gui.drawer.NonMineLabelDrawer;
import org.example.gui.drawer.QuestionMarkButtonDrawer;
import org.example.gui.panel.GamePanel;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/** A játékterületen egy mezőt reprezentáló osztály, melynek a kinézete lehet
 * gomb vagy címke */
public class Field extends JLabel implements Constants, Colors {

    /** sorindex */
    private int row;

    /** oszlopindex */
    private int column;

    /** egérkattintás-figyelő */
    private LabelListener listener;

    /** gomb-e */
    private boolean button = true;

    /** gombkénti állapot */
    private int buttonState = EMPTY_BUTTON;

    /** cimkekénti állapot */
    private int labelState;

    /** akna-e */
    private boolean mine;

    /** a szomszéd aknák száma */
    private int neighbourMines;

    /** rejtett-e a számláló */
    private boolean hidden;

    /** adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** játékterület */
    GamePanel gamePanel;

    BorderLayout borderLayout1 = new BorderLayout();

    /** Konstruktor */
    public Field(GamePanel gamePanel, int row, int column) {
        this.gamePanel = gamePanel;
        this.row = row;
        this.column = column;
        this.addMouseListener(listener = new LabelListener(this));
        this.setPreferredSize(new Dimension(UNIT, UNIT));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setOpaque(true);
        this.setFont(new Font("Monospaced", Font.BOLD, 17));
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void jbInit() throws Exception {
        this.setLayout(borderLayout1);
    }

    /** Eltávolítja a kattintásfigyelést */
    public void removeLabelListener() {
        this.removeMouseListener(listener);
    }

    /** Egy gombra (nem zászlóval jelölt) való kattintás */
    public void push() {
        if (mine) { // ha bombára kattintottam
            button = false;
            labelState = BLOWN_UP_MINE_LABEL;
            gamePanel.showMines();
        } else { // ha nem bombára kattintottam
            gamePanel.clear(row, column);
        }
        repaint();
    }

    /** bal klikkelés */
    public void leftClick() {
        gamePanel.initFields(row, column);
        gamePanel.startTime();
        if (button) { // ha még gomb
            if (buttonState != FLAG_BUTTON) { // ha nem zászló
                if (mine) { // ha bombára kattintottam
                    button = false;
                    labelState = BLOWN_UP_MINE_LABEL;
                    gamePanel.showMines();
                } else { // ha nem bombára kattintottam
                    gamePanel.clear(row, column);
                }
            }
        } else { // ha már nem gomb
            gamePanel.showNeighbours(row, column);
        }
        repaint();
        if (dataModule.getPlayState() == PLAY) // ha még megy a játék
            gamePanel.click();
    }

    /** jobb klikkelés */
    public void rightClick() {
        //gamePanel.startTime();
        if (button) { // ha még gomb
            changeState();
            repaint();
        }
        gamePanel.click();
    }

    /** Megváltoztatja a gombállapotot */
    private void changeState() {
        if (!button) // ha már nem gomb
            return;
        if (buttonState == EMPTY_BUTTON) { // ha üres gomb
            if (dataModule.getUnmarkedMines() == 0) // ha több zászlót már nem lehet elhelyezni, mint amennyi az aknák száma
                gamePanel.showMessage("Több zászló nem helyezhető el, mint amennyi akna valójában van!");
            else { // elhelyezhetők a zászlók
                buttonState = FLAG_BUTTON;
                dataModule.decreaseUnmarkedMines();
            }
        } else if (buttonState == FLAG_BUTTON) { // ha zászlós
            if (dataModule.isSigns()) { // ha elhelyezhetőek kérdőjelek
                buttonState = QUESTION_MARK_BUTTON;
            } else { // ha nem helyezhető el kérdőjel
                buttonState = EMPTY_BUTTON;
            }
            dataModule.increaseUnmarkedMines();
            gamePanel.putCounters(row, column);
        } else // ha kérdőjeles
            buttonState = EMPTY_BUTTON;
    }

    /** Megrajzolja a mezőt */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (button) { // ha még gomb
            if (buttonState == EMPTY_BUTTON) // üres gomb
                new ButtonDrawer(this, g);
            if (buttonState == FLAG_BUTTON) // zászlós gomb
                new FlagButtonDrawer(this, g);
            if (buttonState == QUESTION_MARK_BUTTON) // kérdőjeles gomb
                new QuestionMarkButtonDrawer(this, g);
        } else { // ha már nem gomb
            if (labelState == BLOWN_UP_MINE_LABEL)  // felrobbant aknás cimke
                new BlownUpMineLabelDrawer(this, g);
            if (labelState == NON_MINE_LABEL) // rosszul megjelölt aknás cimke
                new NonMineLabelDrawer(this, g);
            if (labelState == MINE_LABEL) // aknás cimke
                new MineLabelDrawer(this, g);
            if (labelState == COUNTER_LABEL) // számlálós cimke
                new CounterLabelDrawer(this, g);
            if (labelState == EMPTY_LABEL) // üres cimke
                new LabelDrawer(this, g);
        }
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public int getNeighbourMines() {
        return neighbourMines;
    }

    /** Beállítja a szomszédos aknák számát, amennyiben a mező nem bomba és a
     * szomszédban legalább egy akna van. */
    public void setNeighbourMines(int neighbourMines) {
        if (neighbourMines > 0 && !mine) {
            this.setLabelState(COUNTER_LABEL);
            this.neighbourMines = neighbourMines;
        }
    }

    public boolean isButton() {
        return button;
    }

    public void setButton(boolean button) {
        this.button = button;
    }

    public int getButtonState() {
        return buttonState;
    }

    public void setButtonState(int buttonState) {
        this.buttonState = buttonState;
    }

    public int getLabelState() {
        return labelState;
    }

    public void setLabelState(int labelState) {
        this.labelState = labelState;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}