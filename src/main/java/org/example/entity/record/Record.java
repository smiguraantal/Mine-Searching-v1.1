package org.example.entity.record;

import org.example.entity.Constants;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/** Rekord osztály */
public class Record implements Serializable, Comparable, Constants {

    /** a csúcstartó neve */
    private String name;

    /** ennyi idő alatt leplezte le az összes aknát */
    private int time;

    /** a rekord születésének időpontja */
    private GregorianCalendar date;

    /** konstruktor */
    public Record(String name, int time, GregorianCalendar date) {
        this.name = name;
        this.time = time;
        this.date = date;
    }

    /** konstruktor */
    public Record() {
        this(ANONYM, MAX_TIME, DEFAULT_DATE);
    }

    /** Időeredményre, azon belül dátumra rendez. */
    public int compareTo(Object object) {
        Record record = (Record) object;
        if (getTime() > record.getTime())
            return 1;
        else if (getTime() < record.getTime())
            return -1;
            // ha egyenlő a két időeredmény, akkor már a dátum lesz viszgálva
        else if (date.getTimeInMillis() > record.getDate().getTimeInMillis())
            return 1;
        else if (date.getTimeInMillis() < record.getDate().getTimeInMillis())
            return -1;
        return 0;
    }

    /** Formázottan adja vissza a dátumot */
    public String getDateToString() {
        if (date == null)
            return "";
        return date.get(Calendar.YEAR) +
                "." +
                format((date.get(Calendar.MONTH) + 1)) +
                "." +
                format(date.get(Calendar.DAY_OF_MONTH)) +
                ".";
    }

    private String format(int number) {
        return number < 10 ? "0" + number : "" + number;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
