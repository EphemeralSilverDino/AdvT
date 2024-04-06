import java.awt.image.BufferedImage;
import java.util.*;
import java.io.File;
import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
public class Bar{
  int fullness = 100;
  
  RenderedEntity bar = null;
  RenderedEntity meter = null;
  int statisic = 0;
  public Bar(String bUrl, String mUrl, int x, int y){
    bar = new RenderedEntity(bUrl,x,y);
    meter = new RenderedEntity(mUrl,x+10,y+10);
  }
  
  public void draw(Graphics g){
    meter.draw(g);
    bar.draw(g);
  }
}