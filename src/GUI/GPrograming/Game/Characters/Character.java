import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;

public class Character{
	int x;
	int y;
	BufferedImage sprite;
  HashMap<String,Integer> stats = new HashMap<>();
  boolean visible = true;
  boolean moving = false;
  boolean running = false;
  
  public Character (String url, int x, int y){
		this.x=x;
    this.y=y;
    try{
      sprite = ImageIO.read(new File(url));
    }
    catch(Exception e){
    }
    setDefaultStats();
	}
  
  public void setDefaultStats(){
    stats.put("maxHp",100);
    stats.put("hp",100);
    stats.put("intellgence",0);
    stats.put("strength",0);
    stats.put("dexterity",0);
    stats.put("speedCap",6);
    stats.put("speed",2);
    stats.put("speedMin",2);
    stats.put("mana",100);
    stats.put("manaMax",100);
    
  }
  
  
  
  public void tick(){
    updateStats();
  }
  
  public void setRunning(boolean b){
    running = b;
  }
  
  public void updateStats(){
  }
  
	public void draw(Graphics g){
    updateStats();
    tick();
    if (visible)
		   g.drawImage(sprite,x,y,null);
	}
  
	public void changeVisibility(){
		visible = !visible;
	}
	
  public void setVisibility(boolean b){
    visible = b;
  }
  
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public int getWidth(){
    return sprite.getWidth();
  }
  public int getHeight(){
    return sprite.getHeight();
  }
  public void teleport(int x, int y){
    this.x = x;
    this.y = y;
  }
}