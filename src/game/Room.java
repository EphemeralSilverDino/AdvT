package game;
import java.io.IOException;
import javax.imageio.ImageIO;

import debug.DebugWriter;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.awt.geom.Point2D;
//JScrolls 
public class Room {
  private int x;
  private int y;
  private BufferedImage texture = null;
  private Animations animations;
  private int width;
  private int height;
  Room parentRoom = null;
  Point location;
  static int depth=0;
  Animations annie = null;
  boolean animated = false;
  public void setLocation(Point p){
    location = p;
  }
  public Point getLocation(){
    return location;
  }
  
  public Room(Room r, String url, int x, int y){
    this(url,x,y);
    parentRoom = r;
  }
  public Room(String url, int x, int y,int rows,int cols){
    this.x=x;
    this.y=y;
    animated = true;
    annie = new Animations(url,rows,cols);
    depth++;
  }
  
  public Room(String url, int x, int y){
    this.x=x;
    this.y=y;
    try{
      texture = ImageIO.read(new File(url));
      width = getWidth();
      height = getHeight();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    DebugWriter.write("creating a room");
    depth++;
  }
  public void update(){
    if (animated){
      annie.update();
    }
  }
	public void draw(Graphics g){
    if (animated){
      g.drawImage(annie.getCurrentFrame(),x,y,null);
    }
    else{
      g.drawImage(this.texture, this.x, this.y, this.width, this.height, null);
    }
	}
  // 0 up
  // 1 left
  // 2 down
  // 3 right

  public String toString(){
    return ""+depth;
  }
  public int getWidth(){
    return width;
  }
  public int getHeight(){
    return height;
  }
}