package org.example.gui.dialog;

import org.example.entity.DataModule;
import org.example.entity.record.Records;
import org.example.gui.MessageManager;
import org.example.gui.MineFrame;
import org.example.gui.WindowLocation;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <p>Title: MineSearching</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

public class BestResultDialog extends JDialog {

    /**
     * Adatmodul
     */
    DataModule dataModule = DataModule.getDataModule();

    /**
     * A főablak
     */
    MineFrame mineFrame;

    JPanel panel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JButton btReset = new JButton();
    JButton btClose = new JButton();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    Border border1;
    GridLayout gridLayout1 = new GridLayout();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();
    JPanel jPanel6 = new JPanel();
    Border border2;
    TitledBorder titledBorder1;
    Border border3;
    TitledBorder titledBorder2;
    Border border4;
    TitledBorder titledBorder3;
    JLabel jLabel1 = new JLabel();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel lbBeginnerName1 = new JLabel();
    JLabel lbBeginnerName2 = new JLabel();
    JLabel lbBeginnerName3 = new JLabel();
    JLabel lbBeginnerDate1 = new JLabel();
    JLabel lbBeginnerDate2 = new JLabel();
    JLabel lbBeginnerDate3 = new JLabel();
    JLabel jLabel10 = new JLabel();
    GridBagLayout gridBagLayout3 = new GridBagLayout();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JLabel lbAdvancedName1 = new JLabel();
    JLabel lbAdvancedName2 = new JLabel();
    JLabel lbAdvancedName3 = new JLabel();
    JLabel lbAdvancedDate1 = new JLabel();
    JLabel lbAdvancedDate2 = new JLabel();
    JLabel lbAdvancedDate3 = new JLabel();
    GridBagLayout gridBagLayout4 = new GridBagLayout();
    JLabel jLabel19 = new JLabel();
    JLabel jLabel20 = new JLabel();
    JLabel jLabel21 = new JLabel();
    JLabel lbMasterName1 = new JLabel();
    JLabel lbMasterName2 = new JLabel();
    JLabel lbMasterName3 = new JLabel();
    JLabel lbMasterDate1 = new JLabel();
    JLabel lbMasterDate2 = new JLabel();
    JLabel lbMasterDate3 = new JLabel();
    Border border5;
    JLabel lbBeginnerTime1 = new JLabel();
    JLabel lbBeginnerTime2 = new JLabel();
    JLabel lbBeginnerTime3 = new JLabel();
    Border border6;
    JLabel lbAdvancedTime1 = new JLabel();
    JLabel lbAdvancedTime2 = new JLabel();
    JLabel lbAdvancedTime3 = new JLabel();
    JLabel lbMasterTime2 = new JLabel();
    JLabel lbMasterTime1 = new JLabel();
    JLabel lbMasterTime3 = new JLabel();
    Border border7;
    TitledBorder border100;
    TitledBorder border101;
    TitledBorder border102;
    Font font;

