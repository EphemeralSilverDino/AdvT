// You must KEEP a few methods as commented below.
// Otherwise, add methods to implement a GUI version of TicTacToe
/*
 This class is responsible for:
    - drawing the TicTacToe board.
    - receiving user clicks and interaction (user events)
    - forwarding all user events appropriately

 All user interactions should be abstracted and forwarded to TicTacToe classes.
*/
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import characters.Player;
import debug.DebugWriter;
import main.MainFrame;

import javax.swing.JOptionPane;
import java.util.*;
import java.awt.Polygon;
public class GamePanel extends JPanel {
  Dungeon D = new Dungeon();
  static Animations ani = new Animations("src/images/MidSlimeIdle.png",6,6);
  private static Player player = new Player(ani,100,100);
  StatBars bars = new StatBars(0,500);
  Polygon floor;
  //never sets the size of itself(the pannel) within the class
  //note just incase there are visual bugs
  public static Player getPlayer(){
    return player;
  }
  
  public GamePanel(){
    createEventHandlers();
    setUpDungeon();
    Room r = D.getMainRoom();
    floor = new Polygon( new int[]{192,0,r.getWidth(),r.getWidth()-192},new int[] {145,r.getHeight(),r.getHeight(),145},4);
  }
    
  
  public void setUpDungeon(){
    D.populateRooms(0);
    DebugWriter.write("dungeon rooms set up");
    D.setDoorRender();
    DebugWriter.write(""+D.getMainRoom().toString());
  }
  //testing
  
  public void representDungeon(Room r, Graphics g,int x,int y){
    g.setColor(Color.red);
    Room[][] map = D.getDungeonMap();
    for (int row=0;row<map.length;row++){
      for (int col=0;col<map[0].length;col++){
        if (map[row][col]!=null)
          g.fillRect(25*row,25*col,25,25);
        if (row==map.length/2 && col==map.length/2){
          g.setColor(Color.black);
          g.fillRect(25*row,25*col,25,25);
          g.setColor(Color.red);
        }
      }
    }
  }
  
  public void update(){
    D.update();
    for (Door d: D.getDoors()){
      if (d.collidesWith(player) && d.getRender()){
        D.move(D.getCurrentRoom(),d.getDirection()); 
        player.teleport(300,300);
        D.setDoorRender();
      }
    }
  }
  public void paintComponent(Graphics g){
    try{
    Thread.sleep(85); 
    }
    catch(Exception e){
      
    };
    update();
    super.paintComponent(g);
    this.setBackground(Color.WHITE);
    g.clearRect(0, 0, this.getWidth(), this.getHeight());		
    D.draw(g);
    player.draw(g);
    representDungeon(D.getMainRoom(),g,200,200);
    bars.draw(g);
    //g.fillPolygon(floor);
    repaint();
  }
  public void updateAnimation(){
  } 
  /**
   * This allows this dialog to be drawn at a good size.
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(MainFrame.WIDTH, MainFrame.HEIGHT);
  }
  private void createEventHandlers() {
    this.addKeyListener(new KeyAdapter(){
      @Override
      public void keyPressed(KeyEvent e){
        onKeyPress(e);
      }
      public void keyReleased(KeyEvent e){
        onKeyReleased(e);
      }
      });
    // System.out.println("key listener added");
         this.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e) {
             onMouseClicked(e);
      }
    });
  }
  
  public void onMouseClicked(MouseEvent e) {
    //System.out.println(difficulty);
    System.out.println("I'm a little clicker");
  }
  
  public void onKeyPress(KeyEvent e){
    char key = e.getKeyChar();
    player.processKeyInput(key);
    //System.out.println("Im pressing keys");
  }
  // for movement, move while key is pressed down
  // setting a boolean to true , while true or use Strings
  // move in that direction 
  // 
  public void onKeyReleased(KeyEvent e){
    player.processKeyRelease(e.getKeyChar());
  }
  /**
   * Set up all the event handlers for our components.
   */
}
