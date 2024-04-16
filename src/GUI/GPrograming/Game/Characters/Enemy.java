import java.util.*;
import java.awt.Point;
public class Enemy extends Character{
  int sight = 0;
  int range = 0;
  
	public Enemy(Animations annie, int x, int y){
    super(annie,x,y);
    sight = (int) (getWidth()*2.5);
    range = (int) (getWidth()*2);
  }
  public Enemy(String url,int x,int y){
    super(url,x,y);
  }
  public void setSight(int sight){
    this.sight = sight;
  }

  public void setRange(int range){
    this.range = range;
  }
	// Updates Enemy Stats 
  public void update(){
    followPlayer(GamePanel.getPlayer());
  }
  
	public void followPlayer(Player p){
		// if player is in sight range then move towards  the player until player is in attack range
		Point l = new Point (p.getX(),p.getY());
		// distance from this to p player
		double distance = distance(l,new Point(getX(),getY()));
		if(!(distance > range && distance < sight)){
      if(getX()<l.getX())
        x+=getStat("speed");
      else if(getX()>l.getX())
        x-=getStat("speed");
      if(getY()<l.getY())
        y+=getStat("speed");
      else if(getY()>l.getY())
        y-=getStat("speed");
		}
	}

	public double distance(Point p , Point p2){
// distance between 2 points
		return Math.hypot(p.getX() - p2.getX() , p.getY() - p2.getY());
	}
}