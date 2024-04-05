import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class Player extends Character{
  Point lastPos;
  ArrayList<String> directions = new ArrayList<String>();
  public Player(String url,int x, int y){
    super(url,x,y);
    System.out.println("Player character created");
    lastPos = new Point(x,y);
  }
  
  public void updateStats(){
    multiMove();
    System.out.println(directions);
  }
  
  public void accelerate(){
    if (running){
      stats.put("speed",stats.get("speedCap"));
    }
    else{
      stats.put("speed",stats.get("speedMin"));
    }
  }
  
  public void move(char c){
    if (c=='w'){
      y-=stats.get("speed");
    }
    if (c=='a'){
      x-=stats.get("speed");
    }
    if (c=='d'){
      x+=stats.get("speed");
    }
    if (c=='s'){
      y+=stats.get("speed");
    }
  }
  public void multiMove(){
    for (String str : directions){
      move(str.charAt(0));
    }
  }
  public void processKeyInput(char c){
    if ("wasd".contains(""+c)){
      addDirection(c);
    }  
    else if ((c+"").equals("r")){
      running = !running;
      accelerate();
    }
    
  }
  public void addDirection(char c){
    if (directions.indexOf(c+"")==-1 && "wasd".contains(""+c)){
      directions.add(c+"");
    }
  }
  public void processKeyRelease(char c){
    if (directions.indexOf(c+"")!=-1)
      directions.remove(directions.indexOf(c+""));
  }

}