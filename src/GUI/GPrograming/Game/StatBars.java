import java.awt.image.BufferedImage;
import java.util.*;
import java.io.File;
import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;

public class StatBars{
  
  RenderedEntity hpBar = null;
  RenderedEntity hpGauge = null;
  int hpPercent = 100;
  int ManaPercent = 100;
  RenderedEntity manaBar = null;
  RenderedEntity manaGauge = null;

  int x = 0;
  int y = 0;
  
  public StatBars(int x, int y){
    this.x=x;
    this.y=y;
    hpBar = new RenderedEntity("src/GUI/Images/HealthBar.png",x,y);
    manaBar = new RenderedEntity("src/GUI/Images/ManaBar.png",x,y+60);
    manaGauge = new RenderedEntity("src/GUI/Images/ManaGuage.png",x,y+60);
    hpGauge = new RenderedEntity("src/GUI/Images/HealthGuage.png",x,y);
    manaBar.resize(180,45);
    hpBar.resize(180,45);
    manaGauge.resize(90,45);
    hpGauge.resize(120,45);
  }
  
  public void updateHP(int hp, int hpMax){
    hpPercent = hp*100/hpMax;
  }
  
  public void updateMana(int mana, int manaMax){
      ManaPercent = mana*100/manaMax;
  }
  public void draw(Graphics g){
    //g.setColor(Color.black);
    hpGauge.draw(g);
    hpBar.draw(g);
    manaGauge.draw(g);
    manaBar.draw(g);
  }
}
