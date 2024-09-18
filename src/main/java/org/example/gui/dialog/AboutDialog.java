package org.example.gui.dialog;

import com.borland.jbcl.layout.VerticalFlowLayout;
import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;
import org.example.gui.MineFrame;
import org.example.gui.WindowLocation;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
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


/**
 * A programról néhány információt megjelenítő dialógus.
 */
public class AboutDialog extends JDialog {

    /**
     * A megjelenő szöveg betűtípusa
     */
    private Font font = new Font("Times New Roman", Font.PLAIN, 15);

    /**
     * Időzítő a vonalak animálásához
     */
    private Timer lineTimer = new Timer(0, null);

    /**
     * Időzítő az információ animálásához
     */
    private Timer infoTimer = new Timer(0, null);

    /**
     * A megjelenítendő sor száma
     */
    private int infoRow;

    /**
     * A kiírandó információk
     */
    private String gameName = "Aknakereső";
    private String version = "Verziószám: 1.1";
    private String copyright = "Copyright © Smigura Antal";
    private String date = "Budapest, 2004";

    Border border1;
    Border border2;
    Border border3;
    Border border4;
    Border border5;
    Border border6;
    Border border7;
    Border border8;
    JPanel jPanel1 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel6 = new JPanel();
    JPanel jPanel7 = new JPanel();
    VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
    JPanel jPanel8 = new JPanel();
    JLabel lbGameName = new JLabel();
    JPanel jPanel10 = new JPanel();
    JLabel lbCopyright = new JLabel();
    JPanel jPanel11 = new JPanel();
    JLabel lbDate = new JLabel();
    XYLayout xYLayout1 = new XYLayout();
    JPanel line04 = new JPanel();
    Border border9;
    JPanel line05 = new JPanel();
    Border border10;
    JPanel line06 = new JPanel();
    Border border11;
    JPanel line01 = new JPanel();
    Border border12;
    JPanel line02 = new JPanel();
    Border border13;
    JPanel line03 = new JPanel();
    Border border14;
    XYLayout xYLayout2 = new XYLayout();
    JPanel line07 = new JPanel();
    Border border15;
    JPanel line08 = new JPanel();
    Border border16;
    JPanel line09 = new JPanel();
    Border border17;
    JPanel line10 = new JPanel();
    Border border18;
    JPanel line11 = new JPanel();
    Border border19;
    JPanel line12 = new JPanel();
    Border border20;
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JButton btClose = new JButton();
    JPanel jPanel21 = new JPanel();
    JLabel lbVersion = new JLabel();
    Border border21;
    Border border22;
    Border border23;

