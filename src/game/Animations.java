package game;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.Image;

public class Animations{
  int currentFrame = 0;
  BufferedImage[] frames;
  public Animations (String[] frames){
    this.frames = new BufferedImage[frames.length];
    for ( int i=0;i<frames.length;i++){
      try{
        this.frames[i] = ImageIO.read(new File(frames[i]));
      }
      catch(Exception e){
        e.printStackTrace();
      }
    }
  }
  
  public Animations (String spriteSheet, int rows, int cols){
    BufferedImage mainImage = RenderedEntity.getLoadedImage(spriteSheet);
    frames = new BufferedImage[rows*cols];
    int width = mainImage.getWidth()/cols;
    int height = mainImage.getHeight()/rows;
    for (int row = 0;row<rows;row++){
      for (int col = 0; col<cols;col++){
          frames[row*cols+col] = mainImage.getSubimage(
              col * width,
              row * height,
              width,
              height
          );
      }
    }
  }
 
  public void update(){
    currentFrame++;
    if(currentFrame>frames.length-1){
      currentFrame=0;
    }
  }
  
  public BufferedImage getCurrentFrame(){
    return frames[currentFrame];
  }
  
}