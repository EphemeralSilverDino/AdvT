import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;

public void RenderStats{
  
  BufferedImage hpBar = null;
  BufferedImage manaBar = null;
  int x = 0;
  int y = 0;
  
  public void Renderstats(int x, int y){
    this.x=x;
    this.y=y;
    try{
      //hpBar= ImageIO.read(new File(""));
      //manaBar = ImageIO.read(new File(""));
    }  
    catch(Exception e){
    }   
  }
  public void draw(Graphics g){
    g.drawImage(hpBar,x,y,null); //50
    g.fillRect(x,y);
    g.drawImage((manaBar,x,y+60,null);
  }
}
