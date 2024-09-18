package org.example.entity;

import org.example.entity.record.Record;
import org.example.entity.record.Records;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/**
 * Több osztály számára is fontos adatokat tartalmazó osztály
 */
public class DataModule implements Constants, Colors {

    /**
     * adatmodul
     */
    private static DataModule dataModule;

    /**
     * az aktuális szint
     */
    private Level level;

    /**
     * az egyéni szint van-e kiválasztva
     */
    private Level customLevel;

    /**
     * Megadja, hogy az egyéni játék van-e kiválasztva
     */
    private boolean custom;

    /**
     * A kezdő szint rekordja
     */
    private Records beginnerRecords;

    /**
     * A haladó szint rekordja
     */
    private Records advancedRecords;

    /**
     * A mester szint rekordja
     */
    private Records masterRecords;

    /**
     * a felület kinézete
     */
    private int lookAndFeel;

    /**
     * Az eltelt idő
     */
    private int time;

    /**
     * a jelöletlen aknák száma
     */
    private int unmarkedMines;

    /**
     * elhelyezhetőek-e kérdőjelek a gombokon
     */
    private boolean signs;

    /**
     * törlődjelenk-e a számok
     */
    private boolean numbers;

    /**
     * zászlók villogtatása
     */
    private boolean flash;

    /**
     * Veszély jelzése
     */
    private boolean overFlags;

    /**
     * A játék állapota
     */
    private int playState = STOP;

    /**
     * Konstruktor
     */
    public DataModule() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Beolvassa az elmentett adatokat
     */
    private void jbInit() throws Exception {
        Settings settings = readSettings();
        this.level = settings.getLevel();
        this.customLevel = settings.getCustomLevel();
        this.custom = settings.isCustom();
        this.beginnerRecords = settings.getBeginnerRecords();
        this.advancedRecords = settings.getAdvancedRecords();
        this.masterRecords = settings.getMasterRecords();
        this.lookAndFeel = settings.getLookAndFeel();
        this.signs = settings.isSigns();
        this.numbers = settings.isNumbers();
        this.flash = settings.isFlash();
        this.overFlags = settings.isOverFlags();
    }

    /**
     * Visszaadja a számnak megfelelő színt
     */
    public Color createColor(int count) {
        if (count == 1)
            return COLOR_ONE;
        if (count == 2)
            return COLOR_TWO;
        if (count == 3)
            return COLOR_THREE;
        if (count == 4)
            return COLOR_FOUR;
        if (count == 5)
            return COLOR_FIVE;
        if (count == 6)
            return COLOR_SIX;
        if (count == 7)
            return COLOR_SEVEN;
        if (count == 8)
            return COLOR_EIGHT;
        return null;
    }

    /**
     * Növeli az időt
     */
    public void increaseTime() {
        if (time < MAX_TIME) // csak eddig nőveli az időt
            ++time;
    }

    /**
     * Növeli a jelöletlen mezők számát
     */
    public void increaseUnmarkedMines() {
        ++unmarkedMines;
    }

    /**
     * Csökkenti a jelöletlen mezők számát
     */
    public void decreaseUnmarkedMines() {
        --unmarkedMines;
    }

    /**
     * Megváltoztatja a kérdőjelek elhelyezhetőségének engedélyezését,
     * menti a változtatást.
     */
    public void changeSigns() {
        signs = !signs;
        writeSettings(getSettings());
    }

    /**
     * Megváltoztatja a számok törlésének engedélyezését, menti a változtatást
     */
    public void changeNumbers() {
        numbers = !numbers;
        writeSettings(getSettings());
    }

    /**
     * Megváltoztatja a zászlók villogtatásának engedélyezését, menti a
     * változtatást
     */
    public void changeFlash() {
        flash = !flash;
        writeSettings(getSettings());
    }

    /**
     * Megváltoztatja a veszély jelzésének engedélyezését, menti a
     * változtatást
     */
    public void changeOverFlags() {
        overFlags = !overFlags;
        writeSettings(getSettings());
    }

    /**
     * Kiírja a megadott beállításokat
     */
    public void writeSettings(Object object) {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("settings.dat"));
            os.writeObject(object);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Beolvassa a beállításokat
     */
    public Settings readSettings() {
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream("settings.dat"));
            Settings settings = (Settings) os.readObject();
            os.close();
            return settings;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Settings();
    }

    public static DataModule getDataModule() {
        if (dataModule == null) {
            dataModule = new DataModule();
        }
        return dataModule;
    }

    public Level getLevel() {
        return custom ? customLevel : level;
    }

    public void setDataModule(DataModule dataModule) {
        this.dataModule = dataModule;
    }

    /**
     * Beállítja a szintet, menti a változtatást
     */
    public void setLevel(Level level) {
        this.level = level;
        writeSettings(getSettings());
    }

    /**
     * Az osztályadatok alapján visszaad egy objektumot, mely a beállításokat
     * tartalmazza.
     */
    private Settings getSettings() {
        return new Settings(level,
                customLevel,
                custom,
                beginnerRecords,
                advancedRecords,
                masterRecords,
                lookAndFeel,
                signs,
                numbers,
                flash,
                overFlags);
    }

    /**
     *
     */
    public boolean newRecord() {
        return getTime() < getActualRecords().getWorstTime();
    }

    /**
     *
     */
    public void addRecord(Record newRecord) {
        getActualRecords().addRecord(newRecord);
        writeSettings(getSettings());
    }

    /**
     * Törli a rekordokat, menti a változtatást
     */
    public void resetRecords() {
        beginnerRecords = new Records();
        advancedRecords = new Records();
        masterRecords = new Records();
        writeSettings(getSettings());
    }


    /**
     * Visszaadja az aktuális szinthez tartozó rekordot.
     */
    public Records getActualRecords() {
        if (level.equals(BEGINNER))
            return beginnerRecords;
        if (level.equals(ADVANCED))
            return advancedRecords;
        if (level.equals(MASTER))
            return masterRecords;
        return null;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getUnmarkedMines() {
        return unmarkedMines;
    }

    public void setUnmarkedMines(int unmarkedMines) {
        this.unmarkedMines = unmarkedMines;
    }

    public int getLookAndFeel() {
        return lookAndFeel;
    }

    /**
     * Beállítja a kinézetet, menti a változtatást
     */
    public void setLookAndFeel(int lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
        writeSettings(getSettings());
    }

    public boolean isSigns() {
        return signs;
    }

    public void setSigns(boolean signs) {
        this.signs = signs;
    }

    public Records getAdvancedRecords() {
        return advancedRecords;
    }

    public Records getBeginnerRecords() {
        return beginnerRecords;
    }

    public Records getMasterRecords() {
        return masterRecords;
    }

    public void setPlayState(int playState) {
        this.playState = playState;
    }

    public int getPlayState() {
        return playState;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public boolean isFlash() {
        return flash;
    }

    public void setFlash(boolean flash) {
        this.flash = flash;
    }

    public boolean isOverFlags() {
        return overFlags;
    }

    public void setOverFlags(boolean overFlags) {
        this.overFlags = overFlags;
    }

    public Level getCustomLevel() {
        return customLevel;
    }

    public void setCustomLevel(Level customLevel) {
        this.customLevel = customLevel;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
        writeSettings(getSettings());
    }
}