    /**
     * Konstruktor.
     */
    public AboutDialog(MineFrame mineFrame) {
        super(mineFrame, "Névjegy", true);

        try {
            this.jbInit();
            this.pack();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    /**
     * Felépíti a dialógust.
     */
    private void jbInit() throws Exception {
        this.border21 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(5, 15, 5, 15));
        this.border22 = BorderFactory.createEmptyBorder(0, 0, 5, 0);
        this.border23 = BorderFactory.createEmptyBorder();
        this.setDefaultCloseOperation(0);
        this.setResizable(false);
        this.border1 = BorderFactory.createBevelBorder(0);
        this.border2 = BorderFactory.createBevelBorder(0);
        this.border3 = BorderFactory.createBevelBorder(0);
        this.border4 = BorderFactory.createBevelBorder(0);
        this.border5 = BorderFactory.createBevelBorder(0);
        this.border6 = BorderFactory.createBevelBorder(0);
        this.border7 = BorderFactory.createBevelBorder(0);
        this.border8 = BorderFactory.createBevelBorder(0);
        this.border9 = BorderFactory.createBevelBorder(0);
        this.border10 = BorderFactory.createBevelBorder(0);
        this.border11 = BorderFactory.createBevelBorder(0);
        this.border12 = BorderFactory.createBevelBorder(0);
        this.border13 = BorderFactory.createBevelBorder(0);
        this.border14 = BorderFactory.createBevelBorder(0);
        this.border15 = BorderFactory.createBevelBorder(0);
        this.border16 = BorderFactory.createBevelBorder(0);
        this.border17 = BorderFactory.createBevelBorder(0);
        this.border18 = BorderFactory.createBevelBorder(0);
        this.border19 = BorderFactory.createBevelBorder(0);
        this.border20 = BorderFactory.createBevelBorder(0);
        this.jPanel1.setLayout(this.gridBagLayout1);
        this.jPanel2.setLayout(this.borderLayout1);
        this.jPanel4.setLayout(this.borderLayout2);
        this.jPanel7.setLayout(this.verticalFlowLayout1);
        this.lbGameName.setFont(new Font("Serif", 0, 18));
        this.lbGameName.setForeground(Color.darkGray);
        this.lbGameName.setBorder(this.border22);
        this.lbCopyright.setFont(this.font);
        this.lbDate.setFont(this.font);
        this.lbDate.setBorder(this.border23);
        this.lbVersion.setFont(this.font);
        this.lbGameName.setText(this.gameName);
        this.lbVersion.setText(this.version);
        this.lbCopyright.setText(this.copyright);
        this.lbDate.setText(this.date);
        this.jPanel5.setLayout(this.xYLayout1);
        this.jPanel5.setPreferredSize(new Dimension(200, 25));
        this.line04.setBorder(this.border9);
        this.line04.setPreferredSize(new Dimension(3, 0));
        this.line05.setBorder(this.border10);
        this.line05.setPreferredSize(new Dimension(3, 0));
        this.line06.setBorder(this.border11);
        this.line06.setPreferredSize(new Dimension(3, 0));
        this.line01.setBorder(this.border12);
        this.line01.setPreferredSize(new Dimension(0, 3));
        this.line02.setBorder(this.border13);
        this.line02.setPreferredSize(new Dimension(0, 3));
        this.line03.setBorder(this.border14);
        this.line03.setPreferredSize(new Dimension(0, 3));
        this.jPanel6.setLayout(this.xYLayout2);
        this.jPanel6.setMinimumSize(new Dimension(200, 39));
        this.jPanel6.setPreferredSize(new Dimension(200, 25));
        this.line07.setBorder(this.border15);
        this.line07.setOpaque(false);
        this.line07.setPreferredSize(new Dimension(0, 3));
        this.line08.setBorder(this.border16);
        this.line08.setPreferredSize(new Dimension(0, 3));
        this.line09.setBorder(this.border17);
        this.line09.setPreferredSize(new Dimension(0, 3));
        this.line10.setBorder(this.border18);
        this.line10.setPreferredSize(new Dimension(3, 0));
        this.line11.setBorder(this.border19);
        this.line11.setPreferredSize(new Dimension(3, 0));
        this.line12.setBorder(this.border20);
        this.line12.setPreferredSize(new Dimension(3, 0));
        this.jPanel3.setLayout(this.gridBagLayout2);
        this.btClose.setText("Bezárás");
        this.btClose.addActionListener(new About_btClose_actionAdapter(this));
        this.jPanel7.setPreferredSize(new Dimension(200, 148));
        this.jPanel10.setMinimumSize(new Dimension(200, 28));
        this.jPanel4.setPreferredSize(new Dimension(200, 198));
        this.getContentPane().add(this.jPanel1, "Center");
        this.jPanel1.add(this.jPanel2, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, 10, 1, new Insets(10, 5, 0, 5), 0, 0));
        this.jPanel2.add(this.jPanel3, "South");
        this.jPanel3.add(this.btClose, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 10, 0, new Insets(10, 0, 5, 0), 0, 0));
        this.jPanel2.add(this.jPanel4, "Center");
        this.jPanel4.add(this.jPanel5, "North");
        this.jPanel5.add(this.line01, new XYConstraints(0, 3, -1, -1));
        this.jPanel5.add(this.line02, new XYConstraints(0, 8, -1, -1));
        this.jPanel5.add(this.line03, new XYConstraints(0, 13, -1, -1));
        this.jPanel5.add(this.line04, new XYConstraints(3, 0, -1, -1));
        this.jPanel5.add(this.line05, new XYConstraints(8, 0, -1, -1));
        this.jPanel5.add(this.line06, new XYConstraints(13, 0, -1, -1));
        this.jPanel4.add(this.jPanel6, "South");
        this.jPanel6.add(this.line07, new XYConstraints(200, 19, -1, -1));
        this.jPanel6.add(this.line08, new XYConstraints(200, 14, -1, -1));
        this.jPanel6.add(this.line09, new XYConstraints(200, 9, -1, -1));
        this.jPanel6.add(this.line10, new XYConstraints(194, 25, -1, -1));
        this.jPanel6.add(this.line11, new XYConstraints(189, 25, -1, -1));
        this.jPanel6.add(this.line12, new XYConstraints(184, 25, -1, -1));
        this.jPanel4.add(this.jPanel7, "Center");
        this.jPanel7.add(this.jPanel8, (Object)null);
        this.jPanel8.add(this.lbGameName, (Object)null);
        this.jPanel7.add(this.jPanel21, (Object)null);
        this.jPanel21.add(this.lbVersion, (Object)null);
        this.jPanel7.add(this.jPanel10, (Object)null);
        this.jPanel10.add(this.lbCopyright, (Object)null);
        this.jPanel7.add(this.jPanel11, (Object)null);
        this.jPanel11.add(this.lbDate, (Object)null);

