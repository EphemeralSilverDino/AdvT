import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.Image;
public class RenderedEntity{
  int x;
  int y;
  int orginalWidth;
  int orginalHeight;
  BufferedImage image; 

  public RenderedEntity(String imageUrl, int x, int y){
    this.x=x;
    this.y=y;
    try{
      image = ImageIO.read(new File(imageUrl));
      orginalWidth = getWidth();
      orginalHeight = getHeight();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public int getX(){
    return x;
  }
  
  public int getY(){
    return y;
  }
  
  public int getHeight(){
    return image.getHeight();
  }
  
  public int getWidth(){
    return image.getWidth();
  }
  
  public void draw(Graphics g){
    g.drawImage(image,x,y,null);
  }
  
  public void resize(int targetWidth, int targetHeight){
    image = (BufferedImage) image.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
  }
}