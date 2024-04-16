package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import game.RenderedEntity;

public class Button extends RenderedEntity{

  
  public Button(String url, int x, int y) {
    super(url,x,y);
  }
  
  public void draw(Graphics g) {
    g.drawImage(image, x ,y ,null);
  }
  public boolean clickedMe(MouseEvent e) {
    int pointX = e.getX();
    int pointY = e.getY();
    return (x<pointX && pointX<x+getWidth()) && (y<pointY && pointY<y+getHeight());
    
  }
  public void doTask(MouseEvent e){}
}
