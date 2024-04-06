import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.awt.geom.Point2D;
//JScrolls 
public class Room{
  private int x;
  private int y;
  private BufferedImage texture = null;
  private int width;
  private int height;
  Room parentRoom = null;
  Point location;
  static int depth=0;

  public void setLocation(Point p){
    location = p;
  }
  public Point getLocation(){
    return location;
  }
  public Room(Room r, String url, int x1, int y1){
    this(url,x1,y1);
    parentRoom = r;
  }
  public Room(String url, int x, int y){
    this.x = x;
    this.y = y;
    try{
      texture = ImageIO.read(new File(url));
      width = texture.getWidth();
      height = texture.getHeight();
    }
    catch(IOException e){
    }
    DebugWriter.write("creating a room");
    depth++;
  }
  
	public void draw(Graphics g){
		g.drawImage(this.texture, this.x, this.y, this.width, this.height, null);
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