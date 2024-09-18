package org.example.gui.dialog;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Level;
import org.example.gui.MineFrame;
import org.example.gui.WindowLocation;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class CustomDialog extends JDialog implements Constants {

    /**
     * Adatmodul
     */
    DataModule dataModule = DataModule.getDataModule();

    /**
     * A főablak
     */
    private MineFrame mineFrame;

    JPanel panel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JButton btOk = new JButton();
    JButton btCancel = new JButton();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JLabel jLabel1 = new JLabel();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel7 = new JLabel();
    Border border1;
    JComboBox cbColumns = new JComboBox(numbers(MIN_COLUMNS, MAX_COLUMNS));
    JComboBox cbRows = new JComboBox(numbers(MIN_ROWS, MAX_ROWS));
    JComboBox cbMines = new JComboBox(numbers(MIN_MINES, MIN_MINES));

    public CustomDialog(MineFrame mineFrame) {
        super(mineFrame, "Aknamező módosítása", true);
        this.mineFrame = mineFrame;
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setResizable(false);
        border1 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel1.setLayout(borderLayout1);
        btOk.setText("Rendben");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btOk_actionPerformed(e);
            }
        });
        btCancel.setText("Mégse");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btCancel_actionPerformed(e);
            }
        });
        btCancel.addActionListener(new CustomDialog_btCancel_actionAdapter(this));
        jPanel2.setLayout(gridBagLayout1);
        jLabel1.setPreferredSize(new Dimension(75, 30));
        jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel1.setHorizontalTextPosition(SwingConstants.LEFT);
        jLabel1.setText("Magasság:");
        jPanel3.setLayout(gridBagLayout2);
        jLabel3.setPreferredSize(new Dimension(75, 30));
        jLabel3.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel3.setHorizontalTextPosition(SwingConstants.LEFT);
        jLabel3.setText("Szélesség:");
        jLabel7.setPreferredSize(new Dimension(75, 30));
        jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel7.setHorizontalTextPosition(SwingConstants.LEFT);
        jLabel7.setText("Aknák:");
        jPanel3.setBorder(border1);
        cbRows.setPreferredSize(new Dimension(60, 24));
        cbRows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cbRows_actionPerformed(e);
            }
        });
        cbColumns.setPreferredSize(new Dimension(60, 24));
        cbColumns.setMaximumRowCount(10);
        cbColumns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cbColumns_actionPerformed(e);
            }
        });
        cbMines.setPreferredSize(new Dimension(60, 24));
        cbMines.setMaximumRowCount(10);
        getContentPane().add(panel1);
        panel1.add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(btOk, null);
        jPanel1.add(btCancel, null);
        panel1.add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(jPanel3, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        jPanel3.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 30), 0, 0));
        jPanel3.add(jLabel3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 30), 0, 0));
        jPanel3.add(jLabel7, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 30), 0, 0));
        jPanel3.add(cbColumns, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(cbRows, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(cbMines, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        cbRows.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });

        cbColumns.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });

        cbMines.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });

        btCancel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });

        btOk.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });
    }

    /**
     * Escape-re a dialógus eltűnik.
     */
    private void keyListening(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            hide();
    }

    /**
     * Beállítja a címkék értékét, megjeleníti a dialógust
     */
    public void showDialog() {
        setComboboxes();
        btCancel.requestFocus();
        pack();
        WindowLocation.center(this);
        show();
    }

    /**
     * Beállítja a combobox-ok értékét az adatmodulban tárol adatok alapján
     */
    private void setComboboxes() {
        Level customLevel = dataModule.getCustomLevel();
        cbRows.setSelectedItem(new Integer(customLevel.getRows()));
        cbColumns.setSelectedItem(new Integer(customLevel.getColumns()));
        cbMines.setModel(new DefaultComboBoxModel(
                numbers(MIN_MINES, customLevel.getRows() * customLevel.getColumns() * MAX_RATE / 100)));
        cbMines.setSelectedItem(new Integer(customLevel.getMines()));
    }

    /**
     * Visszaadja a számok sorozatát min-től max-ig
     */
    private Vector numbers(int min, int max) {
        Vector numbers = new Vector();
        for (int i = min; i <= max; i++) {
            numbers.add(new Integer(i));
        }
        return numbers;
    }

    /**
     * Menti a beállított egyéni szintet, új játékot kezd és beállítja a
     * menütételt értékét (aknamező tulajdonságai).
     */
    void btOk_actionPerformed(ActionEvent e) {
        Level customLevel = new Level(
                ((Integer) cbRows.getSelectedItem()).intValue(),
                ((Integer) cbColumns.getSelectedItem()).intValue(),
                ((Integer) cbMines.getSelectedItem()).intValue());
        dataModule.setCustomLevel(customLevel);
        dataModule.setCustom(true);
        hide();
        mineFrame.newGame();
        mineFrame.setCustomMenuItem();
    }

    /**
     * Elrejti a dialógust
     */
    void btCancel_actionPerformed(ActionEvent e) {
        hide();
    }

    /**
     * Új értékekkel tölti fel az aknák választómezőjét, valamint ha több akna
     * volt megadva, mint amennyi elférne az új aknamezőn, akkor az aknák
     * száma az új aknamezőn elhelyezhető maximális aknák számával lesz
     * egyenlő
     */
    private void setCbMines() {
        int rows = ((Integer) cbRows.getSelectedItem()).intValue();
        int columns = ((Integer) cbColumns.getSelectedItem()).intValue();
        int mines = ((Integer) cbMines.getSelectedItem()).intValue();
        cbMines.setModel(new DefaultComboBoxModel(numbers(MIN_MINES, rows * columns * MAX_RATE / 100)));
        if (mines > rows * columns * MAX_RATE / 100) // ha több akna volt megadva, mint amennyi az új aknamezőn elféren
            cbMines.setSelectedItem(new Integer(rows * columns * MAX_RATE / 100));
        else
            cbMines.setSelectedItem(new Integer(mines));
    }

    void cbRows_actionPerformed(ActionEvent e) {
        setCbMines();
    }

    void cbColumns_actionPerformed(ActionEvent e) {
        setCbMines();
    }
}

class CustomDialog_btCancel_actionAdapter implements java.awt.event.ActionListener {
    CustomDialog adaptee;

    CustomDialog_btCancel_actionAdapter(CustomDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btCancel_actionPerformed(e);
    }
}