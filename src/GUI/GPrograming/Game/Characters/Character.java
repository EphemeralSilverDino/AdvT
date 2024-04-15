import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;

public class Character extends RenderedEntity{
  HashMap<String,Integer> stats = new HashMap<>();
  ArrayList<StatEffect> effects = new ArrayList<>();
  ArrayList<Atk> attacks = new ArrayList<>();
  boolean visible = true;
  boolean moving = false;
  boolean running = false;
  
  public Character (String url, int x, int y){
		super(url,x,y);
    setDefaultStats();
	}
  
  public Character(Animations annie, int x, int y){
    super(annie,x,y);
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
  
  public int getStat(String key){
    return stats.get(key);
  }
  public void setStat(String key, int val){
    stats.put(key,val);
    normalizeStat(key);
  }
  public void normalizeStat(String key){
    if (stats.get(key)<0)
      stats.put(key,0);
  }
  
  public void changeStat(String key, int val){
    stats.put(key,stats.get(key)+val);
    normalizeStat(key);
  }
  
  public void update(){
    super.update();
    for (StatEffect e : effects){
      StatEffectHandler.handleEffect(e,this);
    }
  }
  
  public void setRunning(boolean b){
    running = b;
  }
  
  
	public void draw(Graphics g){
    update();
    if (visible)
		   g.drawImage(image,x,y,null);
	}
  
	public void changeVisibility(){
		visible = !visible;
	}
	
  public void setVisibility(boolean b){
    visible = b;
  }

  public void teleport(int x, int y){
    this.x = x;
    this.y = y;
  }
}