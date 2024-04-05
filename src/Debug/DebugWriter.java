import java.io.*;
import java.util.Scanner;
public class DebugWriter{
  static BufferedWriter writer;
  static boolean toggled = false;
  // auto clears debug file
  static boolean autoClear = true;
  public DebugWriter(){
    String start = "";
    try {
      if (!autoClear){
      File f = new File("src/Debug/debug.txt");
      Scanner sc = new Scanner(f);
      while (sc.hasNextLine()) {
        start += sc.nextLine() + "\n";
        }  
      }
      writer = new BufferedWriter(new FileWriter("src/Debug/debug.txt"));
      writer.write(start);
    } catch (Exception e) {
      e.printStackTrace();
    }
  } 
  public static void write(String str, boolean b){
    try{
      if (b){
        writer.write(str+"\n");
        writer.flush();
      }
    }
    catch(IOException e){
    }
  }
  public static void write(String str){
    write(str,toggled);
  }
  public static void clear(){
    try{
        writer = new BufferedWriter(new FileWriter("src/Debug/debug.txt"));
      }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}