package org.example.entity.record;

import org.example.entity.Constants;

import java.io.Serializable;
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

/** Rekordok osztály */
public class Records implements Serializable, Constants {

    /** A három legjobb rekord */
    private Vector records = new Vector();

    /** konstruktor */
    public Records(Vector records) {
        this.records = records;
    }

    /** konstruktor */
    public Records() {
        records.add(new Record());
        records.add(new Record());
        records.add(new Record());
    }

    /** Visszaadja  a legrosszabb időeredményt */
    public int getWorstTime() {
        Collections.sort(records);
        return ((Record) records.lastElement()).getTime();
    }

    /** Hozzáadja a kapott rekordot a rekordokhoz, majd rendezi a vektort.
     * Ezután csak a három legjobb rekord marad érvényben */
    public void addRecord(Record newRecord) {
        records.add(newRecord);
        Collections.sort(records);
        records.setSize(3);
    }

    public Record getRecord_1() {
        return (Record) records.get(0);
    }

    public Record getRecord_2() {
        return (Record) records.get(1);
    }

    public Record getRecord_3() {
        return (Record) records.get(2);
    }
}





