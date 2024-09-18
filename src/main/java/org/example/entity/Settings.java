package org.example.entity;

import org.example.entity.record.Records;

import java.io.Serializable;

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
 * A játék beállításait tartalmazó osztály
 */
public class Settings implements Serializable, Constants {

    /**
     * A nehézségi fok
     */
    private Level level;

    /**
     * Az egyéni beállítás
     */
    private Level customLevel;

    /**
     * Megadja, hogy az egyéni játék van-e kiválasztva
     */
    private boolean custom;

    /**
     * Kezdő szinhez tartozó rekord
     */
    private Records beginnerRecords;

    /**
     * Haladó szinhez tartozó rekord
     */
    private Records advancedRecords;

    /**
     * Mester szinhez tartozó rekord
     */
    private Records masterRecords;

    /**
     * A játék kinézete
     */
    int lookAndFeel;

    /**
     * Kérdőjelek elhelyezhetősége
     */
    private boolean signs;

    /**
     * Számok törlése
     */
    private boolean numbers;

    /**
     * Zászlók villogtatása
     */
    private boolean flash;

    /**
     * Veszély jelzése
     */
    private boolean overFlags;

    /**
     * konsturktor
     */
    public Settings(Level level,
                    Level customLevel,
                    boolean custom,
                    Records beginnerRecords,
                    Records advancedRecords,
                    Records masterRecords,
                    int lookAndFeel,
                    boolean signs,
                    boolean numbers,
                    boolean flash,
                    boolean overFlags) {
        this.level = level;
        this.customLevel = customLevel;
        this.custom = custom;
        this.beginnerRecords = beginnerRecords;
        this.advancedRecords = advancedRecords;
        this.masterRecords = masterRecords;
        this.lookAndFeel = lookAndFeel;
        this.signs = signs;
        this.numbers = numbers;
        this.flash = flash;
        this.overFlags = overFlags;
    }

    /**
     * konsturktor
     */
    public Settings() {
        this(BEGINNER,
                BEGINNER,
                false,
                new Records(),
                new Records(),
                new Records(),
                METAL_LOOK_AND_FEEL,
                false,
                false,
                false,
                false);
    }

    public Records getAdvancedRecords() {
        return advancedRecords;
    }

    public Records getBeginnerRecords() {
        return beginnerRecords;
    }

    public Level getLevel() {
        return level;
    }

    public int getLookAndFeel() {
        return lookAndFeel;
    }

    public Records getMasterRecords() {
        return masterRecords;
    }

    public boolean isSigns() {
        return signs;
    }

    public void setAdvancedRecords(Records advancedRecords) {
        this.advancedRecords = advancedRecords;
    }

    public void setBeginnerRecords(Records beginnerRecords) {
        this.beginnerRecords = beginnerRecords;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setLookAndFeel(int lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    public void setMasterRecords(Records masterRecords) {
        this.masterRecords = masterRecords;
    }

    public void setSigns(boolean signs) {
        this.signs = signs;
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
    }
}