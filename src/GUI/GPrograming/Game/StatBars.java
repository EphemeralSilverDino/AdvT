import java.awt.image.BufferedImage;
import java.util.*;
import java.io.File;
import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;

public class StatBars{
  
  BufferedImage hpBar = null;
  int hpPercent = 100;
  int ManaPercent = 100;
  BufferedImage manaBar = null;
  int x = 0;
  int y = 0;
  
  public StatBars(int x, int y){
    this.x=x;
    this.y=y;
    try{
      hpBar= ImageIO.read(new File("src/GUI/Images/HealthBar.png"));
    manaBar= ImageIO.read(new File("src/GUI/Images/ManaBar.png"));
    }  
    catch(Exception e){
    }   
  }
  public void updateHP(int hp, int hpMax){
    hpPercent = hp*100/hpMax;
  }
  public void updateMana(int mana, int manaMax){
      ManaPercent = mana*100/manaMax;
  }
  public void draw(Graphics g){
    //g.setColor(Color.black);
    g.drawImage(hpBar,x,y,null); //50
    g.drawImage(manaBar,x,y+60,null);
  }
}