        btClose.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                keyListening(e);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                lineTimer.stop();
                infoTimer.stop();
                hide();
            }
        });
    }

    /**
     * Escape-re a dialógus eltűnik.
     */
    private void keyListening(KeyEvent e) {
        if (e.getKeyCode() == 27) {
            this.lineTimer.stop();
        }

        this.infoTimer.stop();
        this.hide();
    }

    /**
     * Beállítja a vonalak rajzolásához használt időzítőt
     */
    private void initLineTimer() {
        lineTimer = (new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawLines();
            }
        }));
        this.lineTimer.setInitialDelay(500);
        this.lineTimer.start();
    }

    /**
     * Meghúzza a vonalakat
     */
    private void drawLines() {
        if (this.line01.getWidth() < 200) {
            this.line01.setSize(new Dimension(this.line01.getWidth() + 1, this.line01.getHeight()));
        }

        if (this.line02.getWidth() < 150) {
            this.line02.setSize(new Dimension(this.line02.getWidth() + 1, this.line02.getHeight()));
        }

        if (this.line03.getWidth() < 100) {
            this.line03.setSize(new Dimension(this.line03.getWidth() + 1, this.line03.getHeight()));
        }

        if (this.line04.getHeight() < 25) {
            this.line04.setSize(new Dimension(this.line04.getWidth(), this.line04.getHeight() + 1));
        }

        if (this.line05.getHeight() < 22) {
            this.line05.setSize(new Dimension(this.line05.getWidth(), this.line05.getHeight() + 1));
        }

        if (this.line06.getHeight() < 19) {
            this.line06.setSize(new Dimension(this.line06.getWidth(), this.line06.getHeight() + 1));
        }

        if (this.line07.getWidth() < 200) {
            this.line07.setSize(new Dimension(this.line07.getWidth() + 1, this.line07.getHeight()));
            this.line07.setLocation(this.line07.getX() - 1, this.line07.getY());
        }

        if (this.line08.getWidth() < 150) {
            this.line08.setSize(new Dimension(this.line08.getWidth() + 1, this.line08.getHeight()));
            this.line08.setLocation(this.line08.getX() - 1, this.line08.getY());
        }

        if (this.line09.getWidth() < 100) {
            this.line09.setSize(new Dimension(this.line09.getWidth() + 1, this.line09.getHeight()));
            this.line09.setLocation(this.line09.getX() - 1, this.line09.getY());
        }

        if (this.line10.getHeight() < 25) {
            this.line10.setSize(new Dimension(this.line10.getWidth(), this.line10.getHeight() + 1));
            this.line10.setLocation(this.line10.getX(), this.line10.getY() - 1);
        }

        if (this.line11.getHeight() < 22) {
            this.line11.setSize(new Dimension(this.line11.getWidth(), this.line11.getHeight() + 1));
            this.line11.setLocation(this.line11.getX(), this.line11.getY() - 1);
        }

        if (this.line12.getHeight() < 19) {
            this.line12.setSize(new Dimension(this.line12.getWidth(), this.line12.getHeight() + 1));
            this.line12.setLocation(this.line12.getX(), this.line12.getY() - 1);
        }

        if (this.line01.getWidth() == 200) {
            this.lineTimer.stop();
            this.initInfoTimer();
        }

    }

    /**
     * Beállítja az info kiírásához használt időzítőt
     */
    private void initInfoTimer() {
        this.infoRow = 0;
        infoTimer = (new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (infoRow == 0) {
                    lbGameName.setForeground(Color.darkGray);
                }
                if (infoRow == 1) {
                    lbVersion.setForeground(Color.black);
                }
                if (infoRow == 2) {
                    lbCopyright.setForeground(Color.black);
                }
                if (infoRow == 3) {
                    lbDate.setForeground(Color.black);
                    infoTimer.stop();
                }
                ++infoRow;
            }
        }));
        this.infoTimer.start();
    }

    /**
     * Megjeleníti a dialógust.
     */
    public void showDialog() {
        this.pack();
        WindowLocation.center(this);
        this.hideInformation();
        this.infoTimer.stop();
        this.lineTimer.stop();
        this.initLineTimer();
        this.show();
    }

    /**
     * Elrejti a szöveget
     */
    private void hideInformation() {
        Color panelBackground = (Color)UIManager.get("Panel.background");
        this.lbGameName.setForeground(panelBackground);
        this.lbVersion.setForeground(panelBackground);
        this.lbCopyright.setForeground(panelBackground);
        this.lbDate.setForeground(panelBackground);
    }

    /**
     * Elrejti a dialógust.
     */
    void btClose_actionPerformed(ActionEvent e) {
        this.lineTimer.stop();
        this.infoTimer.stop();
        this.hide();
    }
}

class About_btClose_actionAdapter implements ActionListener {
    AboutDialog adaptee;

    About_btClose_actionAdapter(AboutDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btClose_actionPerformed(e);
    }
}