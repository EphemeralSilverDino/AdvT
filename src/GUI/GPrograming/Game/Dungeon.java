import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import org.junit.internal.matchers.StacktracePrintingMatcher;
import javax.swing.JOptionPane;
import java.awt.*;
public class Dungeon{
	Room mainRoom;
  int rTotal = 15;
  int size = 7;
  Room[][] map;
  Point CR;
  Point currentRoom;
  //Door door = new Door("src/GUI/Images/DungeonDoor.png",250,360);
  // 0 up 1 right 2 down 3 left
  Door[] doors = new Door[] {new Door("src/GUI/Images/DungeonDoor.png",400,0,"up"),new Door("src/GUI/Images/DoorLeft.png",810,350,"left"),new Door("src/GUI/Images/DungeonDoor.png",400,600,"down"),new Door("src/GUI/Images/DoorLeft.png",0,400,"right")};
  public Dungeon(){
    this(new Room("src/GUI/Images/Room.png",0,0),7);
  }
  
  public Room getMainRoom(){
    return mainRoom;
  }
  
  public Dungeon(Room room, int size){
    this.size=size;
    mainRoom = room;
    map = new Room[size][size];
    setUpMainRoom();
  }
  
  public Dungeon(Room room){
    this(room,7);
  }
  
  public Room[][] getDungeonMap(){
    return map;
  }
  public Door[] getDoors(){
    return doors;
  }
  // 0 up
  // 1 left
  // 2 down
  // 3 right
  public void setUpMainRoom(){
    int centerX = map.length/2;
    int centerY = map.length/2;
    CR = new Point(centerX,centerY);
    currentRoom = new Point(centerX,centerY);
    map[centerX][centerY] = mainRoom;
    mainRoom.setLocation(new Point(centerX,centerY));
  }
  
  public void populateRooms(int count){
    generateRoom(mainRoom,count);
  }
  public void setDoorRender(){
    for (Door d: doors){
      d.setRender(false);
    }
    int x = (int) currentRoom.getX();
    int y = (int) currentRoom.getY();
    try{
      if(map[x][y-1]!=null){
        doors[0].setRender(true);
      }
      if(map[x+1][y]!=null){
        doors[1].setRender(true);
      }
      if(map[x][y+1]!=null){
        doors[2].setRender(true);
      }
      if(map[x-1][y]!=null){
        doors[3].setRender(true);
      }
    }
    catch(IndexOutOfBoundsException e){
    }
  }
  
  public void draw(Graphics g){
    int x = (int) currentRoom.getX();
    int y = (int) currentRoom.getY();
    map[x][y].draw(g);
    for (Door d : doors){
      if(d.getRender())
        d.draw(g);
    }
  }
  // do door collisions 
  public Point getCurrentRoom(){
    return currentRoom;
  }
  public void move(Point p, String direction){
    if (direction.equalsIgnoreCase("up")){
      p.translate(0,-1);
    }
    else if (direction.equalsIgnoreCase("down")){
      p.translate(0,1);
    }
    else if (direction.equalsIgnoreCase("left")){
      p.translate(1,0);
    }
    else if (direction.equalsIgnoreCase("right")){
      p.translate(-1,0);
    }  
  }
  
  public boolean outOfBounds(Point p){
    int x = (int) p.getX();
    int y = (int) p.getY();
    return !(0<=x && x<map.length && 0<=y && y<map.length);
  }
  
  public boolean hasSpace(Point p){
    int x = (int) p.getX();
    int y = (int) p.getY();
    int openSides = 0;
    try{
      openSides = map[x-1][y] ==null ? openSides+1 : openSides;
      openSides = map[x+1][y]==null ? openSides+1 : openSides;
      openSides = map[x][y-1]==null ? openSides+1 : openSides;
      openSides = map[x][y+1]==null ? openSides+1 : openSides;
    }
    catch(IndexOutOfBoundsException e){
    }
    return openSides>=2;
  }
  
  int loops =0;
  public void generateRoom(Room room,int count){
    if (room==null){
      room = pickRoom();
    }
    int x = (int) room.getLocation().getX();
    int y = (int) room.getLocation().getY();
      CR = new Point(x,y);
    Point temp = new Point(x,y);
    if (count<rTotal){
      String[] directions= {"up","left","down","right"};
      String direction = directions[rollDie(4)];
      move(temp,direction);
      x = (int) temp.getX();
      y = (int) temp.getY();
      if (outOfBounds(temp) || map[x][y]!=null || (!hasSpace(temp) && loops<125)){
        generateRoom(pickRoom(),count);
      }
      else {
        if (map[x][y]==null){
          Room newRoom = new Room(room,"src/GUI/Images/DungeonBackground.png",0,0);
          newRoom.setLocation(new Point(x,y));
            CR = new Point(x,y);
          map[x][y] = newRoom;
          count++;
          generateRoom(map[x][y],count);
        }
      }
    }
  }
  public Room pickRoom(){
    loops++;
    for(int i=0;i<map.length;i++){
      for (int j=0;j<map.length;j++){
        if (map[i][j]!=null && rollDie(5)>2){
          return map[i][j];
        }
      }
    }
    return pickRoom();
  }
	// Randomize Dice Roll
  public int rollDie(int sides){
    return (int) (Math.random()*sides);
  }
}