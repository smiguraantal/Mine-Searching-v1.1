package org.example.gui.dialog;

import org.example.entity.Constants;
import org.example.gui.MineFrame;
import org.example.gui.WindowLocation;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

/** Új rekord esetén a nevet bekérő dialógus */
public class NewRecordDialog extends JDialog implements Constants {

    /** A csúcstartó neve */
    String name;

    JPanel panel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JButton btOk = new JButton();
    JPanel jPanel2 = new JPanel();
    JTextField tfName = new JTextField();

    /** Konstruktor */
    public NewRecordDialog(MineFrame mineFrame) {
        super(mineFrame, "Dobogós helyezés", true);
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /** Felépíti a dialógust */
    private void jbInit() throws Exception {
        panel1.setLayout(borderLayout1);
        btOk.setText("Mentés");
        btOk.addActionListener(new NewRecordDialog_btOk_actionAdapter(this));
        tfName.setColumns(20);
        tfName.addActionListener(new NewRecordDialog_tfName_actionAdapter(this));
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new NewRecordDialog_this_windowAdapter(this));
        getContentPane().add(panel1);
        panel1.add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(btOk, null);
        panel1.add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(tfName, null);

        btOk.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });

        tfName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });
    }

    /** Escape-re a név értéke "Névtelen lesz", a dialógus eltűnik */
    private void keyListening(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            name = ANONYM;
            hide();
        }
    }

    /** Megjeleníti a dialógust, a mezőbe pedig a "Névtelen"-t jeleníti meg */
    public String showDialog() {
        tfName.setText(ANONYM);
        tfName.selectAll();
        tfName.requestFocus();
        pack();
        WindowLocation.center(this);
        show();
        return name;
    }

    /** Bezárásra a név értéke "Névtelen lesz", a dialógus eltűnik */
    void this_windowClosing(WindowEvent e) {
        name = ANONYM;
        hide();
    }

    /** A rendben gomb lenyomása */
    void btOk_actionPerformed(ActionEvent e) {
        name = tfName.getText().trim().equals("") ? ANONYM : tfName.getText();
        hide();
    }

    /** Enter leütése a szövegmezőn */
    void tfName_actionPerformed(ActionEvent e) {
        name = tfName.getText().trim().equals("") ? ANONYM : tfName.getText();
        hide();
    }
}


class NewRecordDialog_this_windowAdapter extends java.awt.event.WindowAdapter {
    NewRecordDialog adaptee;

    NewRecordDialog_this_windowAdapter(NewRecordDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void windowClosing(WindowEvent e) {
        adaptee.this_windowClosing(e);
    }
}

class NewRecordDialog_btOk_actionAdapter implements java.awt.event.ActionListener {
    NewRecordDialog adaptee;

    NewRecordDialog_btOk_actionAdapter(NewRecordDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btOk_actionPerformed(e);
    }
}

class NewRecordDialog_tfName_actionAdapter implements java.awt.event.ActionListener {
    NewRecordDialog adaptee;

    NewRecordDialog_tfName_actionAdapter(NewRecordDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.tfName_actionPerformed(e);
    }
}