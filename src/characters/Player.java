package characters;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

import game.Animations;
public class Player extends characters.Character{
  Point lastPos;
  ArrayList<String> directions = new ArrayList<String>();
  public Player(String url,int x, int y){
    super(url,x,y);
    System.out.println("Player character created");
    lastPos = new Point(x,y);
  }
  
  public Player (Animations annie, int x, int y){
    super(annie,x,y);
    System.out.println("Animated Player character created");
    lastPos = new Point(x,y);

  }
  
  public void update(){
    super.update();
    multiMove();
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
    else if (c=='a'){
      x-=stats.get("speed");
    }
    else if (c=='d'){
      x+=stats.get("speed");
    }
    else if (c=='s'){
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