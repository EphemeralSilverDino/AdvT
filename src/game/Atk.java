package game;
import java.util.*;
public class Atk extends RenderedEntity { 
  int damage = 0;
  int xSpd = 0;
  int ySpd = 0;
  ArrayList<characters.Character> charactersHit = new ArrayList<characters.Character>();
  
  public Atk(Animations annie, int x, int y,int damage,int xSpd, int ySpd){
    super(annie,x,y);
    setDamage(damage);
    this.xSpd = xSpd;
    this.ySpd = ySpd;
  }
  
  public void setDamage(int damage){
    this.damage = damage;
  }

  public void doDmg(characters.Character c){
    if (!charactersHit.contains(c))
      if (this.collidesWith(c)){
        c.changeStat("health",-damage);
        charactersHit.add(c);
      }
  }
  public void move(){
    x+=xSpd;
    y+=ySpd;
  }
  
  public void setXSpd(int spd){
    xSpd = x;
  }
  public void setYSpd(int spd){
    ySpd = y;
  }
}