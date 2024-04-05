import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.*;
import java.awt.*;

public class MainMenu extends JPanel{
  private int x;
  private int y;
  private BufferedImage background = null;
  ArrayList<Button> buttons = new ArrayList<Button>();
  int width;
  int height;
  public MainMenu(String url,int x,int y){
    this.x=x;
    this.y=y;
    try {
      BufferedImage icon = ImageIO.read(new File(url));
      width = icon.getWidth();
      height = icon.getHeight();
      background = icon;
      createEventHandlers();
      addButtons();
    }
    catch (IOException e){
    } 
  }
  public void addButtons(){
    buttons.add(new SendButton("src/GUI/Images/StartButton.png",200,200,0));
  }

  public void draw(Graphics g){
    g.drawImage(background,x,y,null);
    
    for (Button b : buttons){
      b.draw(g);
    }
    
  }
  
  private void createEventHandlers() {
    this.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseClicked(MouseEvent e) {
        onMouseClicked(e);
           }
         });
      }
  public void onMouseClicked(MouseEvent e){
    System.out.print("computing click");
    for (Button b: buttons){
      b.doTask(e);
    }
  }
  
  public void paintComponent(Graphics g){
    try{
    Thread.sleep(85); 
    }
    catch(Exception e){};
    super.paintComponent(g);
    this.setBackground(Color.WHITE);
    g.clearRect(0, 0, this.getWidth(), this.getHeight());		
    // draw the Game board hash marks and X's and O's
    // for now, just draw some text
    draw(g);
    repaint();
  }
  
}