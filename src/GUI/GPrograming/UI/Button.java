
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Button {
  private int x; 
  private int y;
  private int width;
  private int height;
  private BufferedImage icon;
  
  public Button(String url, int x, int y) {
    try {
      icon = ImageIO.read(new File(url));
      width = icon.getWidth();
      height = icon.getHeight();
      this.x=x;
      this.y=y;
    }
    catch (IOException e){
    }
  }
  
  public void draw(Graphics g) {
    g.drawImage(icon, x ,y ,null);
  }
  public boolean clickedMe(MouseEvent e) {
    int pointX = e.getX();
    int pointY = e.getY();
    return (x<pointX && pointX<x+width) && (y<pointY && pointY<y+height);
    
  }
  public void doTask(MouseEvent e){}
}
