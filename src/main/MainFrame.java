// DO NOT CHANGE
/*
 * There are only two things the student will change in this file.
 * These will be changed only when starting on TicTacToe.
 *
 * 1) private Node getTreeToDisplay() { ... }
 * 2) The imports to allow proper creation of the TicTacToe Tree.
 */
package main;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import game.GamePanel;
import ui.MainMenu;

import java.util.*;
import java.awt.event.*;
public class MainFrame extends JFrame{

  public static final int WIDTH = 960;
  public static final int HEIGHT = 720;

  private static final int TREE = 0;
  private static final int GAME = 1;

  private JScrollPane scroll = null;
  private GamePanel gamePanel;
  private static JPanel[] panels;
  static int currentPanel = 1;
  
  public static void changePanel(int panel){
    currentPanel = panel;
  }
  public static void startGUI() throws InterruptedException {
    final MainFrame theGUI = new MainFrame();
    SwingUtilities.invokeLater( new Runnable() {
		public void run() {
			theGUI.createFrame(theGUI);
		}
	} );
    synchronized (theGUI ) {
      theGUI.wait();
    }
    while(true){    
    }
  }
  public void createFrame(Object semaphore) {
    // Sets the title found in the Title Bar of the JFrame
    this.setTitle("Game");
    // Sets the size of the main Window
    this.setSize(WIDTH, HEIGHT);
    // Allows the application to properly close when the
    // user clicks on the Red-X.
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addMenuBar();
    panels = new JPanel[2];
    gamePanel = new GamePanel();
    MainMenu menuPanel = new MainMenu("src/images/MainScreen.png",0,0);
    setUpPanel(gamePanel);
    setUpPanel(menuPanel);
    panels[0] = gamePanel;
    panels[1] = menuPanel;
    addPanels();
    toggleCurrentPanel(true);
    this.setVisible(true);
    synchronized (semaphore) {
      semaphore.notify();
    }
  }
  public void setUpPanel(JPanel p){
    p.setSize(WIDTH, HEIGHT);
    p.setBounds(0,0,WIDTH,HEIGHT);
    p.setVisible(false);
  }
  public static void toggleCurrentPanel(boolean b){
    panels[currentPanel].setVisible(b);
    panels[currentPanel].setFocusable(b);
  }
  
  public static void setPage(int page){
    toggleCurrentPanel(false);
    currentPanel = page;
    toggleCurrentPanel(true);
panels[currentPanel].requestFocusInWindow();
  }
  public void addPanels() {
    for (JPanel panel: panels) {
      this.add(panel);
    }
  }
  private void addMenuBar() {
    JMenuBar bar = new JMenuBar();
    this.setJMenuBar(bar);
    JMenu menu = new JMenu("View");
    menu.setMnemonic('V');
        bar.add(menu);
  }
}