    public BestResultDialog(MineFrame mineFrame) {
        super(mineFrame, "Legjobb idők", true);
        this.mineFrame = mineFrame;
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void jbInit() throws Exception {
        setTitledBorders();

        border5 = BorderFactory.createCompoundBorder(border100, BorderFactory.createEmptyBorder(5, 0, 5, 0));
        border6 = BorderFactory.createCompoundBorder(border101, BorderFactory.createEmptyBorder(5, 0, 5, 0));
        border7 = BorderFactory.createCompoundBorder(border102, BorderFactory.createEmptyBorder(5, 0, 5, 0));
        setResizable(false);
        border1 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel1.setLayout(borderLayout1);
        btReset.setText("Eredmények törlése");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btReset_actionPerformed(e);
            }
        });
        btClose.setText("Bezárás");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btClose_actionPerformed(e);
            }
        });
        jPanel2.setLayout(gridBagLayout1);
        jPanel3.setLayout(gridLayout1);
        jPanel3.setBorder(border1);
        gridLayout1.setColumns(1);
        gridLayout1.setRows(3);
        gridLayout1.setVgap(5);
        jPanel4.setBorder(border5);
        jPanel4.setLayout(gridBagLayout2);
        jPanel5.setBorder(border6);
        jPanel5.setLayout(gridBagLayout3);
        jPanel6.setBorder(border7);
        jPanel6.setLayout(gridBagLayout4);
        jLabel1.setPreferredSize(new Dimension(20, 15));
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setHorizontalTextPosition(SwingConstants.TRAILING);
        jLabel1.setText("1.");
        jLabel2.setPreferredSize(new Dimension(20, 15));
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("2.");
        jLabel3.setPreferredSize(new Dimension(20, 15));
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("3.");
        lbBeginnerName1.setPreferredSize(new Dimension(150, 15));
        lbBeginnerName1.setText("Név");
        lbBeginnerName2.setPreferredSize(new Dimension(150, 15));
        lbBeginnerName2.setText("Név");
        lbBeginnerName3.setPreferredSize(new Dimension(150, 15));
        lbBeginnerName3.setText("Név");
        lbBeginnerDate1.setPreferredSize(new Dimension(80, 15));
        lbBeginnerDate1.setText("2003.10.24.");
        lbBeginnerDate2.setPreferredSize(new Dimension(80, 15));
        lbBeginnerDate2.setText("dátum");
        lbBeginnerDate3.setPreferredSize(new Dimension(80, 15));
        lbBeginnerDate3.setText("dátum");
        jLabel10.setPreferredSize(new Dimension(20, 15));
        jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel10.setText("1.");
        jLabel11.setPreferredSize(new Dimension(20, 15));
        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel11.setText("2.");
        jLabel12.setPreferredSize(new Dimension(20, 15));
        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel12.setText("3.");
        lbAdvancedName1.setPreferredSize(new Dimension(150, 15));
        lbAdvancedName1.setText("jLabel13");
        lbAdvancedName2.setPreferredSize(new Dimension(150, 15));
        lbAdvancedName2.setText("jLabel14");
        lbAdvancedName3.setPreferredSize(new Dimension(150, 15));
        lbAdvancedName3.setText("jLabel15");
        lbAdvancedDate1.setPreferredSize(new Dimension(80, 15));
        lbAdvancedDate1.setText("dátum");
        lbAdvancedDate2.setPreferredSize(new Dimension(80, 15));
        lbAdvancedDate2.setText("jLabel17");
        lbAdvancedDate3.setPreferredSize(new Dimension(80, 15));
        lbAdvancedDate3.setText("jLabel18");
        jLabel19.setPreferredSize(new Dimension(20, 15));
        jLabel19.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel19.setText("1.");
        jLabel20.setPreferredSize(new Dimension(20, 15));
        jLabel20.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel20.setText("2.");
        jLabel21.setPreferredSize(new Dimension(20, 15));
        jLabel21.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel21.setText("3.");
        lbMasterName1.setPreferredSize(new Dimension(150, 15));
        lbMasterName1.setText("jLabel22");
        lbMasterName2.setPreferredSize(new Dimension(150, 15));
        lbMasterName2.setText("jLabel23");
        lbMasterName3.setPreferredSize(new Dimension(150, 15));
        lbMasterName3.setText("jLabel24");
        lbMasterDate1.setPreferredSize(new Dimension(80, 15));
        lbMasterDate1.setText("2004.08.28.");
        lbMasterDate2.setPreferredSize(new Dimension(80, 15));
        lbMasterDate2.setText("jLabel26");
        lbMasterDate3.setPreferredSize(new Dimension(80, 15));
        lbMasterDate3.setText("jLabel27");
        lbBeginnerTime1.setPreferredSize(new Dimension(40, 15));
        lbBeginnerTime1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbBeginnerTime1.setText("12");
        lbBeginnerTime2.setPreferredSize(new Dimension(40, 15));
        lbBeginnerTime2.setHorizontalAlignment(SwingConstants.RIGHT);
        lbBeginnerTime2.setText("17");
        lbBeginnerTime3.setPreferredSize(new Dimension(40, 15));
        lbBeginnerTime3.setHorizontalAlignment(SwingConstants.RIGHT);
        lbBeginnerTime3.setText("379");
        lbAdvancedTime1.setPreferredSize(new Dimension(40, 15));
        lbAdvancedTime1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbAdvancedTime1.setText("12");
        lbAdvancedTime2.setPreferredSize(new Dimension(40, 15));
        lbAdvancedTime2.setHorizontalAlignment(SwingConstants.RIGHT);
        lbAdvancedTime2.setText("46");
        lbAdvancedTime3.setPreferredSize(new Dimension(40, 15));
        lbAdvancedTime3.setHorizontalAlignment(SwingConstants.RIGHT);
        lbAdvancedTime3.setText("556");
        lbMasterTime2.setPreferredSize(new Dimension(40, 15));
        lbMasterTime2.setHorizontalAlignment(SwingConstants.RIGHT);
        lbMasterTime2.setText("335");
        lbMasterTime1.setPreferredSize(new Dimension(40, 15));
        lbMasterTime1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbMasterTime1.setText("35");
        lbMasterTime3.setPreferredSize(new Dimension(40, 15));
        lbMasterTime3.setHorizontalAlignment(SwingConstants.RIGHT);
        lbMasterTime3.setText("999");
        getContentPane().add(panel1);
        panel1.add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(btReset, null);
        jPanel1.add(btClose, null);
        panel1.add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(jPanel3, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        jPanel3.add(jPanel4, null);
        jPanel4.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel4.add(jLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel4.add(jLabel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel4.add(lbBeginnerName1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 10, 0), 0, 0));
        jPanel4.add(lbBeginnerName2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 10, 0), 0, 0));
        jPanel4.add(lbBeginnerName3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
        jPanel4.add(lbBeginnerDate1, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 10, 0), 0, 0));
        jPanel4.add(lbBeginnerDate2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 10, 0), 0, 0));
        jPanel4.add(lbBeginnerDate3, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 0, 0), 0, 0));
        jPanel4.add(lbBeginnerTime1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel4.add(lbBeginnerTime2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel4.add(lbBeginnerTime3, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(jPanel5, null);
        jPanel5.add(jLabel10, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel5.add(jLabel11, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel5.add(lbAdvancedName1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 10, 0), 0, 0));
        jPanel5.add(lbAdvancedName2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 10, 0), 0, 0));
        jPanel5.add(lbAdvancedName3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
        jPanel5.add(lbAdvancedDate1, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 10, 0), 0, 0));
        jPanel5.add(lbAdvancedDate2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 10, 0), 0, 0));
        jPanel5.add(lbAdvancedDate3, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 0, 0), 0, 0));
        jPanel5.add(jLabel12, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel5.add(lbAdvancedTime1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel5.add(lbAdvancedTime2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel5.add(lbAdvancedTime3, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(jPanel6, null);
        jPanel6.add(jLabel19, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel6.add(jLabel20, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel6.add(jLabel21, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel6.add(lbMasterName1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 10, 0), 0, 0));
        jPanel6.add(lbMasterName2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 10, 0), 0, 0));
        jPanel6.add(lbMasterName3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
        jPanel6.add(lbMasterDate1, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 10, 0), 0, 0));
        jPanel6.add(lbMasterDate2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 10, 0), 0, 0));
        jPanel6.add(lbMasterDate3, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 20, 0, 0), 0, 0));
        jPanel6.add(lbMasterTime2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel6.add(lbMasterTime1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        jPanel6.add(lbMasterTime3, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        btClose.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });

        btReset.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });
    }

    /**
     * Létrehozza a címes kereteket.
     */
    private void setTitledBorders() {
        font = (Font) (UIManager.get("TitledBorder.font"));

        border100 = new TitledBorder(BorderFactory.createEtchedBorder(),
                " Kezdő ",
                TitledBorder.CENTER,
                SwingConstants.CENTER);

        border101 = new TitledBorder(BorderFactory.createEtchedBorder(),
                " Haladó ",
                TitledBorder.CENTER,
                SwingConstants.CENTER);


        border102 = new TitledBorder(BorderFactory.createEtchedBorder(),
                " Mester ",
                TitledBorder.CENTER,
                SwingConstants.CENTER);
    }

    /**
     * Escape-re a dialógus eltűnik.
     */
    private void keyListening(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            hide();
    }

    /**
     * Beállítja a keretek betűtípusát.
     */
    private void setTitledFonts() {
        font = (Font) (UIManager.get("TitledBorder.font"));
        border100.setTitleFont(new Font(font.getName(),
                font.getStyle() + Font.ITALIC,
                font.getSize() + 1));

        border101.setTitleFont(new Font(font.getName(),
                font.getStyle() + Font.ITALIC,
                font.getSize() + 1));

        border102.setTitleFont(new Font(font.getName(),
                font.getStyle() + Font.ITALIC,
                font.getSize() + 1));
    }

    /**
     * Megjeleníti a dialógust
     */
    public void showDialog() {
        setTitledFonts();
        setLabels();
        btClose.requestFocus();
        pack();
        WindowLocation.center(this);
        show();
    }

    /**
     * Beállítja a címkék értékét az adatmodulban tárol rekordok alapján
     */
    private void setLabels() {
        Records beginnerRecords = dataModule.getBeginnerRecords();
        Records advancedRecords = dataModule.getAdvancedRecords();
        Records masterRecords = dataModule.getMasterRecords();

        // kezdő rekordok
        lbBeginnerName1.setText("" + beginnerRecords.getRecord_1().getName());
        lbBeginnerTime1.setText("" + beginnerRecords.getRecord_1().getTime());
        lbBeginnerDate1.setText("" + beginnerRecords.getRecord_1().getDateToString());

        lbBeginnerName2.setText("" + beginnerRecords.getRecord_2().getName());
        lbBeginnerTime2.setText("" + beginnerRecords.getRecord_2().getTime());
        lbBeginnerDate2.setText("" + beginnerRecords.getRecord_2().getDateToString());

        lbBeginnerName3.setText("" + beginnerRecords.getRecord_3().getName());
        lbBeginnerTime3.setText("" + beginnerRecords.getRecord_3().getTime());
        lbBeginnerDate3.setText("" + beginnerRecords.getRecord_3().getDateToString());

        // haladó rekordok
        lbAdvancedName1.setText("" + advancedRecords.getRecord_1().getName());
        lbAdvancedTime1.setText("" + advancedRecords.getRecord_1().getTime());
        lbAdvancedDate1.setText("" + advancedRecords.getRecord_1().getDateToString());

        lbAdvancedName2.setText("" + advancedRecords.getRecord_2().getName());
        lbAdvancedTime2.setText("" + advancedRecords.getRecord_2().getTime());
        lbAdvancedDate2.setText("" + advancedRecords.getRecord_2().getDateToString());

        lbAdvancedName3.setText("" + advancedRecords.getRecord_3().getName());
        lbAdvancedTime3.setText("" + advancedRecords.getRecord_3().getTime());
        lbAdvancedDate3.setText("" + advancedRecords.getRecord_3().getDateToString());

        // mester rekordok
        lbMasterName1.setText("" + masterRecords.getRecord_1().getName());
        lbMasterTime1.setText("" + masterRecords.getRecord_1().getTime());
        lbMasterDate1.setText("" + masterRecords.getRecord_1().getDateToString());

        lbMasterName2.setText("" + masterRecords.getRecord_2().getName());
        lbMasterTime2.setText("" + masterRecords.getRecord_2().getTime());
        lbMasterDate2.setText("" + masterRecords.getRecord_2().getDateToString());

        lbMasterName3.setText("" + masterRecords.getRecord_3().getName());
        lbMasterTime3.setText("" + masterRecords.getRecord_3().getTime());
        lbMasterDate3.setText("" + masterRecords.getRecord_3().getDateToString());
    }

    /**
     * Összes rekord törlése
     */
    void btReset_actionPerformed(ActionEvent e) {
        if (MessageManager.showConfirmDialog(this, "Biztosan törli az összes rekordot?")) {
            dataModule.resetRecords();
            setLabels();
        }
    }

    /**
     * Ablak bezárása
     */
    void btClose_actionPerformed(ActionEvent e) {
        hide();
    }
}












