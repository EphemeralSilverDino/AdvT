import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.awt.geom.Point2D;
//JScrolls 
public class Door {
  
  int x;
  int y;
  int width;
  int height;
  BufferedImage texture = null;
  boolean render = true;
  String direction = "";
  public Door(String url, int x, int y, String direction){
    this.x = x;
    this.y = y;
    try{
      texture = ImageIO.read(new File(url));
      width = texture.getWidth();
      height = texture.getHeight();
      this.direction = direction;
    }
    catch(IOException e){
    }
  }
  
  public void draw(Graphics g){
		//Draw Door
    if (render)
      g.drawImage(this.texture, this.x, this.y, this.width, this.height, null);
  }
  
  public void setRender(boolean r){
    render =r;
  }
  
  public boolean getRender(){
    return render;
  }
  
  public String getDirection(){
    return direction;
  }

	
  // Not fully in but partially inside of the door
  public boolean isPointInsideMe(Point p){
    int x  = (int) p.getX();
    int y  = (int) p.getY();
    return (this.x < x && x <this.x+width) && (this.y < y && y <this.y+height);
  }
	
  // inside 
	public boolean collidesWith(Player player){
    
    if (isPointInsideMe(new Point(player.getX(),player.getY())) || isPointInsideMe(new Point(player.getX()+player.getWidth(),player.getY())))
      return true;
    if (isPointInsideMe(new Point(player.getX(),player.getY()+player.getHeight())))
      return true;
    if (isPointInsideMe(new Point(player.getX()+player.getWidth(),player.getY()+player.getHeight())))
      return true;
    return false;
  }

}