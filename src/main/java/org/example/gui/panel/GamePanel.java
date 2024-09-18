package org.example.gui.panel;

import org.example.entity.Colors;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Level;
import org.example.gui.Field;
import org.example.gui.Flash;
import org.example.gui.MineFrame;

import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Collections;
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

/** A mezőket összefogó panel */
public class GamePanel extends JPanel implements Constants, Colors {

    /** adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** ablak */
    private MineFrame mineFrame;

    /** mezők */
    private Field[][] fields;

    /** Sikeres játék esetén a zászlók villogtatója */
    private Flash flash;

    BorderLayout borderLayout1 = new BorderLayout();

    /** Konstruktor */
    public GamePanel(MineFrame mineFrame) {
        this.mineFrame = mineFrame;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /** Felépíti a felületet */
    void jbInit() throws Exception {
        this.setPreferredSize(calcSize());
        createLayout();
        addFields();
        //chooseMines();
        //setCounts();
    }

    /** Létrehozza az elrendezés-menedzsert a szinttől függően */
    private void createLayout() {
        Level level = dataModule.getLevel();
        setLayout(new GridLayout(level.getRows(), level.getColumns()));
    }

    /** Létrehozza és elhelyezi a mezőket */
    private void addFields() {
        Level level = dataModule.getLevel();
        fields = new Field[level.getRows()][level.getColumns()];
        for (int row = 0; row < level.getRows(); row++) {
            for (int column = 0; column < level.getColumns(); column++) {
                fields[row][column] = new Field(this, row, column);
                add(fields[row][column]);
            }
        }
    }

    /** A mezők közül véletlenszerűen kiválaszt annyi aknát, amennyi az adott
     * szinthez tartozik */
    private void chooseMines(int rowClick, int columnClick) {
        Level level = dataModule.getLevel();
        Vector vec = new Vector();
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[row].length; column++) {
                if (row == rowClick && column == columnClick) // az nem lehet bomba, amelyiken az első klikkelé történt
                    continue;
                else
                    vec.add(fields[row][column]); // berakás egy vektorba
            }
        }
        Collections.shuffle(vec); // keverés
        for (int mines = 0; mines < level.getMines(); mines++) {
            Field field = (Field) vec.remove(0); // kiválasztás
            field.setMine(true);
            field.setLabelState(MINE_LABEL);
        }
    }

    /** Megszámolja és beállítja, hogy a mezőknek hány akna szomszédjuk van */
    private void setCounts() {
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[row].length; column++) {
                int count = 0;

                if (isMine(row - 1, column - 1)) // bal fent
                    count++;
                if (isMine(row - 1, column)) // fent
                    count++;
                if (isMine(row - 1, column + 1)) // jobb fent
                    count++;
                if (isMine(row, column - 1)) // balra
                    count++;
                if (isMine(row, column + 1)) // jobbra
                    count++;
                if (isMine(row + 1, column - 1)) // bal lent
                    count++;
                if (isMine(row + 1, column)) // lent
                    count++;
                if (isMine(row + 1, column + 1)) // jobb lent
                    count++;

                fields[row][column].setNeighbourMines(count);
            }
        }
    }

    /** Rekurzívan kitisztítja a pályát a kapott sor-, és oszlopindexű mezőtől
     * kezdve. */
    public void clear(int row, int column) {
        if (!fields[row][column].isButton())  // ha már nem gomb
            return;
        else  // ha gomb
            if (fields[row][column].getButtonState() == FLAG_BUTTON)  // ha zászlóval jelölt
                return;

        fields[row][column].setButton(false);
        if (fields[row][column].getNeighbourMines() == 0) // ha egyetlen akna sincs a szomszédságában
            fields[row][column].setLabelState(EMPTY_LABEL);
        else // ha van a szomszédságában akna
            fields[row][column].setLabelState(COUNTER_LABEL);
        fields[row][column].repaint();

        if (clearable(row, column, -1, -1)) // bal fent
            clear(row - 1, column - 1);
        if (clearable(row, column, -1, 0)) // fent
            clear(row - 1, column);
        if (clearable(row, column, -1, +1)) // jobb fent
            clear(row - 1, column + 1);
        if (clearable(row, column, 0, -1)) // bal
            clear(row, column - 1);
        if (clearable(row, column, 0, +1)) // jobb
            clear(row, column + 1);
        if (clearable(row, column, +1, -1)) // bal lent
            clear(row + 1, column - 1);
        if (clearable(row, column, +1, 0)) // lent
            clear(row + 1, column);
        if (clearable(row, column, +1, +1)) // jobb lent
            clear(row + 1, column + 1);
    }

    /** Leleplezi egy cimke összes olyan szomszédját, melyek nincsenek zászlóval
     * jelölve és még gombok. A szomszédok leleplezése viszont csak abban az
     * esetben lehetséges, ha azok zászlóinak összege megegyezik a cimke által
     * mutatott értékkel. */
    public void showNeighbours(int row, int column) {
        Vector neighbours = new Vector();
        int flags = 0;

        if (within(row - 1, column - 1)) // bal fent
            neighbours.add(fields[row - 1][column - 1]);
        if (within(row - 1, column)) // fent
            neighbours.add(fields[row - 1][column]);
        if (within(row - 1, column + 1)) // jobb fent
            neighbours.add(fields[row - 1][column + 1]);
        if (within(row, column - 1)) // balra
            neighbours.add(fields[row][column - 1]);
        if (within(row, column + 1)) // jobbra
            neighbours.add(fields[row][column + 1]);
        if (within(row + 1, column - 1)) // bal lent
            neighbours.add(fields[row + 1][column - 1]);
        if (within(row + 1, column)) // lent
            neighbours.add(fields[row + 1][column]);
        if (within(row + 1, column + 1)) // jobb lent
            neighbours.add(fields[row + 1][column + 1]);
        // megszámolja, hogy hány zászlóval jelölt szomszédja van
        for (int i = 0; i < neighbours.size(); i++) {
            Field field = (Field) neighbours.get(i);
            if (field.isButton() && field.getButtonState() == FLAG_BUTTON)
                ++flags;
        }
        // leleplezi a nem zászlóval jelölt szomszédait
        if (flags == fields[row][column].getNeighbourMines()) { // ha annyi zászló lett elhelyezve a szomszédságában, mint amennyit jelez a címke
            for (int i = 0; i < neighbours.size(); i++) {
                Field field = (Field) neighbours.get(i);
                if (field.isButton() && field.getButtonState() != FLAG_BUTTON) { // ha nem zászlóval jelölt gomb
                    field.push();
                }
            }
        }
    }

    /** Eltűnteti azokat a számlálókat, melyek mellett pont annyi gomb van,
     * amennyit a számláló mutat és a gombok mindegyikén zászló van. */
    public void clearCounters() {
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[row].length; column++) {
                Field field = fields[row][column];
                if (field.isButton() || field.getLabelState() != COUNTER_LABEL) // ha még gomb vagy nem számlálós címke
                    continue;
                if (clearableCounter(row, column)) { // ha eltűntethető a számláló
                    field.setHidden(true);
                    field.repaint();
                }
            }
        }
    }

    /** Visszahelyezi a számokat az adott mező környékén */
    public void putCounters(int row, int column) {
        if (isCounterLabel(row - 1, column - 1)) {
            fields[row - 1][column - 1].setHidden(false);
            fields[row - 1][column - 1].repaint();
        }

        if (isCounterLabel(row - 1, column)) {
            fields[row - 1][column].setHidden(false);
            fields[row - 1][column].repaint();
        }

        if (isCounterLabel(row - 1, column + 1)) {
            fields[row - 1][column + 1].setHidden(false);
            fields[row - 1][column + 1].repaint();
        }

        if (isCounterLabel(row, column - 1)) {
            fields[row][column - 1].setHidden(false);
            fields[row][column - 1].repaint();
        }

        if (isCounterLabel(row, column + 1)) {
            fields[row][column + 1].setHidden(false);
            fields[row][column + 1].repaint();
        }

        if (isCounterLabel(row + 1, column - 1)) {
            fields[row + 1][column - 1].setHidden(false);
            fields[row + 1][column - 1].repaint();
        }

        if (isCounterLabel(row + 1, column)) {
            fields[row + 1][column].setHidden(false);
            fields[row + 1][column].repaint();
        }

        if (isCounterLabel(row + 1, column + 1)) {
            fields[row + 1][column + 1].setHidden(false);
            fields[row + 1][column + 1].repaint();
        }
    }

    /** Visszahelyezi az összes számlálót */
    public void putAllCounters() {
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[row].length; column++) {
                Field field = fields[row][column];
                if (!field.isButton() && field.getLabelState() == COUNTER_LABEL) { // ha számlálós címke
                    if (field.isHidden()) { // csak akkor ha rejtett volt
                        field.setHidden(false);
                        field.repaint();
                    }
                }
            }
        }
    }

    /** Visszaadja, hogy a kapott sor és oszlopindexű mező számlálós címke-e */
    private boolean isCounterLabel(int row, int column) {
        return
                isLabel(row, column) &&
                        fields[row][column].getLabelState() == COUNTER_LABEL;
    }


    /** Visszaadja, hogy a mezőnek annyi és csak annyi szászlóval jelölt gomb
     *  szomszédja van-e amennyit az jelez */
    private boolean clearableCounter(int row, int column) {
        return
                within(row, column) &&
                        getNeighbourButtons(row, column) == getNeighbourFlagButtons(row, column) &&
                        getNeighbourButtons(row, column) == fields[row][column].getNeighbourMines();
    }

    /** Visszaadja, hogy a kapott sor és oszlopindexű mező gomb-e */
    private boolean isButton(int row, int column) {
        return within(row, column) &&
                fields[row][column].isButton();
    }

    /** Visszaadja, hogy a kapott sor és oszlopindexű mező zászlóval jelölt
     * gomb-e*/
    private boolean isFlagButton(int row, int column) {
        return isButton(row, column) &&
                fields[row][column].getButtonState() == FLAG_BUTTON;
    }

    /** Visszaadja, hogy a kapott sor és oszlopindexű mező címke-e */
    private boolean isLabel(int row, int column) {
        return (within(row, column) &&
                !fields[row][column].isButton());
    }

    /** Visszaadja a szomszédos gombok számát */
    public int getNeighbourButtons(int row, int column) {
        int neighbourButtons = 0;
        if (isButton(row - 1, column - 1)) // bal fent
            ++neighbourButtons;
        if (isButton(row - 1, column)) // fent
            ++neighbourButtons;
        if (isButton(row - 1, column + 1)) // jobb fent
            ++neighbourButtons;
        if (isButton(row, column - 1)) // balra
            ++neighbourButtons;
        if (isButton(row, column + 1)) // jobbra
            ++neighbourButtons;
        if (isButton(row + 1, column - 1)) // bal lent
            ++neighbourButtons;
        if (isButton(row + 1, column)) // lent
            ++neighbourButtons;
        if (isButton(row + 1, column + 1)) // jobb lent
            ++neighbourButtons;
        return neighbourButtons;
    }

    /** Visszaadja a szomszédos zászlóval jelölt gombok számát */
    public int getNeighbourFlagButtons(int row, int column) {
        int neighbourFlagButtons = 0;
        if (isFlagButton(row - 1, column - 1)) // bal fent
            ++neighbourFlagButtons;
        if (isFlagButton(row - 1, column)) // fent
            ++neighbourFlagButtons;
        if (isFlagButton(row - 1, column + 1)) // jobb fent
            ++neighbourFlagButtons;
        if (isFlagButton(row, column - 1)) // balra
            ++neighbourFlagButtons;
        if (isFlagButton(row, column + 1)) // jobbra
            ++neighbourFlagButtons;
        if (isFlagButton(row + 1, column - 1)) // bal lent
            ++neighbourFlagButtons;
        if (isFlagButton(row + 1, column)) // lent
            ++neighbourFlagButtons;
        if (isFlagButton(row + 1, column + 1)) // jobb lent
            ++neighbourFlagButtons;
        return neighbourFlagButtons;
    }

    /** Törli az összes kérdőjelet */
    public void removeSigns() {
        if (dataModule.getPlayState() == STOP) // ha vége a játéknak, akkor már nem lehet változtatni
            return;
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[row].length; column++) {
                Field field = fields[row][column];
                if (field.isButton() && field.getButtonState() == QUESTION_MARK_BUTTON) { // ha krdőjeles gomb
                    field.setButtonState(EMPTY_BUTTON);
                    repaint();
                }
            }
        }
    }

    /** Megváltoztatja a számok törölhetőségét a beállítástól függően */
    public void changeNumbers() {
        if (dataModule.getPlayState() == STOP) // ha vége a játéknak, akkor már nem lehet változtatni
            return;
        if (dataModule.isNumbers()) { // ha törölhetők a számok
            clearCounters();
        } else { // ha nincs engedélyezve a számok törlése
            putAllCounters();
        }
    }

    /** Megváltoztatja a veszély jelzésének engedélyezését */
    public void changeOverFlags() {
        if (dataModule.getPlayState() == STOP) // ha vége a játéknak, akkor már nem lehet változtatni
            return;
        showOverFlags();
    }

    /** Visszaadja, hogy a kapott sor-, és oszlopindexű mezőtől folytatható-e
     * a tisztítás az adott irányba. */
    private boolean clearable(int row, int column, int x, int y) {
        return !isMine(row, column) &&
                fields[row][column].getNeighbourMines() == 0 &&
                within(row + x, column + y);
    }

    /** Visszaadja, hogy a pályán található gombok száma megegyezik-e a
     * szintnek megfelelő aknák számával. */
    public boolean accord() {
        int countOfButtons = 0;
        for (int row = 0; row < fields.length; row++) {
            for (int columns = 0; columns < fields[row].length; columns++) {
                if (fields[row][columns].isButton())
                    ++countOfButtons;
            }
        }
        return countOfButtons == dataModule.getLevel().getMines();
    }

    /** Visszaadja, hogy van-e felrobbant akna. */
    public boolean isBlownUpMine() {
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[row].length; column++) {
                if (fields[row][column].getLabelState() == BLOWN_UP_MINE_LABEL)
                    return true;
            }
        }
        return false;
    }

    /** Minden gombra egy zászlót rajzol */
    private void putFlags() {
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[row].length; column++) {
                if (fields[row][column].isButton()) {
                    fields[row][column].setButtonState(FLAG_BUTTON);
                    fields[row][column].repaint();
                }
            }
        }
    }

    /** Leleplezi az összes aknát, valamint megmutatja, hogy mely mezők lettek
     * tévesen megjelölve zászlóval. */
    public void showMines() {
        mineFrame.failed();
        Level level = dataModule.getLevel();
        for (int row = 0; row < level.getRows(); row++) {
            for (int column = 0; column < level.getColumns(); column++) {
                fields[row][column].removeLabelListener();
                if (fields[row][column].isButton()) { // ha még gomb
                    if (fields[row][column].isMine()) { // ha akna
                        if (fields[row][column].getButtonState() != FLAG_BUTTON) { // ha nem zászlóval jelölt
                            fields[row][column].setButton(false);
                            fields[row][column].repaint();
                        }
                    } else { // ha nem akna
                        if (fields[row][column].getButtonState() == FLAG_BUTTON) { // ha szászlóval jelölt
                            fields[row][column].setLabelState(NON_MINE_LABEL);
                            fields[row][column].setButton(false);
                            fields[row][column].repaint();
                        }
                    }
                }
            }
        }
    }

    /** Jelzi, hogy melyik az a mező, amely mellett több akna lett megjelölve,
     * mint amennyi a mező értéke */
    private void showOverFlags() {
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[row].length; column++) {
                Field field = fields[row][column];
                if (field.isButton()) // ha még gomb
                    continue;

                if (field.getLabelState() == EMPTY_LABEL ||
                        field.getLabelState() == COUNTER_LABEL) { // ha üres vagy számlálós címke
                    if (getNeighbourFlagButtons(row, column) > field.getNeighbourMines()) { // ha a szomszédos gombokon több zászló lett elhelyezve, mint amennyi valójában van
                        if (dataModule.isOverFlags()) { // ha engedélyezve van a veszély jelzése
                            field.setBackground(Color.pink);
                        } else { // ha nincs engedélyezve a veszély jelzése
                            field.setBackground((Color) UIManager.get("Panel.background"));
                        }
                    } else { // ha nem lett több zászló elhelyezve a szomszédos gombokon
                        field.setBackground((Color) UIManager.get("Panel.background"));
                    }
                }
            }
        }
    }

    /** Visszaadja, hogy a kapott sor és oszlopindexű mező akna-e */
    private boolean isMine(int row, int column) {
        return within(row, column) && fields[row][column].isMine();
    }

    /** Visszaadja, hogy a sor és oszlopindexek a pályán belül vannak-e */
    private boolean within(int row, int column) {
        Level level = dataModule.getLevel();
        return row >= 0 &&
                column >= 0 &&
                row < level.getRows() &&
                column < level.getColumns();
    }

    /** Kiszámolja a pálya méretét */
    private Dimension calcSize() {
        Level level = dataModule.getLevel();
        int w = level.getColumns() * UNIT;
        int h = level.getRows() * UNIT;
        return new Dimension(w, h);
    }

    /** Visszaadja a gombokat egy vektorban */
    private Vector getButtons() {
        Vector buttons = new Vector();
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[row].length; column++) {
                if (fields[row][column].isButton()) {
                    buttons.add(fields[row][column]);
                }
            }
        }
        return buttons;
    }

    /** Egy klikkelés történt valamelyik mezőn */
    public void click() {
        if (dataModule.isNumbers()) // ha engedélyezve van a számok törlése
            clearCounters();
        if (dataModule.isOverFlags()) // ha engedélyezve van a veszély jelzése
            showOverFlags();
        if (accord() && !isBlownUpMine()) { // ha vége a játéknak
            putFlags();
            removeLabelListeners();
            if (dataModule.isNumbers()) // ha engedélyezve van a számok törlése
                clearCounters();
            if (dataModule.isFlash()) { // ha engedélyezve van a zászlók villogtatása
                flash = new Flash(getButtons());
                flash.start();
            }
            mineFrame.success();
        }
        mineFrame.refreshMineDisplay();
    }

    /** Megsemmisíti a villogtatót */
    public void stopFlash() {
        if (flash != null)
            flash.stop();
    }

    /** Eltávolítja az összes címkéről az egérkattintás-figyelőt */
    private void removeLabelListeners() {
        Level level = dataModule.getLevel();
        for (int row = 0; row < level.getRows(); row++) {
            for (int column = 0; column < level.getColumns(); column++) {
                fields[row][column].removeLabelListener();
            }
        }
    }

    /** Jelzi az ablaknak, hogy el kéne indítani az órát */
    public void startTime() {
        mineFrame.startTimer();
    }

    /** Meghatározza az aknák helyét. Az első kattintás helyén nem lehet akna!!! */
    public void initFields(int rowClick, int columnClick) {
        if (dataModule.getPlayState() == STOP) { // még nem kezdődött el a játék
            chooseMines(rowClick, columnClick);
            setCounts();
        }
    }

    /** Megkéri az ablakot, hogy jelenítse meg az átadott szöveget. */
    public void showMessage(String message) {
        mineFrame.showMessage(message);
    }
}