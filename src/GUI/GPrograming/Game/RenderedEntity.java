import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.Point;
public class RenderedEntity{
  int x;
  int y;
  BufferedImage image; 
  boolean animated = false;
  ArrayList<Animations> annies = new ArrayList<>();
  int currentAnnie = 0;
  
  public static BufferedImage getLoadedImage(String imageUrl){
    BufferedImage loadedImage=null;
    try{
      loadedImage = ImageIO.read(new File(imageUrl));
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return loadedImage;
  }
  
  public RenderedEntity(String imageUrl, int x, int y){
    this.x=x;
    this.y=y;
    image = getLoadedImage(imageUrl);
    
  }
  
  public RenderedEntity(Animations annie,int x, int y){
    annies.add(annie);
    image = annies.get(currentAnnie).getCurrentFrame();
    this.x=x;
    this.y=y;
    animated = true;
  }
  
  public int getX(){
    return x;
  }
  
  public int getY(){
    return y;
  }
  
  public int getHeight(){
    return image.getHeight();
  }
  
  public int getWidth(){
    return image.getWidth();
  }
  public void update(){
    if (animated){
      annies.get(currentAnnie).update();
      image = annies.get(currentAnnie).getCurrentFrame();
    }
  }
  public void draw(Graphics g){
    if (animated){
      BufferedImage cFrame = annies.get(currentAnnie).getCurrentFrame();
      g.drawImage(cFrame,x,y,null);
    }
    else{
      g.drawImage(image,x,y,null);
    }
  }
  
  public void resize(int targetWidth, int targetHeight){
    BufferedImage scaledImage = new BufferedImage(targetWidth,targetHeight,BufferedImage.TYPE_4BYTE_ABGR
);
    double scaleW = (double) targetWidth / getWidth();
    double scaleH = (double) targetHeight / getHeight();
   AffineTransform at = new AffineTransform();
    at.scale(scaleW,scaleH);
    AffineTransformOp scaleOp = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
    image = scaleOp.filter(image,scaledImage);
  }
  
  public void addAnnie(Animations annie){
    annies.add(annie);
  }
  
  public boolean collidesWith(RenderedEntity other){
    return inMe(other) || other.inMe(this);
  }
  
  public boolean inMe(RenderedEntity o){
    Point topLeft = new Point (o.getX(),o.getY());
    Point topRight = new Point (o.getX()+o.getWidth(),o.getY());
    Point bottomLeft = new Point (o.getX(),o.getY()+o.getHeight());
    Point bottomRight = new Point (o.getX()+o.getWidth(),o.getY()+o.getHeight());
    
    return pInMe(topLeft) && pInMe(topRight) && pInMe(bottomLeft) && pInMe(bottomRight);
  }
  
  public boolean pInMe(Point p){
    return (getX()<=p.getX() && p.getX() <= getX()+getWidth()) && (getY()<= p.getY() && p.getY()<=getY()+getHeight());
  }
  
  
  
}