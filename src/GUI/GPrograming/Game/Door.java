import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.awt.geom.Point2D;
//JScrolls 
public class Door extends RenderedEntity{
  
  BufferedImage texture = null;
  boolean render = true;
  String direction = "";
  public Door(String url, int x, int y, String direction){
    super(url,x,y);
    this.direction = direction;
    
  }
  public void draw(Graphics g){
		//Draw Door
    if (render)
      g.drawImage(image, this.x, this.y, this.getWidth(), this.getHeight(), null);
  }
  
  public void setRender(boolean r){
    render = r;
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
    return (this.x < x && x <this.x+this.getWidth()) && (this.y < y && y <this.y+this.getHeight());
  }
  // inside 
	public boolean collidesWith(Player player){
    
    if (isPointInsideMe(new Point(player.getX(),player.getY())) || isPointInsideMe(new Point(player.getX()+player.getWidth(),player.getY())))
      return true;
    else if (isPointInsideMe(new Point(player.getX(),player.getY()+player.getHeight())))
      return true;
    else if (isPointInsideMe(new Point(player.getX()+player.getWidth(),player.getY()+player.getHeight())))
      return true;
    return false;
  }
}