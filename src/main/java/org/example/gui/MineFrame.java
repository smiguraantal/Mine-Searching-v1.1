package org.example.gui;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.record.Record;
import org.example.gui.dialog.AboutDialog;
import org.example.gui.dialog.BestResultDialog;
import org.example.gui.dialog.CustomDialog;
import org.example.gui.dialog.HowToUseDialog;
import org.example.gui.dialog.NewRecordDialog;
import org.example.gui.panel.DisplayPanel;
import org.example.gui.panel.GamePanel;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

/** Az Aknakereső játék főablaka. */
public class MineFrame extends JFrame implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** Játékterület */
    private GamePanel gamePanel = new GamePanel(this);

    /** A még meg nem jelölt aknák számának kijelzője */
    private DisplayPanel mineDisplay = new DisplayPanel(0);

    /** Az idő kijelzője */
    private DisplayPanel timeDisplay = new DisplayPanel(0);

    /** időmérő */
    private Timer timer = new Timer(0, null);

    /** Egyéni beállítások dialógus */
    private CustomDialog customDialog = new CustomDialog(this);

    /** A legjobb eredményeket megjelenítő dialógus */
    private BestResultDialog bestResultDialog = new BestResultDialog(this);

    /** Új rekord esetén a nevet bekérő dialógus */
    private NewRecordDialog newRecordDialog = new NewRecordDialog(this);

    /** Használat dialógus */
    private HowToUseDialog howToUseDialog = new HowToUseDialog(this);

    /** Névjegy dialógus */
    private AboutDialog aboutDialog = new AboutDialog(this);

    ButtonGroup buttonGroup1 = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();

    JPanel contentPane;
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    BorderLayout borderLayout1 = new BorderLayout();
    Border border1;
    Border border2;
    Border border3;
    Border border4;
    JPanel jPanel1 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    Border border5;
    JPanel pnGame = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    Border border6;
    JPanel jPanel3 = new JPanel();
    Border border7;
    Border border8;
    JPanel jPanel4 = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    Border border9;
    BorderLayout borderLayout5 = new BorderLayout();
    JPanel jPanel5 = new JPanel();
    JPanel jPanel6 = new JPanel();
    JPanel jPanel7 = new JPanel();
    IconButton btNew = new IconButton();
    Border border10;
    JPanel pnMine = new JPanel();
    Border border11;
    Border border12;
    JPanel pnTime = new JPanel();
    BorderLayout borderLayout7 = new BorderLayout();
    Border border13;
    GridLayout gridLayout1 = new GridLayout();
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu mGame = new JMenu();
    JMenu mHelp = new JMenu();
    JMenuItem miNew = new JMenuItem();
    JMenuItem miBestResults = new JMenuItem();
    JMenuItem miExit = new JMenuItem();
    JMenuItem miUse = new JMenuItem();
    JMenuItem miAbout = new JMenuItem();
    JRadioButtonMenuItem miBeginner = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miAdvanced = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miMaster = new JRadioButtonMenuItem();
    JMenu mSettings = new JMenu();
    JCheckBoxMenuItem miSigns = new JCheckBoxMenuItem();
    JRadioButtonMenuItem miWindows = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miMetal = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miMotif = new JRadioButtonMenuItem();
    //VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();


    Border border14;
    //VerticalFlowLayout verticalFlowLayout2 = new VerticalFlowLayout();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JCheckBoxMenuItem miClearNumbers = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miFlash = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miOverFlags = new JCheckBoxMenuItem();
    JRadioButtonMenuItem miCustom = new JRadioButtonMenuItem();

    //Construct the frame
    public MineFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Component initialization
    private void jbInit() throws Exception {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        border14 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        contentPane = (JPanel) this.getContentPane();
        border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border2 = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border3 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        border4 = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), BorderFactory.createEmptyBorder(20, 20, 20, 20));
        border5 = BorderFactory.createEmptyBorder();
        border6 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        border7 = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), BorderFactory.createEmptyBorder(10, 10, 10, 10));
        border8 = BorderFactory.createEmptyBorder(0, 0, 5, 0);
        border9 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        border10 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        border11 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        border12 = BorderFactory.createEmptyBorder();
        border13 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        contentPane.setLayout(gridBagLayout1);
        this.setSize(new Dimension(275, 300));
        this.setTitle("Aknakereső 1.1");
        contentPane.setBorder(border2);
        jPanel1.setLayout(borderLayout2);
        jPanel1.setBorder(border5);
        pnGame.setLayout(borderLayout3);
        pnGame.setBorder(border6);
        jPanel3.setBorder(border8);
        jPanel3.setLayout(borderLayout4);
        jPanel4.setBorder(border9);
        jPanel4.setLayout(borderLayout5);
        btNew.setOpaque(true);
        btNew.setFocusPainted(false);
        btNew.setHorizontalTextPosition(SwingConstants.CENTER);
        btNew.addActionListener(new MineFrame_btNew_actionAdapter(this));
        //jPanel7.setLayout(verticalFlowLayout2);
        pnMine.setBorder(border11);
        pnMine.setLayout(gridLayout1);
        jPanel6.setLayout(borderLayout7);
        jPanel6.setBorder(border12);
        //pnTime.setLayout(verticalFlowLayout1);
        mGame.setText("Játék");
        mHelp.setText("Súgó");
        miNew.setText("Új");
        miNew.addActionListener(new MineFrame_miNew_actionAdapter(this));
        miBestResults.setText("Legjobb idők");
        miBestResults.addActionListener(new MineFrame_miBestResults_actionAdapter(this));
        miExit.setText("Kilépés");
        miExit.addActionListener(new MineFrame_miExit_actionAdapter(this));
        miUse.setText("Használat");
        miUse.addActionListener(new MineFrame_miUse_actionAdapter(this));
        miAbout.setText("Névjegy");
        miAbout.addActionListener(new MineFrame_miAbout_actionAdapter(this));
        miBeginner.setText("Kezdő  9 × 9,  10 akna");
        miBeginner.addActionListener(new MineFrame_miBeginner_actionAdapter(this));
        miAdvanced.setText("Haladó  16 × 16,  40 akna");
        miAdvanced.addActionListener(new MineFrame_miAdvanced_actionAdapter(this));
        miMaster.setText("Mester  16 × 30,  70 akna");
        miMaster.addActionListener(new MineFrame_miMaster_actionAdapter(this));
        jPanel5.setLayout(gridBagLayout2);
        mSettings.setText("Beállítások");
        miSigns.setActionCommand("Kérdőjelek");
        miSigns.setText("Kérdőjelek használata");
        miSigns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miSigns_actionPerformed(e);
            }
        });
        miWindows.setText("Windows");
        miWindows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miWindows_actionPerformed(e);
            }
        });
        miMetal.setText("Metal");
        miMetal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miMetal_actionPerformed(e);
            }
        });
        miMotif.setText("CDE/Motif");
        miMotif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miMotif_actionPerformed(e);
            }
        });

        pnTime.setBorder(null);
        timeDisplay.setBorder(border14);

        jPanel7.setBorder(null);
        miClearNumbers.setText("Számok törlése");
        miClearNumbers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miClearNumbers_actionPerformed(e);
            }
        });
        miFlash.setText("Zászlók villogtatása");
        miFlash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miFlash_actionPerformed(e);
            }
        });
        miOverFlags.setText("Veszély jelzése");
        miOverFlags.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miOverFlags_actionPerformed(e);
            }
        });
        miCustom.setAccelerator(KeyStroke.getKeyStroke('E', KeyEvent.CTRL_MASK, false));
        miCustom.setMnemonic('E');
        miCustom.setText("Egyéni");
        miCustom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miCustom_actionPerformed(e);
            }
        });
        contentPane.add(jPanel1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(pnGame, BorderLayout.CENTER);
        jPanel1.add(jPanel3, BorderLayout.NORTH);
        jPanel3.add(jPanel4, BorderLayout.CENTER);
        jPanel4.add(jPanel5, BorderLayout.CENTER);
        jPanel5.add(btNew, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel4.add(jPanel6, BorderLayout.EAST);
        jPanel6.add(pnTime, BorderLayout.CENTER);
        jPanel4.add(jPanel7, BorderLayout.WEST);
        jPanel7.add(pnMine, null);

        jMenuBar1.add(mGame);
        jMenuBar1.add(mSettings);
        jMenuBar1.add(mHelp);
        mGame.add(miNew);
        mGame.addSeparator();
        mGame.add(miBeginner);
        mGame.add(miAdvanced);
        mGame.add(miMaster);
        mGame.add(miCustom);
        mGame.addSeparator();
        mGame.add(miBestResults);
        mGame.addSeparator();
        mGame.add(miExit);
        mHelp.add(miUse);
        mHelp.add(miAbout);

        // menük
        mGame.setMnemonic(KeyEvent.VK_J);
        mSettings.setMnemonic(KeyEvent.VK_B);
        mHelp.setMnemonic(KeyEvent.VK_S);

        // játék menü tételei
        miNew.setAccelerator(KeyStroke.getKeyStroke("F2"));

        miBeginner.setMnemonic(KeyEvent.VK_K);
        miBeginner.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, Event.CTRL_MASK));

        miAdvanced.setMnemonic(KeyEvent.VK_H);
        miAdvanced.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));

        miMaster.setMnemonic(KeyEvent.VK_M);
        miMaster.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.CTRL_MASK));

        miBestResults.setMnemonic(KeyEvent.VK_L);
        miBestResults.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));

        miExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, Event.ALT_MASK));

        // beállítások menü tételei
        miSigns.setMnemonic(KeyEvent.VK_K);
        miSigns.setAccelerator(KeyStroke.getKeyStroke('K', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));

        miClearNumbers.setMnemonic('S');
        miClearNumbers.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));

        miFlash.setMnemonic('Z');
        miFlash.setAccelerator(KeyStroke.getKeyStroke('Z', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));

        miOverFlags.setMnemonic('V');
        miOverFlags.setAccelerator(KeyStroke.getKeyStroke('V', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));

        miWindows.setMnemonic(KeyEvent.VK_W);
        miWindows.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, Event.CTRL_MASK + Event.ALT_MASK));

        miMetal.setMnemonic(KeyEvent.VK_M);
        miMetal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.CTRL_MASK + Event.ALT_MASK));

        miMotif.setMnemonic(KeyEvent.VK_C);
        miMotif.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK + Event.ALT_MASK));

        // súgó menü tételei
        miAbout.setMnemonic(KeyEvent.VK_N);
        miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));

        miUse.setAccelerator(KeyStroke.getKeyStroke("F1"));

        setJMenuBar(jMenuBar1);

        buttonGroup1.add(miBeginner);
        buttonGroup1.add(miAdvanced);
        buttonGroup1.add(miMaster);
        buttonGroup1.add(miCustom);

        buttonGroup2.add(miWindows);
        buttonGroup2.add(miMetal);
        buttonGroup2.add(miMotif);

        pnGame.add(gamePanel);

        dataModule.setUnmarkedMines(dataModule.getLevel().getMines());
        pnMine.add(mineDisplay = new DisplayPanel(dataModule.getUnmarkedMines()));
        pnTime.add(timeDisplay);
        mSettings.add(miSigns);
        mSettings.add(miClearNumbers);
        mSettings.add(miOverFlags);
        mSettings.add(miFlash);
        mSettings.addSeparator();
        mSettings.add(miWindows);
        mSettings.add(miMetal);
        mSettings.add(miMotif);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });

        setMenuItems();
        setCustomMenuItem();
        resize_btNew();
        btNew.drawIcon(actualIcon());
        createTimer();
    }

    /** A menütélre írja az egyéni beállításokat */
    public void setCustomMenuItem() {
        miCustom.setText("Egyéni  " +
                dataModule.getCustomLevel().getRows() +
                " × " +
                dataModule.getCustomLevel().getColumns() +
                ",  " +
                dataModule.getCustomLevel().getMines() +
                " akna");
    }

    /** A kinézettől függően határozza meg az "Új játék" gomb ajánlott méretét.
     * A Motif kinézet lényegesen nagyobb gombokat definiál, ezért a rendel-
     * kezésre álló helyen a gomb "összerogyna". */
    private void resize_btNew() {
        if (dataModule.getLookAndFeel() == WINDOWS_LOOK_AND_FEEL)
            btNew.setPreferredSize(new Dimension(26, 26));
        if (dataModule.getLookAndFeel() == METAL_LOOK_AND_FEEL)
            btNew.setPreferredSize(new Dimension(25, 25));
        if (dataModule.getLookAndFeel() == MOTIF_LOOK_AND_FEEL)
            btNew.setPreferredSize(new Dimension(37, 37));
    }

    /** Elrontott játék */
    public void failed() {
        stopTimer();
        btNew.drawIcon(SAD_ICON);
        dataModule.setPlayState(STOP);
    }

    /** Sikerült megtalálni mindegyik aknát */
    public void success() {
        stopTimer();
        btNew.drawIcon(SUCCESS_ICON);
        dataModule.setUnmarkedMines(0);
        refreshMineDisplay();
        dataModule.setPlayState(STOP);
        if (!dataModule.isCustom()) { // ha nem egyéni szinten ment a játék
            if (dataModule.newRecord()) {
                GregorianCalendar date = new GregorianCalendar();
                String name = newRecordDialog.showDialog();
                dataModule.addRecord(new Record(name, dataModule.getTime(), date));

            }
        }
    }

    /** Frissíti az aknaszámkijelzőt */
    public void refreshMineDisplay() {
        mineDisplay.setValue(dataModule.getUnmarkedMines());
    }

    /** Beállítja a menütételek kijelöltségét. */
    private void setMenuItems() {
        // szintek
        if (!dataModule.isCustom()) {
            if (dataModule.getLevel().equals(BEGINNER)) {
                miBeginner.setSelected(true);
            } else if (dataModule.getLevel().equals(ADVANCED)) {
                miAdvanced.setSelected(true);
            } else {
                miMaster.setSelected(true);
            }
        } else {
            miCustom.setSelected(true);
        }
        // kérdőjelek
        if (dataModule.isSigns()) {
            miSigns.setSelected(true);
        }
        // számok törlése
        if (dataModule.isNumbers()) {
            miClearNumbers.setSelected(true);
        }
        // veszély jelzése
        if (dataModule.isOverFlags())
            miOverFlags.setSelected(true);
        // zászlók villogtatása
        if (dataModule.isFlash()) {
            miFlash.setSelected(true);
        }
        // kinézet
        if (dataModule.getLookAndFeel() == WINDOWS_LOOK_AND_FEEL) {
            miWindows.setSelected(true);
        } else if (dataModule.getLookAndFeel() == METAL_LOOK_AND_FEEL) {
            miMetal.setSelected(true);
        } else {
            miMotif.setSelected(true);
        }
    }

    /** Új játék */
    public void newGame() {
        gamePanel.stopFlash();
        stopTimer();
        dataModule.setTime(0);
        createTimer();
        btNew.drawIcon(SMILING_ICON);

        dataModule.setUnmarkedMines(dataModule.getLevel().getMines());
        mineDisplay.setValue(dataModule.getUnmarkedMines());
        timeDisplay.setValue(0);

        pnGame.removeAll();
        pnGame.add(gamePanel = new GamePanel(this));
        pack();
    }

    /** Létrehozza az órát */
    public void createTimer() {
        timer = (new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataModule.increaseTime();
                timeDisplay.setValue(dataModule.getTime());
            }
        }));
    }

    /** leállítja az órát */
    public void stopTimer() {
        timer.stop();
        dataModule.setPlayState(STOP);
    }

    /** elindítja az órát, ha még nincs elindítva */
    public void startTimer() {
        if (!timer.isRunning()) {
            timer.start();
            dataModule.setPlayState(PLAY);
        }
    }

    /** Megjeleníti a kapott üzenetet */
    public void showMessage(String message) {
        MessageManager.showInfoDialog(this, message);
    }

    /** Visszaadja, hogy az "Új játék" gombon milyen legyen az ikon */
    private int actualIcon() {
        int icon = -1;
        if (timer.isRunning()) { // ha megy az idő
            icon = SMILING_ICON;
        } else { // ha nem megy az idő
            if (gamePanel.isBlownUpMine()) { // ha van felrobbant akna
                icon = SAD_ICON;
            } else { // ha nincs felrobbant akna
                if (dataModule.getUnmarkedMines() == 0) { // ha megvan az összes akna, vagyis sikerült
                    icon = SUCCESS_ICON;
                } else { // ha még mutat valamennyi aknát az aknaszámláló, vagyis nem kezdődött el a játék
                    icon = SMILING_ICON;
                }
            }
        }
        return icon;
    }

    /** Ha a kapott kinézet eltér az aktuális kinézettől, akkor az
     * alkalmazás összes komponense új megjelenítést kap. */
    private void changeLookAndFeel(int lookAndFeel) {
        int actualLookAndFeel = dataModule.getLookAndFeel();
        if (actualLookAndFeel != lookAndFeel) {
            try {
                if (lookAndFeel == WINDOWS_LOOK_AND_FEEL)
                    UIManager.setLookAndFeel(new WindowsLookAndFeel());
                if (lookAndFeel == METAL_LOOK_AND_FEEL)
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                if (lookAndFeel == MOTIF_LOOK_AND_FEEL)
                    UIManager.setLookAndFeel(new MotifLookAndFeel());
                // a dialógusok frissítése
                SwingUtilities.updateComponentTreeUI(getRootPane());
                SwingUtilities.updateComponentTreeUI(bestResultDialog.getRootPane());
                SwingUtilities.updateComponentTreeUI(customDialog.getRootPane());
                SwingUtilities.updateComponentTreeUI(newRecordDialog.getRootPane());
                SwingUtilities.updateComponentTreeUI(howToUseDialog.getRootPane());
                howToUseDialog.refreshTree(); // a fa ikonjai nem frissülnek maguktók
                SwingUtilities.updateComponentTreeUI(aboutDialog.getRootPane());

                dataModule.setLookAndFeel(lookAndFeel); // az új kinézet elmentése
                btNew.drawIcon(actualIcon()); // új kinézethez az ikont lehet, hogy máshova kell rajzolni (a motif gomb lényegesen nagyobb helyet igényel)
                getRootPane().revalidate();
                getRootPane().repaint();
                pack();

            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void exit() {
        if (MessageManager.showConfirmDialog(this, "Biztosan kilép?"))
            System.exit(0);
    }

    // ------------------ Eseménykezelők -----------------

    /** Új gomb lenyomása */
    void btNew_actionPerformed(ActionEvent e) {
        newGame();
    }

    /** Kezdő szintű játék kiválasztása */
    void miBeginner_actionPerformed(ActionEvent e) {
        dataModule.setLevel(BEGINNER);
        dataModule.setCustom(false);
        newGame();
    }

    /** Haladó szintű játék kiválasztása */
    void miAdvanced_actionPerformed(ActionEvent e) {
        dataModule.setLevel(ADVANCED);
        dataModule.setCustom(false);
        newGame();
    }

    /** Mester szintű játék kiválasztása */
    void miMaster_actionPerformed(ActionEvent e) {
        dataModule.setLevel(MASTER);
        dataModule.setCustom(false);
        newGame();
    }

    /** Egyéni beállítások kiválasztása */
    void miCustom_actionPerformed(ActionEvent e) {
        dataModule.setCustom(true);
        newGame();
        customDialog.showDialog();
    }

    /** Rekordok megtekintése */
    void miBestResults_actionPerformed(ActionEvent e) {
        bestResultDialog.showDialog();
    }

    /** Kilépés */
    void miExit_actionPerformed(ActionEvent e) {
        exit();
    }

    /** Használat dialógus hívása */
    void miUse_actionPerformed(ActionEvent e) {
        howToUseDialog.showDialog();
    }

    /** Névjegy dialógus */
    void miAbout_actionPerformed(ActionEvent e) {
        aboutDialog.showDialog();
    }

    /** Kérdőjelek engedélyezésének beállítása */
    void miSigns_actionPerformed(ActionEvent e) {
        dataModule.changeSigns();
        if (!dataModule.isSigns())
            gamePanel.removeSigns();
    }

    /** Számok törlésének engedélyezése */
    void miClearNumbers_actionPerformed(ActionEvent e) {
        dataModule.changeNumbers();
        gamePanel.changeNumbers();
    }

    /** Veszély jelzésének engedélyezése */
    void miOverFlags_actionPerformed(ActionEvent e) {
        dataModule.changeOverFlags();
        gamePanel.changeOverFlags();
    }

    /** Zászlók villogtatásának egedélyezése */
    void miFlash_actionPerformed(ActionEvent e) {
        dataModule.changeFlash();
    }

    /** Windows-os kinézet beállítása */
    void miWindows_actionPerformed(ActionEvent e) {
        btNew.setPreferredSize(new Dimension(26, 26));
        changeLookAndFeel(WINDOWS_LOOK_AND_FEEL);
    }

    /** Metal-os kinézet beállítása */
    void miMetal_actionPerformed(ActionEvent e) {
        btNew.setPreferredSize(new Dimension(25, 25));
        changeLookAndFeel(METAL_LOOK_AND_FEEL);
    }

    /** Motif-os kinézet beállítása */
    void miMotif_actionPerformed(ActionEvent e) {
        btNew.setPreferredSize(new Dimension(37, 37));
        changeLookAndFeel(MOTIF_LOOK_AND_FEEL);
    }

    /** Új játék kérése */
    void miNew_actionPerformed(ActionEvent e) {
        newGame();
    }
}

class MineFrame_btNew_actionAdapter implements ActionListener {
    MineFrame adaptee;

    MineFrame_btNew_actionAdapter(MineFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btNew_actionPerformed(e);
    }
}

class MineFrame_miBeginner_actionAdapter implements ActionListener {
    MineFrame adaptee;

    MineFrame_miBeginner_actionAdapter(MineFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBeginner_actionPerformed(e);
    }
}

class MineFrame_miAdvanced_actionAdapter implements ActionListener {
    MineFrame adaptee;

    MineFrame_miAdvanced_actionAdapter(MineFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miAdvanced_actionPerformed(e);
    }
}

class MineFrame_miMaster_actionAdapter implements ActionListener {
    MineFrame adaptee;

    MineFrame_miMaster_actionAdapter(MineFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miMaster_actionPerformed(e);
    }
}

class MineFrame_miBestResults_actionAdapter implements ActionListener {
    MineFrame adaptee;

    MineFrame_miBestResults_actionAdapter(MineFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBestResults_actionPerformed(e);
    }
}

class MineFrame_miExit_actionAdapter implements ActionListener {
    MineFrame adaptee;

    MineFrame_miExit_actionAdapter(MineFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miExit_actionPerformed(e);
    }
}

class MineFrame_miUse_actionAdapter implements ActionListener {
    MineFrame adaptee;

    MineFrame_miUse_actionAdapter(MineFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miUse_actionPerformed(e);
    }
}

class MineFrame_miAbout_actionAdapter implements ActionListener {
    MineFrame adaptee;

    MineFrame_miAbout_actionAdapter(MineFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miAbout_actionPerformed(e);
    }
}

class MineFrame_miNew_actionAdapter implements ActionListener {
    MineFrame adaptee;

    MineFrame_miNew_actionAdapter(MineFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miNew_actionPerformed(e);
    }
}